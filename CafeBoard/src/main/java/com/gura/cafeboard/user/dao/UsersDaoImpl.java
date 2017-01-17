package com.gura.cafeboard.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.cafeboard.user.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	//의존객체
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert",dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete",id);
		
	}

	@Override
	public List<UsersDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDto getData(UsersDto dto) {
		UsersDto dataDto =session.selectOne("users.getData",dto);
		
		return dataDto;
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
		
	}

	@Override
	public UsersDto idcheck(UsersDto dto) {
		UsersDto dataDto = session.selectOne("users.idcheck",dto);
		return dataDto;
	}

	
	
}
