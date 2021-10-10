package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IUserSerivce;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	private IUserSerivce userService;
	
	// 회원가입페이지 띄우기
	@RequestMapping(value="user/InsertPage")
	public String InsertPage() {
		log.info(this.getClass().getName() + ". InsertPage Start!");
		return "user/InsertPage";
	}
	// 회원가입 버튼 클릭시 실행되는 함수
	@RequestMapping(value="/user/InsertStart.do")
	public String InsertStart(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String user_id = "";
		String user_pwd = "";
		String user_name = "";
		String user_ph = "";
		
		
		return null;
	}

}
