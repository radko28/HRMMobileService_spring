package sk.cyklosoft.hrmservice.service;

import org.joda.time.DateTime;

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
	
	void delete(String username, SportType sportType,
			DateTime dateFrom, DateTime dateTo);
}
