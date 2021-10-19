package poly.service;

import java.util.List;

import poly.dto.OcrDTO;

public interface IMainService {
	
	OcrDTO AddMedicine(OcrDTO pDTO) throws Exception;

	List<OcrDTO> getApiFlask(OcrDTO pDTO) throws Exception;

}
