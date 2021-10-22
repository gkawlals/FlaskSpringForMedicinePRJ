package poly.service;

import java.util.List;

import poly.dto.OcrDTO;

public interface IOcrService {
		
	
		int AddMedicine(OcrDTO pDTO);

		int InsertImage(OcrDTO pDTO);

		List<OcrDTO> getOcrList();

		OcrDTO SelectMD(OcrDTO pDTO);

		int InsertMD(OcrDTO pDTO);

}
