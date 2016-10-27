package sk.cyklosoft.hrmservice;

import java.util.Random;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import sk.cyklosoft.hrmservice.data.HrmResponseData;
import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.HrmVO;
import sk.cyklosoft.hrmservice.vo.SportActivity;
import sk.cyklosoft.hrmservice.vo.SportActivityList;

public class SportServiceTest {
	private static String URL = "http://localhost:8080/HRMMobileService/sport";
	private static String USERNAME = "radko28";
	private static String USERNAME2 = "radko41";
	private RestTemplate restTemplate = null; 
	private HrmResponseData response = null;	
	 
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}	
	 
	@Test
	public void setTrainingDataHRM() {
		String method = "/hrmdata/" + USERNAME;
		HrmVO hrmVO = new HrmVO(); 
		hrmVO.setSportType(SportType.INDOOR_CYCLING);
		
		DateTime dateTime = new DateTime();
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}
		
		dateTime = dateTime.plusDays(1);
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}

		dateTime = dateTime.plusDays(1);
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}
		
		method = "/hrmdata/" + USERNAME2;
		
		dateTime = dateTime.plusDays(1);
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}
		
		dateTime = dateTime.plusDays(1);
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}

		dateTime = dateTime.plusDays(1);
		//one training
		for(int i =0; i < 10; i++) {
			dateTime = dateTime.plusSeconds(2);
			hrmVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			hrmVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			response = restTemplate.postForObject(URL + method, hrmVO, HrmResponseData.class);
		}
		
	}	 
	
	@Test
	public void getTrainingData() {
		String method = "/hrmdata/{username}/{sport_type}";
		response = restTemplate.getForObject(URL + method, HrmResponseData.class, USERNAME, SportType.INDOOR_CYCLING.name());
		System.out.println(response);
	}	
	
	@Test
	public void getTrainingStatisticList() {
		String method = "/hrmdatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}";
		String dateFrom = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(new DateTime(2016,10,25,11,15));
		String dateTo = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(new DateTime(2016,10,26,19,15));
		String orderBy = OrderByType.HRM_MAX_ASC.name();
		SportActivityList response =  restTemplate.getForObject(URL + method, SportActivityList.class, USERNAME, SportType.INDOOR_CYCLING.name(), dateFrom, dateTo, orderBy);
		System.out.println(response);
	}		

	
}
