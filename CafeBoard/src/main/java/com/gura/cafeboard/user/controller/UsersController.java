package com.gura.cafeboard.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gura.cafeboard.user.dto.UsersDto;
import com.gura.cafeboard.user.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/signup_form")
	public String signupform(){
		return "/users/signup_form";
	}
	
	@RequestMapping("/users/signup")
	public String signup(@ModelAttribute UsersDto dto){
		usersService.insert(dto);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/signin_form")
	public String signinform(){
		return "/users/signin_form";
	}
	
	@RequestMapping("/users/signin")
	public String signin(HttpSession session,@ModelAttribute UsersDto dto){
		UsersDto dataDto =usersService.idcheck(dto);
		String location=null;
		if(dataDto !=null){
			String id = dataDto.getId();
			session.setAttribute("id", id);
			location = "redirect:/home.do";
		}else{
			location = "/users/signup_form";
		}
		return location;
	}
	
	@RequestMapping("/users/signout")
	public String signout(HttpSession session){
		session.invalidate();
	
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/private/info")
	public String info(HttpSession session,HttpServletRequest request){
		String id = (String)session.getAttribute("id");
		UsersDto dto = new UsersDto();
		dto.setId(id);
		UsersDto dataDto = usersService.getData(dto);
		request.setAttribute("dto", dataDto);
		
		return "/users/private/info";
	}
	
	@RequestMapping("/users/private/updateform")
	public String updateform(HttpSession session,HttpServletRequest request){
		String id = (String)session.getAttribute("id");
		UsersDto dto = new UsersDto();
		dto.setId(id);
		UsersDto dataDto = usersService.getData(dto);
		request.setAttribute("dto", dataDto);
		
		return "/users/private/updateform";
	}
	
	@RequestMapping("/users/private/update")
	public String update(@ModelAttribute UsersDto dto){
		usersService.update(dto);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/private/delete")
	public String delete(HttpSession session,@RequestParam String id){
		usersService.delete(id);
		session.invalidate();
		
		return "redirect:/home.do";
	}
}
