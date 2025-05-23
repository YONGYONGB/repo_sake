package com.sake.module.base;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sake.module.product.ProductDao;
import com.sake.module.product.ProductDto;

@Service
public class BaseService {

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	@Autowired
	BaseDao dao;
	
	@Autowired
	ProductDao pdao;
	
//		public class UtilDateTime {
//			public static String nowString() {
//				return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			}
//		}	
	
		public void uploadFilesToS3(ProductDto dto, String tableName, int type, String pSeq, BaseDao dao, AmazonS3Client amazonS3Client) throws Exception {
		

		
			for(int i=0; i<dto.getUploadImg1().length; i++) {
			
				if(!dto.getUploadImg1()[i].isEmpty()) {
				
//				String className = dto.getClass().getSimpleName().toString().toLowerCase();
//				// 접두사: 4, 접미사: uploaded (8) 삭제	
					String originefileName = dto.getUploadImg1()[i].getOriginalFilename();    // 로컬에 있는건 필요없음.
					String ext = originefileName.substring(originefileName.lastIndexOf(".") + 1);
					String uuid = UUID.randomUUID().toString();
					String uuidFileName = uuid + "." + ext;
					String path = tableName.substring(0,tableName.length()-8) + "/";
					String fileName=  path + pSeq + "." + ext;
//					String nowString = UtilDateTime.nowString();
////					String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
//					String path = pathModule + "/" + type + "/" + pathDate + "/";
//					String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
				
			        ObjectMetadata metadata = new ObjectMetadata();    
			        metadata.setContentLength(dto.getUploadImg1()[i].getSize());
			        metadata.setContentType(dto.getUploadImg1()[i].getContentType());
		        
			        amazonS3Client.putObject(bucket, path + fileName, dto.getUploadImg1()[i].getInputStream(), metadata); // thread처
	//		        https://doris-tt.s3.ap-northeast-2.amazonaws.com/Goods/1002/2025/04/17/de100958-3684-4ed1-94d9-de77c98dbb94.jpeg
			        
			        String objectUrl = amazonS3Client.getUrl(bucket,path + fileName).toString();
			        
			        int count = pdao.urlcount(pSeq);
			        dto.setCount(count);
			        if(count == 0){
			        	dto.setTableName(tableName);
						dto.setPath(objectUrl);
  						dto.setOriginalName(fileName);   
  						dto.setUuidName(uuidFileName);
						dto.setExt(ext);
						dto.setSize(dto.getUploadImg1()[i].getSize());
//					dto.setType(type);  // 크기정도?
		//			dto.setDefaultNy();
//					dto.setSort(maxNumber + i);
						dto.setPseq(pSeq);
						dao.insertUploaded(dto);
			        }else{
			        	dto.setTableName(tableName);
			        	dto.setPath(objectUrl);
			        	dto.setOriginalName(fileName); 
			        	dto.setExt(ext);
			        	dto.setPseq(pSeq);
			        	dao.updateUploaded(dto);
			        }
				}
			}
		}
}
