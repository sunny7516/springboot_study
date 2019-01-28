package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.PushMessage;

@Repository
public class PushMessageDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public PushMessageDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	private static final String NAMESPACE = "com.example.demo.dao.PushMessageMapper.";
	
	public PushMessage selectById(Long id) {
		return sqlSession.selectOne(NAMESPACE+"selectById", id);
	}
	
	public Long countAll() {
		return sqlSession.selectOne(NAMESPACE+"countAll");
	}
}
