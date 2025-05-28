package com.sake.module.order;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;
import com.sake.user.cart.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@Value("${toss.secret.key}")
	private String SECRET_KEY;
	

	 

	 @GetMapping("/api/order-id")
	 @ResponseBody
	 public Map<String, String> preparePayment() {
	     String uuid = UUID.randomUUID().toString(); // 랜덤한 UUID 생성
	     String orderId = "order-" + uuid; // 예: order-c1b6a9f8-5f6a-4e89-95d1-73830fc937f2

	     Map<String, String> response = new HashMap<>();
	     response.put("orderId", orderId);
	     return response;
	 }
	 
	 
	
	 
	 @GetMapping("/success")
	 public String paymentSuccessPage() {
		 return "xdm/payment/paymentSuccess";  // 결제 성공
	  } 
	 
	 
	    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    private static final String WIDGET_SECRET_KEY = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";
	    private static final String API_SECRET_KEY = "test_sk_zXLkKEypNArWmo50nX3lmeaxYG5R";
	    private final Map<String, String> billingKeyMap = new HashMap<>();

	    @RequestMapping(value = {"/confirm/widget", "/confirm/payment"})
	    public ResponseEntity<JSONObject> confirmPayment(HttpServletRequest request, @RequestBody String jsonBody) throws Exception {
	        String secretKey = request.getRequestURI().contains("/confirm/payment") ? SECRET_KEY : WIDGET_SECRET_KEY;
	        JSONObject response = sendRequest(parseRequestData(jsonBody), secretKey, "https://api.tosspayments.com/v1/payments/confirm");
	        int statusCode = response.containsKey("error") ? 400 : 200;
	        if(!response.containsKey("error")){
	        	String orderId = (String) response.get("orderId");
	        	String[] parts = orderId.split("_");
	        	Long totalAmountLong = (Long) response.get("totalAmount");
	        	int totalAmount = totalAmountLong.intValue();  // ✅ 안전하게 int로 변환
	        	String seq = parts[2];
//	        	String userOrder_od_id = parts[2];
	        	OrderDto dto = new OrderDto();
	        	dto.setUser_user_id(seq);
	        	dto.setAll_payment(totalAmount);

	        	service.Uoinsert(dto); // insert 실행

	        	String generatedId = dto.getOd_id(); // insert 후 자동 세팅된 id 꺼내기
	        	
	        	 if (parts.length == 3) {
	        	        String cartSeqPart = parts[1]; // 예: "6-7-8"
	        	        String[] cartIds = cartSeqPart.split("-");
	        	        for (String cart_id : cartIds) {
	        	        	service.Opinsert(cart_id, generatedId);
	        	        }
	        	 }
	        }
	        return ResponseEntity.status(statusCode).body(response);
	    }

//	    @RequestMapping(value = "/confirm-billing")
//	    public ResponseEntity<JSONObject> confirmBilling(@RequestBody String jsonBody) throws Exception {
//	        JSONObject requestData = parseRequestData(jsonBody);
//	        String billingKey = billingKeyMap.get(requestData.get("customerKey"));
//	        JSONObject response = sendRequest(requestData, API_SECRET_KEY, "https://api.tosspayments.com/v1/billing/" + billingKey);
//	        return ResponseEntity.status(response.containsKey("error") ? 400 : 200).body(response);
//	    }

//	    @RequestMapping(value = "/issue-billing-key")
//	    public ResponseEntity<JSONObject> issueBillingKey(@RequestBody String jsonBody) throws Exception {
//	        JSONObject requestData = parseRequestData(jsonBody);
//	        JSONObject response = sendRequest(requestData, API_SECRET_KEY, "https://api.tosspayments.com/v1/billing/authorizations/issue");
//
//	        if (!response.containsKey("error")) {
//	            billingKeyMap.put((String) requestData.get("customerKey"), (String) response.get("billingKey"));
//	        }
//
//	        return ResponseEntity.status(response.containsKey("error") ? 400 : 200).body(response);
//	    }

//	    @RequestMapping(value = "/callback-auth", method = RequestMethod.GET)
//	    public ResponseEntity<JSONObject> callbackAuth(@RequestParam String customerKey, @RequestParam String code) throws Exception {
//	        JSONObject requestData = new JSONObject();
//	        requestData.put("grantType", "AuthorizationCode");
//	        requestData.put("customerKey", customerKey);
//	        requestData.put("code", code);
//	        
//	        String url = "https://api.tosspayments.com/v1/brandpay/authorizations/access-token";
//	        JSONObject response = sendRequest(requestData, API_SECRET_KEY, url);
//
//	        logger.info("Response Data: {}", response);
//
//	        return ResponseEntity.status(response.containsKey("error") ? 400 : 200).body(response);
//	    }

//	    @RequestMapping(value = "/confirm/brandpay", method = RequestMethod.POST, consumes = "application/json")
//	    public ResponseEntity<JSONObject> confirmBrandpay(@RequestBody String jsonBody) throws Exception {
//	        JSONObject requestData = parseRequestData(jsonBody);
//	        String url = "https://api.tosspayments.com/v1/brandpay/payments/confirm";
//	        JSONObject response = sendRequest(requestData, API_SECRET_KEY, url);
//	        return ResponseEntity.status(response.containsKey("error") ? 400 : 200).body(response);
//	    }

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

	        try (InputStream responseStream = connection.getResponseCode() == 200 ? connection.getInputStream() : connection.getErrorStream();
	             Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8)) {
	            return (JSONObject) new JSONParser().parse(reader);
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

	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String index() {
	        return "/widget/checkout";
	    }

	    @RequestMapping(value = "/fail", method = RequestMethod.GET)
	    public String failPayment(HttpServletRequest request, Model model) {
	        model.addAttribute("code", request.getParameter("code"));
	        model.addAttribute("message", request.getParameter("message"));
	        return "/fail";
	    }
	    
	    
	    
	  //주문내역
		@RequestMapping(value="UserOrderDetails")
		public String UserOrderDetails(HttpSession httpSession, OrderDto dto, Model model) {
			dto.setUser_user_id(httpSession.getAttribute("sessSeqUser").toString());
			
			
			List<String> odIdList = service.findUserUoseq(dto.getUser_user_id());
			model.addAttribute("lists",	service.findOpList(odIdList));
			
			
			return "/user/account/UserOrderDetails";
		}
	}
	  
	  
	  

