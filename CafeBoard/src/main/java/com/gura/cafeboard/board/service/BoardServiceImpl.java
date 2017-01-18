package com.gura.cafeboard.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.cafeboard.board.dao.BoardDao;
import com.gura.cafeboard.board.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void insert(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
