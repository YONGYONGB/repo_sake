package com.sake.module.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sake.module.base.BaseController;
import com.sake.module.code.CodeService;

import jakarta.servlet.http.HttpServletResponse;





@Controller
@RequestMapping(value="/xdm/product/")
public class ProductController extends BaseController{

	@Autowired
	ProductService productservice;
	
	
	
	@RequestMapping(value = "ProductXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo vo,Model model) {
		
		addEnd(vo);
		
		vo.setParamsPaging(productservice.selectOneCount(vo));
		model.addAttribute("list", productservice.selectList(vo));
		return "/xdm/product/ProductXdmList";
	}
	
	
	@RequestMapping(value ="ProductXdmForm")
	public String productXdmForm(@ModelAttribute("vo") ProductVo vo, ProductDto dto, Model model)throws Exception{
	
		model.addAttribute("lists", productservice.dcView());
	
		if (vo.getPd_id().equals("0") || vo.getPd_id().equals("")) {
//			insert mode
		
		} else {
//			update mode
			model.addAttribute("item", productservice.selectView(dto));
			
		}
		return "/xdm/product/ProductXdmForm";
	}
	
	@RequestMapping(value="ProductXdmInsert")
	public String productXdmInsert(ProductDto dto) throws Exception{
		productservice.insert(dto);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value="ProductXdmUpdate")
	public String productXdmUpdate(@RequestParam("ld") Integer ld,ProductDto dto) throws Exception{
		if(dto.getLocal_detail()== null){
			dto.setLocal_detail(ld);
		}
		productservice.update(dto);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	@RequestMapping(value="ProductXdmUelete")
	public String ProductXdmUelete(@RequestParam("pd_id") List<Integer>pdIdList) {
		productservice.uelete(pdIdList);
		return "redirect:/xdm/product/ProductXdmList";
	}
	
	
	// 자바스크립트 local_detail을 위한
	@ResponseBody
	@RequestMapping(value="Productlocaldetail")
    public List<ProductDto> getChildCodes(@RequestParam("cd_id") String cd_id) {
        return productservice.localcheck(cd_id);
    }
	
	
	
	
	
	
	//excel
	
	@Autowired
	CodeService codeService;
	
	@GetMapping("excel")
	public void exportToExcel(HttpServletResponse response,@ModelAttribute("vo") ProductVo vo) throws IOException { //HttpServletResponse response:  Spring이 제공하는 객체로, 사용자의 브라우저에 응답을 직접 보낼 수 있게 해줍니다., 보통 HTML 텍스트를 보내기도 하지만, 여기선 **파일(엑셀 파일)**을 보내는 용도
	    // 파일 이름 및 타입 설정
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //이 응답은 엑셀(xlsx) 파일: 브라우저는 받은 응답이 어떤 종류의 데이터인지 알아야 합 -> application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" 는 .xlsx 형식의 표준
	    response.setHeader("Content-Disposition", "attachment; filename=export.xlsx"); //"Content-Disposition" 헤더는 브라우저가 이걸 "다운로드할 파일"로 처리하라고 지시, attachment" → 이걸 브라우저에 바로 표시하지 말고, 다운로드하게 함,
	    																				//filename=export.xlsx" → 다운로드될 때 기본 파일 이름이 export.xlsx가 되도록 설정
	    // DB에서 데이터 가져오기 (예: user 리스트)
	    List<ProductDto> ProductList = productservice.selectList(vo);

	    // 엑셀 생성
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Users");

	    // 헤더 행 작성
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("SEQ");
	    headerRow.createCell(1).setCellValue("제품이름");
	    headerRow.createCell(2).setCellValue("일본지역");
	    headerRow.createCell(3).setCellValue("상세지역");
	    headerRow.createCell(4).setCellValue("브랜드");
	    headerRow.createCell(5).setCellValue("가격");

	    // 데이터 채우기
	    int rowNum = 1;
	    for (ProductDto list : ProductList) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(list.getPd_id());
	        row.createCell(1).setCellValue(list.getName());
	        row.createCell(2).setCellValue(list.getLocal());
	        row.createCell(3).setCellValue(list.getLocal_detail());
	        row.createCell(4).setCellValue(list.getBrand());
	        row.createCell(5).setCellValue(list.getFixed_price());
	    }

	    // 파일 응답으로 전송
	    workbook.write(response.getOutputStream());
	    workbook.close();
	}
	
	
	@PostMapping("uploadExcel")
    public String uploadExcel(@RequestParam("file") MultipartFile file, Model model) {
        // 1. 파일 확장자 검사
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || 
            !(originalFilename.endsWith(".xls") || originalFilename.endsWith(".xlsx"))) {
            model.addAttribute("message", "엑셀 파일(.xls, .xlsx)만 업로드 가능합니다.");
            return "uploadResult";  // 결과 페이지 이름 (임의)
        }

        // 2. 용량 제한 (예: 최대 5MB)
        long maxSize = 5 * 1024 * 1024; // 5MB
        if (file.getSize() > maxSize) {
            model.addAttribute("message", "파일 크기는 5MB를 초과할 수 없습니다.");
            return "uploadResult";
        }

        try (InputStream is = file.getInputStream()) {
            // 3. Apache POI로 엑셀 파일 읽기
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                // 예시: 첫 번째 행은 헤더라면 건너뛰기
                if (row.getRowNum() == 0) continue;

                // 엑셀 데이터 읽기 예: 첫 번째 컬럼 데이터 읽기
                Cell cell0 = row.getCell(0);
                String data = cell0.getStringCellValue();

                // TODO: 읽은 데이터를 DTO에 담아 서비스 통해 DB 저장 처리
                System.out.println("엑셀 데이터: " + data);
            }

            workbook.close();
            model.addAttribute("message", "업로드 및 데이터 처리 성공!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 처리 중 오류가 발생했습니다.");
        }

        return "uploadResult";
    }
	
}
