package sk.cyklosoft.hrmservice.service;


import java.util.List;

import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.HrmVO;
import sk.cyklosoft.hrmservice.vo.SportActivityList;

public interface SportService {
	
	void startTraining(String username, SportType sportType);
	
	void stopTraining(String username);
	
	HrmVO getTrainingData(String username, SportType sportType);

	SportActivityList getTrainingStatisticList(String username, SportType sportType, String dateFrom, String dateTo, 
			OrderByType orderBy);

	void setTrainingDataHRM(String username, HrmVO hrmVO);
	
	void deleteAll(String username);
	
	void deleteItems(String username, List<HrmVO> hrmVO);
	
}
