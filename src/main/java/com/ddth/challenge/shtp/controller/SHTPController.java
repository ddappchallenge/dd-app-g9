package com.ddth.challenge.shtp.controller;

import com.ddth.challenge.shtp.algorithm.ShortestPath;
import com.ddth.challenge.shtp.model.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SHTPController {

	private static String lastestMessage = "Hello World";

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/hello")
	public ResponseMessage helloGet(){
		ResponseMessage hm = new ResponseMessage();
		hm.setMessage(lastestMessage);
		hm.setStatus("OK");
		hm.setDate("DAY");
		return hm;
	}

	@PostMapping(value="/set-hello-message")
	public HttpStatus setResponseMessage(@RequestParam(value="message") String message){
		lastestMessage = message;
		return HttpStatus.OK;
	}

	@GetMapping(value = "short")
	public String ShortestPath(){
		ShortestPath a= new ShortestPath();
		return "Just a sample";
	}
}
