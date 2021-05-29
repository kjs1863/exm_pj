package com.cos.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cos.annotation.LogExecutionTime;
import com.cos.service.ExmService;
import com.cos.vo.Board;
import com.cos.vo.ParamVo;
import com.google.gson.Gson;

@Controller
@SessionAttributes({"userId", "userName"})
class ExmController {
	@Resource
	private ExmService es;
	//Logger log = Logger.getLogger(this.getClass());
	@RequestMapping(value = "/interceptorTest")
	public ModelAndView interceptorTest() {
		ModelAndView mv = new ModelAndView("test");
		System.out.println("인터셉터 테스트입니다.");
		es.service();
		//log.debug("인터셉터 테스트입니다.");
		return mv;
	}
	
	@RequestMapping(value = "/interceptorTest1")
	public void interceptorTest1(Model model) {
		List<Board> list = new ArrayList<Board>();
		System.out.println("/interceptorTest1 테스트입니다.");
		Board board = new Board();
		board.setId("1");
		board.setTitle("테스트1");
		board.setContent("테스트1입니다.");
		list.add(board);
		board = new Board();
		board.setId("2");
		board.setTitle("테스트2");
		board.setContent("테스트2입니다.");
		list.add(board);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/hangulTest")
	public String filterTest(HttpServletRequest req, HttpServletResponse resp, ModelAndView mv) {
		/*
		 * 한글깨짐 처리를 위해서 filter을 사용하여 처리함
		 * web.xml 에 filter 추가함. 
		 */
		
		System.out.println("한글 테스트입니다.");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		System.out.println("id : " +id );
		System.out.println("name : " +name );
		//log.debug("인터셉터 테스트입니다.");

		return "test";
	}
	
	@RequestMapping(value = "/setVo")
	@LogExecutionTime
	public String setVo(ParamVo vo) { 
		System.out.println("파라메타 vo 테스트");
		System.out.println("파라메타 vo : " + vo);
		return "test";
	}
	
	@RequestMapping(value = "/paramJson")
	public String paramJson(@RequestBody ParamVo vo) {
		System.out.println("json 테스트");
		System.out.println("파라메타 vo : " + vo);
		return "test";
	}
	
	@RequestMapping(value = "/paramJson1" , method = RequestMethod.POST)
	public String paramJson1(@RequestBody Map<String, Object> map) {
		System.out.println("json 테스트");
		System.out.println("파라메타 map : " + (String)map.get("id"));
		
		return "test";
	}
	
	@RequestMapping(value = "/hello")
	public void hello() {
		// 응답에 대한 값이 없어(return 값) InternalResourceViewResolver 에서 설정된 /WEB-INF/view/hello.jsp로 응답해 준다.
		System.out.println("hello 요청이 있었습니다.");
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/hello1")
	public String hello1() {
		System.out.println("hello1 요청이 있었습니다.");
		return "Hello1 입니다.";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page) {
		System.out.println("list 요청이 있었습니다.");
		System.out.println("페이지 : " + page);
		return "list 입니다.";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list1")
	public String list1(@RequestParam(value = "p", required = true) Integer page) {
		System.out.println("list1 요청이 있었습니다.");
		System.out.println("페이지 : " + page);
		return "list1 입니다.";
	}
	
	@RequestMapping(value = "/api/users/find")
	public void find(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String userId = req.getParameter("userId");
		if(userId == null) {
			resp.sendRedirect("/");
			return;
		}
		
		ParamVo vo = new ParamVo();
		vo.setId("test");
		vo.setName("홍길동");
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		PrintWriter pw = resp.getWriter();
		pw.print(jsonData);
	}
	
	@RequestMapping(value = "/login")
	public void login (Model model) {
		
		// Session은 Model 객체에 넣으면서 함께 @SessionAttributes 설정을 통해 섹션 객체에도 담기게 된다.
		// @SessionAttributes({"userId", "userName"}) 
		model.addAttribute("userId", "kobal");
		model.addAttribute("userName", "홍길동");
	}
	
	@RequestMapping("/main/mainSlide")
	public void mainSlide(ModelMap model) {
	    // model에서 상단에 annotaion으로 선언한 세션을 다 가져올 수 있어요 !
		System.out.println("userId : " +model.getAttribute("userId"));
		System.out.println("userName : " +model.getAttribute("userName"));
	}
	
}		
