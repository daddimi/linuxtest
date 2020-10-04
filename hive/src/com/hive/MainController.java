package com.hive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
//	String url = "jdbc:hive2://192.168.111.120:10000/default";
//	String userid = "hive";
//	String password = "111111";
//	
//	public MainController() {
//		try {
//			Class.forName("org.apache.hive.jdbc.HiveDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart1.mc")
	public ModelAndView chart1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart1");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart2.mc")
	public ModelAndView chart2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart2");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart3.mc")
	public ModelAndView chart3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart3");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/chart4.mc")
	public ModelAndView chart4() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("centerpage","chart4");
		mv.setViewName("main");
		return mv;
	}
	
}
