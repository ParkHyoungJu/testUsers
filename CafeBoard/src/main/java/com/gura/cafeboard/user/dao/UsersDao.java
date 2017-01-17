package com.gura.cafeboard.user.dao;

import java.util.List;

import com.gura.cafeboard.user.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public void delete(String id);
	public void update(UsersDto dto);
	public List<UsersDto> getList();
	public UsersDto getData(UsersDto dto);
	public UsersDto idcheck(UsersDto dto);
}
