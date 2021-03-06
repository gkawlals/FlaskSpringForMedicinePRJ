package poly.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import poly.dto.OcrDTO;
import poly.persistance.mapper.IOcrMapper;
import poly.service.IMainService;
import poly.util.CmmUtil;
import poly.util.UrlUtil;

@Service("MainService")
public class MainService implements IMainService{
	
	@Resource(name="OcrMapper")
	private IOcrMapper ocrMapper;
	
	// 로그 파일 생성 및 로그 출력을 위한 log4j 프레임워크의 자바 객체
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 이미지 파일로부터 문자 읽어 오기
	 * 
	 * @param pDTO 이미지 파일 정보
	 * @return pDTO 이미지로부터 읽은 문자열
	 */
	
	@Override
	public OcrDTO AddMedicine(OcrDTO pDTO) throws Exception {
		log.info(this.getClass().getName() + ".getFoodInfoFromWEB start!");
		//문자열 인식 결과를  DB에 저장
		
		log.info(this.getClass().getName() + ".getFoodInfoFromWEB End!");

		return 	ocrMapper.InsertOcrInfo(pDTO);
	}

	@Override
	public List<OcrDTO> getApiFlask(OcrDTO pDTO) throws Exception {
        
		return null;
		
	}

}
