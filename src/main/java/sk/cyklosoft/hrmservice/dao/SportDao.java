package sk.cyklosoft.hrmservice.dao;

import java.util.List;

import org.joda.time.DateTime;

import sk.cyklosoft.hrmservice.model.HRMData;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.util.TrainType;
import sk.cyklosoft.hrmservice.vo.SportActivity;


public interface SportDao {

	void setTrainingDataRun(String username, SportType runnig, long datetime, double hrm);

	void setTrainingDataIndoorCyclo(final HRMData hrm);

	SportActivity getTrainingDataRun(String username, SportType runnig, TrainType trainType);

	HRMData getTrainingDataIndoorCyclo(String username, SportType indoorCycling);

	List<HRMData> getTrainingStatisticList(String username, SportType sportType, DateTime dateFrom, DateTime dateTo);
	
	HRMData getCurrentHRM(String username, SportType sportType);
	
	void delete(String username);

}
