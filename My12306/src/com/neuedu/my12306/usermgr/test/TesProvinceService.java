package com.neuedu.my12306.usermgr.test;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.service.ProvinceService;

public class TesProvinceService {
	

	ProvinceService cs = ProvinceService.getInstance();
	
	@Test
	public void testgetCertTypeList() throws Exception
	{
		Assert.assertNotNull(cs.getProvinceList());
	}
	

}
