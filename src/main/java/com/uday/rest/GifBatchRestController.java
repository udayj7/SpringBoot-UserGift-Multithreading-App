package com.uday.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.service.GifService;

@RestController
public class GifBatchRestController {
	
	@Autowired
	private GifService service;
	
	@GetMapping("/gifts")
	public String processGifts()
	{
		service.processPendingTriggers();
		return "SUCCESS";
	}

}
