package com.gura.cafeboard.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.cafeboard.user.dao.UsersDao;
import com.gura.cafeboard.user.dto.UsersDto;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		usersDao.insert(dto);
	}


	@Override
	public void delete(String id) {
		usersDao.delete(id);
	}

	@Override
	public void update(UsersDto dto) {
		usersDao.update(dto);
		
	}

	@Override
	public List<UsersDto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDto getData(UsersDto dto) {
		UsersDto dataDto =usersDao.getData(dto);
		
		return dataDto;
	}


	@Override
	public UsersDto idcheck(UsersDto dto) {
		UsersDto dataDto = usersDao.idcheck(dto);
		return dataDto;
	}


}
