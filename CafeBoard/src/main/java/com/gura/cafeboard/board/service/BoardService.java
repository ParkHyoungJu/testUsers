package com.gura.cafeboard.board.service;

import java.util.List;

import com.gura.cafeboard.board.dto.BoardDto;

public interface BoardService {
	public void insert(BoardDto dto);
	public void delete(int num);
	public void update(BoardDto dto);
	public List<BoardDto> getList();
	public BoardDto getData(int num);
}
