package com.neuedu.my12306.usermgr.test;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.service.CityService;

public class TestCityService {
	

	CityService cs = CityService.getInstance();
	
	@Test
	//濞村鐦弻銉﹀閹碉拷婀�
	public void testgetCertTypeList() throws Exception
	{
		Assert.assertNotNull(cs.getCityList("130000"));
	}
	
//	@Test
	//濞村鐦划鍓р�閺屻儲澹�
//	public void testfindAccurate() throws Exception
//	{
//		Assert.assertNotNull(cs.FindAccurate("city", "咸宁市"));
//	}
	
//	@Test
	//濞村鐦Ο锛勭ˇ閺屻儲澹�
//	public void testfindDim() throws Exception
//	{
//		Assert.assertNotNull(cs.findDim("city", "京"));
//	}
	
	
//	@Test
	//濞村鐦幓鎺戝弳
//	public void testinsertCity() throws Exception
//	{
//
//		City ct = new City();
//		ct.setCityid("123456");
//		ct.setCity("一市");
//		ct.setFather("湖北省");
//		Assert.assertTrue(cs.insertCity(ct));
//	}
	
//	@Test
//	濞村鐦弴瀛樻煀
//	public void testupdateCity() throws Exception
//	{
//		City ct = new City();
//		ct.setId(6);
//		ct.setCityid("130200");
//		ct.setCity("湯山市");
//		ct.setFather("130000");
//		Assert.assertTrue(cs.updateCity(ct));
//	}
	
//	@Test
	//濞村鐦崚鐘绘珟
//	public void testdeleteCity() throws Exception
//	{
//		Assert.assertTrue(cs.deleteCity("city", "湯山市"));
//	}	
}
