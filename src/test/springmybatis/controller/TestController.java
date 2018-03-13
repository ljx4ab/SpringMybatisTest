package test.springmybatis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.springmybatis.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;

	@RequestMapping("/")
	public String index(Map<String, Object> model) {

		// testService.init();
		List<Map<String, Object>> list = // new ArrayList<Map<String,Object>>();
		testService.getTests();
		model.put("list", list);
		return "Test";
	}
}
