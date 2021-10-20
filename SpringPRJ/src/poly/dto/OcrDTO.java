package poly.dto;

public class OcrDTO {
	private String medicine_no; // 저장된 이미지 번호
	private String save_file_path; // 저장된 이미지 파일의 파일 저장 경로
	private String save_file_name; // 저장된 이미지 파일 이름
	private String textFromImage; // 저장된 이미지로부터 읽은 글씨
	private String user_no;
	private String user_id; // 저장 받을 아이디 
	private String org_file_name; // 원래 파일 이름
	private String ext; // 확장자
	private String reg_id; // 등록자
	private String chg_id; // 수정자
	private String receive_dt; // 처방받은 날
	
	public String getMedicine_no() {
		return medicine_no;
	}

	public void setMedicine_no(String medicine_no) {
		this.medicine_no = medicine_no;
	}

	public String getSave_file_path() {
		return save_file_path;
	}

	public void setSave_file_path(String save_file_path) {
		this.save_file_path = save_file_path;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getReceive_dt() {
		return receive_dt;
	}

	public void setReceive_dt(String receive_dt) {
		this.receive_dt = receive_dt;
	}
	
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	public String getTextFromImage() {
		return textFromImage;
	}

	public void setTextFromImage(String textFromImage) {
		this.textFromImage = textFromImage;
	}

	public String getOrg_file_name() {
		return org_file_name;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getChg_id() {
		return chg_id;
	}

	public void setChg_id(String chg_id) {
		this.chg_id = chg_id;
	}

	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
