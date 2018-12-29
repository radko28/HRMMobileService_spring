package sk.cyklosoft.hrmservice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.hrmservice.comparator.ComparatorFactory;
import sk.cyklosoft.hrmservice.dao.SportDao;
import sk.cyklosoft.hrmservice.dao.UserDao;
import sk.cyklosoft.hrmservice.model.HRMData;
import sk.cyklosoft.hrmservice.service.SportService;
import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.HrmVO;
import sk.cyklosoft.hrmservice.vo.SportActivity;
import sk.cyklosoft.hrmservice.vo.SportActivityList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import sk.cyklosoft.hrmservice.model.User;

@Service("sportService")
@Component
public class SportServiceImpl implements SportService {
	
	@Autowired
	SportDao sportDao;
	@Autowired
	UserDao userDao;
	
	private static DateTimeFormatter DFT = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
	private static DateTimeFormatter DT = DateTimeFormat.forPattern("dd-MM-yyyy");

	
	public void startTraining(String username, SportType sportType) {
		userDao.updateUser(username, sportType);
	}
	
	public void stopTraining(String username) {
		userDao.updateUser(username, SportType.STOP);
	}

	public HrmVO  getTrainingData(String username, SportType sportType) {
		HrmVO  result = null;
		HRMData  hrmData = null;
		
		switch(sportType) {
			case RUNNING:
				//result = sportDao.getTrainingDataRun(username, SportType.RUNNIG, trainType);
				break;
			case INDOOR_CYCLING:
				hrmData = sportDao.getTrainingDataIndoorCyclo(username, SportType.INDOOR_CYCLING);
				result = new HrmVO();
				result.setHrm(hrmData.getHrm());
				result.setSportType(SportType.INDOOR_CYCLING);
				result.setDatetime(DFT.print(hrmData.getDatetime()));
				break;
		}
		return result;
	}

	public SportActivityList getTrainingStatisticList(String username, SportType sportType, String dateFrom, String dateTo, 
			OrderByType orderBy) {
		SportActivityList result = null;
		List<HRMData> hrmData = null;

		switch(sportType) {
			case RUNNING:
				//result = sportDao.getTrainingStatisticList(username, sportType, dateFrom, dateTo, from, to,orderBy);
			break;
			case INDOOR_CYCLING:
				hrmData = sportDao.getTrainingStatisticList(username, sportType, DFT.parseDateTime(dateFrom), DFT.parseDateTime(dateTo));
				result = countSportActivityList(hrmData, orderBy);
				break;
		}
		result.setDateFrom(dateFrom);
		result.setDateTo(dateTo);
		result.setOrderBy(orderBy);
		result.setSportType(sportType);
		return result;
	}

	
	private SportActivityList countSportActivityList(List<HRMData> hrmData, OrderByType orderBy) {
		SportActivityList result = new SportActivityList();
		List<SportActivity> sportActivityList = new ArrayList<SportActivity>();
		SportActivity sportActivity = new SportActivity();
		List<Integer> hrm = new ArrayList<Integer>();
		int hrmMax = 0;
		int hrmCurrent = 0;
		for(HRMData item : hrmData) {
			
			String date = DT.print(item.getDatetime());
			
//first item			
			if(sportActivity.getDate() == null) {
				sportActivity.setDate(date);
			}
			
			if(sportActivity.getDate() != null && sportActivity.getDate().equals(date)){
				hrmCurrent = item.getHrm(); 
				hrm.add(hrmCurrent);
//max value				
				hrmMax = hrmCurrent > hrmMax ? hrmCurrent : hrmMax;
			} else if(!sportActivity.getDate().equals(date)) {
				sportActivity.setHrm(hrm);
				sportActivity.setHrmAvg(getHrmAvg(hrm));
				sportActivity.setHrmMax(hrmMax);
				sportActivityList.add(sportActivity);
				
				sportActivity = new SportActivity();
				sportActivity.setDate(date);
				hrm = new ArrayList<>();
				hrmMax = 0;
				hrmCurrent = item.getHrm(); 
				hrm.add(hrmCurrent);
				hrmMax = hrmCurrent > hrmMax ? hrmCurrent : hrmMax;
			}
			
		}
		
//last item		
		//hrm.add(item.getHrm());
		sportActivity.setHrmAvg(getHrmAvg(hrm));
		sportActivity.setHrmMax(hrmMax);
		sportActivity.setHrm(hrm);
		sportActivityList.add(sportActivity);
//sort		
		ComparatorFactory comparatorFactory = new ComparatorFactory();
		Collections.sort(sportActivityList, comparatorFactory.getComparator(orderBy));
		result.setSportActivity(sportActivityList);
		return result;
	}

/**
 * average value
 * 	
 */
	private int getHrmAvg(List<Integer> hrm) {
		int sum = 0;
		for(int item : hrm) {
			sum += item;
		}
		return sum/hrm.size();
	}

	@Override
	public void setTrainingDataHRM(String username, HrmVO hrmVO) {
		
		User user = userDao.findUserByUsername(username);
		switch(hrmVO.getSportType()) {
			case RUNNING:
			//result = sportDao.getTrainingDataRun(username, SportType.RUNNIG, trainType);
			break;
			case INDOOR_CYCLING:
				HRMData hrm = new HRMData();
				hrm.setDatetime(DFT.parseDateTime(hrmVO.getDatetime()));
				hrm.setHrm(hrmVO.getHrm());
				hrm.setSportActivity(hrmVO.getSportType());
				hrm.setUsers(user);
				sportDao.setTrainingDataIndoorCyclo(hrm);
			break;
		}
		
	}

	@Override
	public void delete(String username, SportType sportType,
			DateTime dateFrom, DateTime dateTo) {
		sportDao.delete(username, sportType, dateFrom, dateTo);
	}



}
