package com.gura.cafeboard.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.gura.cafeboard.board.dao.BoardDao;
import com.gura.cafeboard.board.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
	}

	@Override
	public void delete(int num) {
		boardDao.delete(num);
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
	}

	@Override
	public ModelAndView getList() {
		List<BoardDto> list = boardDao.getList();
		
		ModelAndView mView = new ModelAndView();
		
		mView.addObject("list",list);
		
		return mView;
	}

	@Override
	public BoardDto getData(int num) {
		BoardDto dto =boardDao.getData(num);
		
		return dto;
	}

	@Override
	public void increaseViewCount(int num) {
		boardDao.increaseViewCount(num);
		
	}
	
}
