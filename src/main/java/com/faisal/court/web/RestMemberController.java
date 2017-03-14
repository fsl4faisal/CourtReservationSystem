package com.faisal.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faisal.court.domain.Member;

@Controller
public class RestMemberController {
	
	@RequestMapping("/members")
	public String getRestMembers(Model model){
	Member member=new Member();
	member.setName("John Doe");
	member.setPhone("9911052291");
	member.setEmail("john.doe@gmail.com");
	model.addAttribute("member", member);
	return "membertemplate";
	}
	
	@RequestMapping("/member/{memberid}")
	public void getMember(@PathVariable("memberid") long memberID){
		
	}
	
}
