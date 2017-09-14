package com.uscs.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.uscs.model.DocumentVO;
import com.uscs.service.WebDocsService;


@Controller
public class WebDocsController {

	@Inject
	WebDocsService webdocs;
		
	@RequestMapping("/")
	public ModelAndView index(Model model){
		
		ModelAndView indexView = new ModelAndView("index");	
		return indexView;
	}
		

	@RequestMapping(value="/submitDocument", method=RequestMethod.POST)
	public @ResponseBody void submitDocument (@RequestBody String returnData,HttpServletResponse response){
		
	
		response.setContentType("application/pdf");
		
		String responseData = returnData;
		Gson data = new Gson();
		DocumentVO document = new DocumentVO();
		document  = data.fromJson(responseData, DocumentVO.class);
		String title = document.getTitle();
		webdocs.submitDocument(document.getFileName());
	}
	
	
	@RequestMapping(value="/retrieveDocument", method=RequestMethod.POST)
	public @ResponseBody void retrieveDocument (@RequestBody String returnData,HttpServletResponse response){
		
	
		response.setContentType("application/pdf");
		
		String responseData = returnData;
		Gson data = new Gson();
		DocumentVO document = new DocumentVO();
		document  = data.fromJson(responseData, DocumentVO.class);
	
		webdocs.submitDocument(document.getFileName());
	}
}
