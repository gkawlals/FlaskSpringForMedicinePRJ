package poly.service.impl;

import java.io.File;
import java.util.List;

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

	@Override
	public int AddMedicine(OcrDTO pDTO) {
		// TODO Auto-generated method stub
		return ocrMapper.AddMedicine(pDTO);
	}

	@Override
	public int InsertImage(OcrDTO pDTO) {
		// TODO Auto-generated method stub
		return ocrMapper.InsertImage(pDTO);
	}

	@Override
	public List<OcrDTO> getOcrList() {
		// TODO Auto-generated method stub
		return ocrMapper.getOcrList();
	}

	@Override
	public OcrDTO SelectMD(OcrDTO pDTO) {
		// TODO Auto-generated method stub
		return ocrMapper.SelectMD(pDTO);
	}

	@Override
	public int InsertMD(OcrDTO pDTO) {
		// TODO Auto-generated method stub
		return ocrMapper.InsertMD(pDTO);
	}

}