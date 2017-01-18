package com.gura.cafeboard.board.service;


import org.springframework.web.servlet.ModelAndView;

import com.gura.cafeboard.board.dto.BoardDto;

public interface BoardService {
	public void insert(BoardDto dto);
	public void delete(int num);
	public void update(BoardDto dto);
	public ModelAndView getList();
	public BoardDto getData(int num);
	public void increaseViewCount(int num);
}
