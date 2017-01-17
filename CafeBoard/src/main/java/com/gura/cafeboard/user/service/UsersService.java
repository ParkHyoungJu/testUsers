package com.gura.cafeboard.user.service;

import java.util.List;

import com.gura.cafeboard.user.dto.UsersDto;


public interface UsersService {
	public void insert(UsersDto dto);
	public List<UsersDto> list();
	public void delete(String id);
	public void update(UsersDto dto);
	public UsersDto getData(UsersDto dto);
	public UsersDto idcheck(UsersDto dto);
}
