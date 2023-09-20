package com.green.rest.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.pds.service.PdsService;

// @RestController = @Controller + @ResponseBody
// @ResponseBody 는 return값이 json, xml과 같은 문자열가능 
@RestController
public class PdsRestController {
     // /deleteFile?file_num=12&sfile=flower_1.jpg"
    
	private PdsService pdsService;
	
	@RequestMapping(
			value   = "/deleteFile",
			method  = RequestMethod.GET,
			headers = "Accept=application/json")
	public void deleteFile(
		@RequestParam HashMap<String, Object> map ){
		
		pdsService.deleteUploadFile( map ); 
	}
	
}
