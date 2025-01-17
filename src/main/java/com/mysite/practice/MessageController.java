package com.mysite.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping
	@ResponseBody
	public String getMessage() {
		return ("test - hello world - mainpage");
	}
	
	// 목록페이지 - messageList.html
	@GetMapping("/messages")
	public String getMessageList() {
		return "messageList";
	}
	// 목록페이지 - api
	@GetMapping("/messages/api")
	@ResponseBody
	public List<Message> getMessageListAll() {
		return messageService.getMessageListAll();
	}
	
	
	// 상세페이지
	@GetMapping("/messages/{id}")
	public String getMessageDetail(@PathVariable("id") Integer id, Model model) {
		Message message = messageService.getMessageDetail(id);
		model.addAttribute("msg", message);
		
		return "messageDetail";
	}
	
	
	// 메시지 추가(데이터 추가)
	@GetMapping("/messages/create")
	public String getMessageCreate() {
		return "messageCreate";
	}
	
	@PostMapping("/messages")
	@ResponseBody
	public void createMessage(@RequestBody Message message) {
		messageService.createMessate(message);
	}
	
	
	
}
