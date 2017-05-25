package com.hb.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class simpleDaoTest {
	static Logger log=Logger.getLogger(simpleDaoTest.class);
	static simpleDao dao = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// 클래스를 시작하기 전에
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 클래스가 끝난 후
	}

	@Before
	public void setUp() throws Exception {
		dao= new simpleDao(false);
		//각 테스트를 수행할 때마다
	}

	@After
	public void tearDown() throws Exception {
		dao.back();
		//각 테스트를 수행한 후
	}

	@Test
	public void testSimpleDao() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new simpleDao());
		
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		
		List<Map<String,Object>> list= dao.selectAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(3,list.size());
		for (Map<String,Object> map :list ){
			log.debug(map.get("sabubn"));
		}
		
	}
	
	@Test
	public void testSelectOne() throws ClassNotFoundException, SQLException{
		int sabun = 1000;
		Map<String,Object> map = dao.selectOne(sabun);
		Assert.assertNotNull(map);
		Assert.assertEquals(sabun,map.get("sabun"));
		Assert.assertEquals(1000,map.get("sabun"));
	}
	
	public void testInsertOne() throws SQLException{
		int sabun = 4000;
		int pay = 3333;
		String name = "test";
		int result = dao.insertOne(sabun, name, pay);
		Assert.assertSame(1, result);
	}

}
