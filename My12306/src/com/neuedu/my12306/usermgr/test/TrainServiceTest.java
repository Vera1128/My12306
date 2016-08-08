package com.neuedu.my12306.usermgr.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.Train;
import com.neuedu.my12306.usermgr.service.TrainService;

public class TrainServiceTest {
	
	TrainService ts = TrainService.getInstance();
	
	@Test
	public void testGetTrainList(){
		Assert.assertNotNull(ts.getTrainList("沈阳", "哈尔滨", "2016-8-2"));
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub	
//		TrainService ts = TrainService.getInstance();
//		List<Train> l = new ArrayList<Train>();
//		l = ts.getTrainList("沈阳", "哈尔滨", "2016-8-2");
//		for (Train train : l) {
//			System.out.println(train);
//		}
//	}
}
