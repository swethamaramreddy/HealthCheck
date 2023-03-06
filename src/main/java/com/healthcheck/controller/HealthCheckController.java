package com.healthcheck.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
	
	@RequestMapping("/health")
	public Map<String,String> healthCheck(@RequestParam("format") String format)
	
	{
		Map<String,String> response=new HashMap<String,String>();
		System.out.println(format);
		if(format.equals("short"))
		{
			response.put("status","OK");
		}
		if(format.equals("full"))
		{
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date currentdate=new Date();
			String currentDateinString=fmt.format(currentdate);
			response.put("status","OK");
			response.put("currentdate",currentDateinString);
		}
		return response;
	}

}
