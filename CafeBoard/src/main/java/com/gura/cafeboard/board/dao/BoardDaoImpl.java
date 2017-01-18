package com.gura.cafeboard.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.cafeboard.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession session;
	
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
