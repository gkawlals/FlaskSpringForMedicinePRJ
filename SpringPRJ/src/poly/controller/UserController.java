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
		
		if(rDTO == null) {
			
			log.info(this.getClass().getName() + " LoginStart DTO is null");
			
			return "index";
			
		}else {
			
			String ss_user_id = rDTO.getUser_id();
			String ss_user_no = rDTO.getUser_no();
			String ss_user_name = rDTO.getUser_name();
			
			// 세션으로 기본정로 저장하기 
			session.setAttribute("SS_USER_ID", ss_user_id);
			session.setAttribute("SS_USER_NO", ss_user_no);
			session.setAttribute("SS_USER_NAME", ss_user_name);
		
			log.info(" 로그인에 성공했습니다.");
			
			log.info(this.getClass().getName() + " .getUserLoginCheck end !");
			
			model.addAttribute("rDTO", rDTO);
			
			pDTO = null;
			
			log.info(this.getClass().getName() +"Login End");
						
			return "ocr/main";
		}
	}
	
	// 회원가입페이지 띄우기
	@RequestMapping(value="user/InsertPage")
	public String InsertPage() {
		log.info(this.getClass().getName() + ". InsertPage Start!");
		return "user/InsertPage";
	}
	
	// 회원가입 버튼 클릭시 실행되는 함수
	@RequestMapping(value="user/InsertStart")
	public String InsertStart(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));;
		String user_pwd = CmmUtil.nvl(request.getParameter("user_pwd"));;
		String user_name = CmmUtil.nvl(request.getParameter("user_name"));;
		
		log.info("user_id : " + user_id);
		log.info("user_pwd : " + user_pwd);
		log.info("user_name : " + user_name);
		
		UserDTO pDTO = new UserDTO(); 
		
		pDTO.setUser_id(user_id);
		pDTO.setUser_pwd(user_pwd);
		pDTO.setUser_name(user_name);
		
		
		int res = userService.InsertStart(pDTO);
		
		 String msg = "";
	     String url = "";
	     

        if (res > 0) {
        	
            msg = "회원가입을 축하드립니다.";
        
        } else {
        	
            msg = "회원정보를 확인 후 가입을 진행해 주세요.";
            
        }

        url = "/index.do";
        log.info("model.addAttribute");
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        pDTO = null;
        log.info("insertUser End!");
        
        return "/index";
		
	}


}
