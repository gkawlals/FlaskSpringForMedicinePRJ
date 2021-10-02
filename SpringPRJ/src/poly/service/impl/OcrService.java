package poly.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.OcrDTO;
import poly.persistance.mapper.IOcrMapper;
import poly.service.IOcrService;
import poly.util.CmmUtil;

@Service("OcrService")
public class OcrService implements IOcrService {

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
	public OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception {

		log.info(this.getClass().getName() + ".getFoodInfoFromWEB start!");

		File imageFile = new File(CmmUtil.nvl(pDTO.getFilePath()) + "//" + CmmUtil.nvl(pDTO.getFileName()));

		//문자열 인식 결과를  DB에 저장
		ocrMapper.InsertOcrInfo(pDTO);
		
		log.info(this.getClass().getName() + ".getFoodInfoFromWEB End!");

		return pDTO;
	}

}