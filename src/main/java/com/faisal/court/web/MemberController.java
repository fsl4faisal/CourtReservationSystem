package com.faisal.court.web;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.faisal.court.domain.Member;
import com.faisal.court.service.MemberService;

@Controller
@RequestMapping("/member/*")
@SessionAttributes("guests")
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private static Validator validator;

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("member") Member member, BindingResult result, Model model) {
		Set<ConstraintViolation<Member>> violations = validator.validate(member);

		for (ConstraintViolation<Member> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			result.addError(new FieldError("member", propertyPath, "Invalid " + propertyPath + "(" + message + ")"));
		}
		if(!result.hasErrors()){
			return "memberSubmit";
		}else{
			return "redirect:reservationSuccess";
		}
	}
}
