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
import poly.service.IMainService;
import poly.util.CmmUtil;
import poly.util.DateUtil;
import poly.util.FileUtil;
import poly.util.UrlUtil;


@Controller
public class MainController {
	
	final private String FILE_UPLOAD_SAVE_PATH = "/Users/hamjimin/upload/"; // C:\\upload 폴더에 저장
	//final private String FILE_UPLOAD_SAVE_PATH = "/data/image/"; // web배포 할때 사용할 경로
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="index")
	public String Index() {
		log.info(this.getClass().getName() + "index Page !");
		
		return "/index";
	}

}
