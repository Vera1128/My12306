package com.neuedu.my12306.usermgr.dao;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.usermgr.domain.Train;

public interface TrainDao {
	List<Train> getTrainList(String fromplace, String toplace, String place);	//查询车次
}
