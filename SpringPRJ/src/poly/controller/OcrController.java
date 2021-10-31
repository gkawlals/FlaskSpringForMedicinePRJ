package poly.controller;

	import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.dto.OcrDTO;
import poly.service.IOcrService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.UrlUtil;

	/*
	 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
	 * 자바 서블릿 역할 수행
	 * */
	@Controller
	public class OcrController {
		
		private Logger log = Logger.getLogger(this.getClass());

		/*
		 * 비즈니스 로직(중요 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재(싱글톤패턴 적용됨)
		 */
		@Resource(name = "OcrService")
		private IOcrService ocrService;

		// 업로드되는 파일이 저장되는 기본 폴더 설정(자바에서 경로는 /로 표현함)
		//final private String FILE_UPLOAD_SAVE_PATH = "/data/image/"; // C:\\upload 폴더에 저장
		final private String FILE_UPLOAD_SAVE_PATH = "/Users/hamjimin/upload"; // C:\\upload 폴더에 저장
		
		/**
		 * 이미지 인식을 위한 파일업로드 화면 호출
		 */
		
		@RequestMapping(value="ocr/CheckMedicine")
		public String CheckMedicine() {
			log.info(this.getClass().getName() + ".Main Page Start!");
			
			log.info(this.getClass().getName() + ".Main Page End!");
			return "ocr/CheckMedicine";
		}
		
		@RequestMapping(value="ocr/MD_name_insert")
		public String MD_name_insert(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			 HttpSession session) throws Exception{
			
			log.info("MD_name_Insert start !");
			
			String msg = "";
	        String url = "";
			String medicine_no = (String)request.getParameter("medicine_no");
			String MD_list = (String)request.getParameter("MD_list");
			
			
			log.info("medicine_no : " + medicine_no);
			log.info("MD_name List : " + MD_list);
			
			OcrDTO rDTO = null;
			
			try {
				
				MD_list = MD_list.replace("& #40;", "(").replace("& #41;", ")").replace(" ", ", ");
				
				rDTO = new OcrDTO();
				
				rDTO.setMedicine_no(medicine_no);
				rDTO.setMedicine_name(MD_list);
				
				ocrService.InsertMD(rDTO); 
				
				msg = "약의 이름이 저장되었습니다.";
				url = "/ocr/main.do";
				
				model.addAttribute("msg",msg);
				model.addAttribute("url",url);
				
				msg = "";
				url = "";
				rDTO = null;
				
				log.info("Medicine_List success ");
				
			}catch(Exception e){
				
				msg = "실패했습니다. : " + e.toString();
				url = "/ocr/main";
				
				log.info("Error : " + e.toString());
				e.printStackTrace();
				
				model.addAttribute("msg", msg);
				model.addAttribute("url", url);
				
				return "/redirect";
				
			}finally {
				
				msg = "";
	            url = "";
	            rDTO = null;
			}
			

			return "/redirect";
			
		}
		
		@RequestMapping(value="ocr/ocrList")
		public String ocrList(ModelMap model) {
			
			List<OcrDTO> ocrList = ocrService.getOcrList();
			
			if(ocrList == null) {
				log.info(" List load Failed !");
				ocrList = new ArrayList<>();
			}
			
			for(OcrDTO e : ocrList) {
				log.info(" Medicine_no : " + e.getMedicine_no());
			}
			
			log.info(" Medicine_no 불러오기");
			
			model.addAttribute("ocrList", ocrList);
			
			return "ocr/main";
		}
		
		@RequestMapping(value="ocr/main")
		public String upload(ModelMap model, HttpSession session) {
			
			log.info(this.getClass().getName() + ".Main Page Start!");
			
			String ss_user_id = (String)session.getAttribute("ss_user_id");
			
			OcrDTO rDTO = new OcrDTO();
			
			rDTO.setUser_id(ss_user_id);
			
			List<OcrDTO> ocrList = ocrService.getOcrList();
			
			if(ocrList == null) {
				log.info(" List load Failed !");
				ocrList = new ArrayList<>();
			}
			log.info(" Medicine_no 불러오기");
			
			model.addAttribute("ocrList", ocrList);
			
			    
			for(OcrDTO e : ocrList) {
				log.info(" Medicine_no : " + e.getMedicine_no());
			}
			
			ocrList = null;
			
			log.info(this.getClass().getName() + ".Main Page End!");
			
			return "ocr/main";
		}
		
		
		@RequestMapping(value="ocr/fileUpload")
		public String AddMedicine(HttpServletRequest request, HttpServletResponse response, ModelMap model,
				@RequestParam(value="fileUpload")MultipartFile mf, HttpSession session) throws Exception{
			

			log.info(this.getClass().getName() + ".getReadforImageText start!");
			
			String msg = "";
			String url = "";
			
			try {
				
				// 업로드하는 실제 파일명
				String user_id = CmmUtil.nvl((String)session.getAttribute("ss_user_id"));
				// 다운로드 기능 구현시, 임의로 정의된 파일명을 원래대로 만들어주기 위한 목"/Users/hamjimin/Desktop/2021-08-02_21.39.48.png"적
				String originalFileName = mf.getOriginalFilename();

				// 파일 확장자 가져오기
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();
			
				// 이미지 파일만 실행되도록 함
				if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {
					
					// 웹서버에 저장되는 파일 이름
					// 업로드하는 파일 이름에 한글, 특수 문자들이 저장될 수 있기 때문에 강제로 영어와 숫자로 구성된 파일명으로 변경해서 저장한다.
					// 리눅스나 유닉스 등 운영체제는 다국어 지원에 취약하기 때문이다.
					String saveFileName = DateUtil.getDateTime("24hhmmss") + "." + ext;
					
					String save_folder_name = DateUtil.getDateTime("yyyy.MM.dd");
					
					// 웹서버에 업로드한 파일 저장하는 물리적 경로
					String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);
					// 파일 업로드를 위한 경로 잡아주기
					String fullFileInfo = saveFilePath + "/"+ saveFileName;
					
					String WebSrc = save_folder_name + "/" + saveFileName;
					
					// 정상적으로 값이 생성되었는지 로그 찍어서 확인
					log.info("saveFileName : " + saveFileName);
					log.info("saveFilePath : " + saveFilePath);
					log.info("fullFileInfo : " + fullFileInfo);
					log.info("fullFileInfo : " + save_folder_name);

					// 업로드 되는 파일을 서버에 저장
					mf.transferTo(new File(fullFileInfo));

					OcrDTO pDTO = new OcrDTO();
					// word들을 담을 객체 
					pDTO.setUser_id(user_id);
					pDTO.setSave_file_name(saveFileName.trim()); // 저장되는 파일명
					pDTO.setSave_file_path(fullFileInfo.trim()); // 저장되는 경로 
					pDTO.setOrg_file_name(originalFileName.trim()); // 원래이름
					pDTO.setSave_folder_name(save_folder_name.trim()); // 저장되는 폴더의 경로
					pDTO.setReg_id(user_id); // user_id

					int res = ocrService.InsertImage(pDTO);

						if (res < 1) {
							
							log.info("Insert Image Failed! ");
							
							 msg = "처방 등록에 실패하였습니다. 다시 시도해 주세요. : " ;
					         url = "ocr/main.do";
					         
					         model.addAttribute("msg", msg);
					         model.addAttribute("url", url);
							
							return "/rediract";
							
						}else {
						
							log.info(this.getClass().getName() + "Insert Image success! ");
							
							List<String> OTList = getApiFlask(fullFileInfo);
							
							OcrDTO NODTO = ocrService.SelectMD(pDTO);
							
							String medicine_no = NODTO.getMedicine_no();
							
							model.addAttribute("medicine_no", medicine_no); // 약이름을 받아와 저장할 때 사용할 image number
							
							model.addAttribute("fullFileInfo",WebSrc); // 사용자가 보고 다시 적을 처방전의 사진을 띄우기 위한 경로 설정 
							
							model.addAttribute("OTList",OTList); // OCR로 뽑아온 약 이름 List
							
							log.info("OTList : " + OTList);
							
							return "ocr/CheckMedicine";
						
						}
					}	
						
				}catch(Exception e) {
					
					 //등록이 실패되면 오류 메세지를 보여줌
		            msg = "처방 등록에 실패하였습니다. 다시 시도해 주세요. : " + e.toString();
		            url = "/getIndex.do";

		            model.addAttribute("msg", msg);
		            model.addAttribute("url", url);

		            log.info(e.toString());
		            e.printStackTrace();
					
				}finally {
					log.info(this.getClass().getName() + ".ImageInsert Start !");
				}
	
					log.info(this.getClass().getName() + ".getReadforImageText end!");
					
					return "/redirect";
			}
		
		
		private List<String> getApiFlask(String fullFileInfo) 
				throws Exception {
			// TODO Auto-generated method stub
			UrlUtil uu = new UrlUtil();
			//String url = "http://3.34.19.73:5000";
			String url = "http://127.0.0.1:8001";
	        String api = "/OcrTest";
	        String pName = "?Filename=";
	        String Filename = CmmUtil.nvl(fullFileInfo);
	        
	        String res = uu.urlReadforString(url + api + pName + URLEncoder.encode(Filename,"UTF-8"));
	        
	        log.info("File Path : " + res);
	        
	        uu = null;
	        
	        // json parsing
	        
	        JSONParser parser = new JSONParser();
	        
	        JSONObject json = (JSONObject) parser.parse(res);
	        
	        List<String> rList = (List<String>)json.get("word");
	        
	        if(rList == null) {
	        	rList = new ArrayList<String>();
	        }
	        
	        Iterator<String> it = rList.iterator();
	        
	        while(it.hasNext()) {
	        	String word = (String) it.next();
	        	
	        	log.info("word : " + word);
	        	
	        }
			
			return rList;
		}


}
