package com.neuedu.my12306.usermgr.test;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.service.CertTypeService;

public class TestCertTypeService {
	

	CertTypeService cts = CertTypeService.getInstance();
	
	@Test
	public void testgetCertTypeList()
	{
		Assert.assertNotNull(cts.getCertTypeList());
	}
	
//	@Test
	public void testfindAccurate() throws Exception
	{
		Assert.assertNotNull(cts.FindAccurate("content", "学生证"));
	}
	
	@Test
	public void testfindDim() throws Exception
	{
		Assert.assertNotNull(cts.findDim("content", "证"));
	}
	
	
//	@Test
	public void testinsertCertType() throws Exception
	{
		CertType ct = new CertType();
		ct.setContent("新的证件类型");
		Assert.assertFalse(cts.insertCertType(ct));
	}
	
//	@Test
	public void testupdateCertType() throws Exception
	{
		CertType ct = new CertType();
		ct.setId(9);
		ct.setContent("新来的证件类型");
		Assert.assertFalse(cts.updateCertType(ct));
	}
	
//	@Test
	public void testdeleteCertType() throws Exception
	{
		Assert.assertFalse(cts.deleteCertType("id", 9));
	}	
}
