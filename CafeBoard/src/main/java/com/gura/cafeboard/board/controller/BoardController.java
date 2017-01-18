package com.gura.cafeboard.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.cafeboard.board.dto.BoardDto;
import com.gura.cafeboard.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(){
		ModelAndView mView =boardService.getList();
		mView.setViewName("/cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/private/insertform")
	public String insertform(){
		
		return "/cafe/private/insertform";
	}
	
	@RequestMapping("/cafe/private/insert")
	public String insert(@ModelAttribute BoardDto dto){
		boardService.insert(dto);
		
		return "redirect:/cafe/list.do";
		
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num,HttpSession session){
		String id = (String)session.getAttribute("id");
		boolean isLogin = false;
		if(id != null){
			isLogin = true;
		}
		boardService.increaseViewCount(num);
		
		
		ModelAndView mView = new ModelAndView();
		BoardDto dto = boardService.getData(num);
		mView.addObject("dto",dto);
		mView.addObject("isLogin",isLogin);
		mView.setViewName("/cafe/detail");
		return mView;
	}
	
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(@RequestParam int num){
		ModelAndView mView = new ModelAndView();
		BoardDto dto = boardService.getData(num);
		mView.addObject("dto",dto);
		mView.setViewName("/cafe/private/updateform");
		return mView;
	}
	
	@RequestMapping("/cafe/private/update")
	public String update(@ModelAttribute BoardDto dto){
		boardService.update(dto);
		
		return "redirect:/cafe/list.do";
	}
	
	
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num){
		boardService.delete(num);
		return "redirect:/cafe/list.do";
	}
}
