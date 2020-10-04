package com.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.SubwayPassenger;
import com.frame.Subway;

@Controller
public class SPController {
	
	@Autowired
	Subway<SubwayPassenger> subway;
	
	@RequestMapping("/subwaypassenger.mc")
	public void subwaypassenger(SubwayPassenger sp) {
		System.out.println(sp);
		subway.Passenger(sp);
	}

	
}
