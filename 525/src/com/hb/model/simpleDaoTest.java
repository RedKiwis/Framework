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
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleDao() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new simpleDao());
		
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		simpleDao dao= new simpleDao();
		List<Map<String,Object>> list= dao.selectAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(6,list.size());
		for (Map<String,Object> map :list ){
			log.debug(map.get("sabubn"));
		}
		
	}

}
