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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.UserDTO;
import poly.service.IUserSerivce;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserService")
	private IUserSerivce userService;

	// 로그인버튼 클릭시 실행되는 함수
	@RequestMapping(value="user/LoginStart")
	public String LoginStart(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session) 
			throws Exception {
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		String user_pwd = CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("user_pwd")));
		
		log.info(" getUser_id : " + user_id);
		log.info(" getUser_pwd : " + user_pwd);
		
		UserDTO pDTO = new UserDTO();
		
		pDTO.setUser_id(user_id);
		pDTO.setUser_pwd(user_pwd);
		
		String msg = ""; 
		String url = "";
		
		UserDTO rDTO = userService.LoginStart(pDTO);
		
		if(rDTO == null) {
			msg = "로그인에 실패했습니다. 다시 시도해 주세요.";
            url = "/index.do"; //재 로그인
			log.info(this.getClass().getName() + " LoginStart DTO is null");
			
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			
			return "index";
			
		}else {
			
			msg = "환영합니다.";
			
			String ss_user_id = rDTO.getUser_id();
			String ss_user_no = rDTO.getUser_no();
			String ss_user_name = rDTO.getUser_name();
			
			// 세션으로 기본정로 저장하기 
			session.setAttribute("ss_user_id", ss_user_id);
			session.setAttribute("ss_user_no", ss_user_no);
			session.setAttribute("ss_user_name", ss_user_name);
		
			log.info(" 로그인에 성공했습니다.");
			
			log.info(this.getClass().getName() + " .getUserLoginCheck end !");
			
			url = "/ocr/main.do";
			
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			model.addAttribute("rDTO", rDTO);
			
			pDTO = null;
	        rDTO = null;
			
			log.info(this.getClass().getName() +"Login End");
						
			return "/redirect";
		}
	}
	
	// 회원가입페이지 띄우기
	@RequestMapping(value="user/InsertPage")
	public String InsertPage() {
		log.info(this.getClass().getName() + ". InsertPage Start!");
		return "user/InsertPage";
	}
	
	// 로그아웃
    @RequestMapping(value = "/user/logOut")
    public String logOut(HttpSession session, ModelMap model) throws Exception {
        log.info("logOut Start!");

        String msg = "로그아웃 되었습니다.";
        String url = "/index.do";

        // 세션 삭제(user_name, user_no) - invalidate() 또는 removeAttribute 함수 사용
        session.removeAttribute("SS_USER_NAME");
        session.removeAttribute("SS_USER_NO");
       

        // 세션이 정상적으로 삭제되었는지 로그를 통해 확인
        log.info("session deleted ? : " + session.getAttribute("SS_USER_NO"));
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info("session delete, model.addAttribute 끝!");
        log.info("logOut End!");

        return "/redirect";
    }
    
    @RequestMapping(value="/user/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String user_id) {
    	log.info(" Id Check start !");
    	log.info(" user_id check :" + user_id);
    	int cnt = userService.userIdCheck(user_id);
    	log.info(" Id Check end !");
    	return cnt;
	}
	
	// 회원가입 버튼 클릭시 실행되는 함수
	@RequestMapping(value="user/InsertStart")
	public String InsertStart(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));;
		String user_pwd =  CmmUtil.nvl(EncryptUtil.encHashSHA256(request.getParameter("user_pwd")));
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
            url = "/index.do";
            model.addAttribute("msg",msg);
            model.addAttribute("url",url);
            
            return "/redirect";
        
        } else {
        	
            msg = "회원정보를 확인 후 가입을 진행해 주세요.";
            url = "/user/InsertPage.do";
            model.addAttribute("msg",msg);
            model.addAttribute("url",url);
            
            return "/redirect";
            
        }
		
	}


}
