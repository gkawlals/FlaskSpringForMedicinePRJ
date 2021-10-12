package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.UserDTO;
import poly.service.IUserSerivce;
import poly.util.CmmUtil;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	private IUserSerivce userService;

	// 로그인버튼 클릭시 실행되는 함수
	@RequestMapping(value="user/LoginStart", method=RequestMethod.POST)
	public String LoginStart(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	throws Exception {
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
		
		log.info(" getUser_id : " + user_id);
		log.info(" getUser_pwd : " + user_pwd);
		
		UserDTO pDTO = new UserDTO();
		
		pDTO.setUser_id(user_id);
		pDTO.setUser_pwd(user_pwd);
		
		UserDTO rDTO = userService.LoginStart(pDTO);
		
		
		return null;
	}
	
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