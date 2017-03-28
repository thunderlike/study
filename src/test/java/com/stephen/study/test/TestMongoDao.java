package com.stephen.study.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stephen.study.modules.mongodb.dao.BookDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/spring-context*.xml"})
public class TestMongoDao extends AbstractJUnit4SpringContextTests{
	@Resource
	private BookDao bookDao;
	
	@Test
	public void query(){
		bookDao.findByInfo("haha", "stephen");
	}
}
