package com.sake.module.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sake.user.cart.CartService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class OrderController {
	
	@Autowired
	CartService cartService;
	
	@Value("${toss.secret.key}")
	private String SECRET_KEY;
	
	 private static int counter = 30;

	 @GetMapping("/api/order-id")
	 @ResponseBody
	 public Map<String, String> preparePayment() {  //uuid 방법도 있다는점.
	     String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	     String orderId = date + "-" + (++counter);

	     Map<String, String> response = new HashMap<>();
	     response.put("orderId", orderId);

	     return response;
	 }
	 
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 private static final String WIDGET_SECRET_KEY = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";
//	 private static final String API_SECRET_KEY = "test_sk_zXLkKEypNArWmo50nX3lmeaxYG5R";
	 private final Map<String, String> billingKeyMap = new HashMap<>();
	    
	 @RequestMapping(value = "/fail", method = RequestMethod.GET)
	    public String failPayment(HttpServletRequest request, Model model) {
	        model.addAttribute("code", request.getParameter("code"));
	        model.addAttribute("message", request.getParameter("message"));
	        return "/fail";
	    }
	
	 
	 @GetMapping("/success")
	 public String paymentSuccessPage() {
		 return "xdm/payment/paymentSuccess";  // 결제 성공
	  } 
	 
	 
	 
	 
	 @RequestMapping(value = {"/confirm/widget", "/confirm/payment"})
	    public ResponseEntity<JSONObject> confirmPayment(HttpServletRequest request, @RequestBody String jsonBody) throws Exception {
	        String secretKey = request.getRequestURI().contains("/confirm/payment") ? SECRET_KEY : WIDGET_SECRET_KEY;
	        JSONObject response = sendRequest(parseRequestData(jsonBody), secretKey, "https://api.tosspayments.com/v1/payments/confirm");
	        if (!response.containsKey("error")) {
	            String orderId = (String) parseRequestData(jsonBody).get("orderId");

	            

	            logger.info("장바구니 비움 완료: orderId = {}", orderId);
	        }
	        int statusCode = response.containsKey("error") ? 400 : 200;
	        return ResponseEntity.status(statusCode).body(response);
	    }
	  private JSONObject parseRequestData(String jsonBody) {
	        try {
	            return (JSONObject) new JSONParser().parse(jsonBody);
	        } catch (ParseException e) {
	            logger.error("JSON Parsing Error", e);
	            return new JSONObject();
	        }
	    }
	  private JSONObject sendRequest(JSONObject requestData, String secretKey, String urlString) throws IOException {
		    HttpURLConnection connection = createConnection(secretKey, urlString);

		    try (OutputStream os = connection.getOutputStream()) {
		        os.write(requestData.toString().getBytes(StandardCharsets.UTF_8));
		    }

		    try (InputStream responseStream = connection.getResponseCode() == 200
		            ? connection.getInputStream()
		            : connection.getErrorStream();
		         BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream, StandardCharsets.UTF_8))) {

		        // Reader → String 변환
		        StringBuilder responseBuilder = new StringBuilder();
		        String line;
		        while ((line = reader.readLine()) != null) {
		            responseBuilder.append(line);
		        }

		        return (JSONObject) new JSONParser().parse(responseBuilder.toString());

		    } catch (Exception e) {
		        logger.error("Error reading response", e);
		        JSONObject errorResponse = new JSONObject();
		        errorResponse.put("error", "Error reading response");
		        return errorResponse;
		    }
		}
	  
	  private HttpURLConnection createConnection(String secretKey, String urlString) throws IOException {
	        URL url = new URL(urlString);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((secretKey + ":").getBytes(StandardCharsets.UTF_8)));
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        return connection;
	    }
	  
	  
	  
	  
	  
}
