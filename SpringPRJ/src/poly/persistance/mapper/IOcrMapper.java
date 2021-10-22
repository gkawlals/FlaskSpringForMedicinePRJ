package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.OcrDTO;

@Mapper("OcrMapper")
public interface IOcrMapper {


	//이미지로부터 인식된 텍스트 내용 DB에 등록
	OcrDTO InsertOcrInfo(OcrDTO pDTO);

	int AddMedicine(OcrDTO pDTO);

	int InsertImage(OcrDTO pDTO);

	List<OcrDTO> getOcrList();

	OcrDTO SelectMD(OcrDTO pDTO);

	int InsertMD(OcrDTO pDTO);
	
	
}