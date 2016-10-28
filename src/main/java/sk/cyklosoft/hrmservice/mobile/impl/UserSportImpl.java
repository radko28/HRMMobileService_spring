package sk.cyklosoft.hrmservice.mobile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.config.annotation.RestEndpoint;
import sk.cyklosoft.hrmservice.mobile.UserSport;
import sk.cyklosoft.hrmservice.service.SportService;
import sk.cyklosoft.hrmservice.service.UserService;
import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.HrmVO;
import sk.cyklosoft.hrmservice.vo.SportActivityList;

@RestEndpoint
public class UserSportImpl implements UserSport {
	
	@Autowired
    SportService sportService;
    @Autowired
    UserService userService;

	
	/*public void startTraining(@PathVariable String username, @PathVariable SportType sportType) {
		sportService.startTraining(username, sportType);
	}*/
//set training data
	//@RequestMapping(value = "/datahrm/{username}", method = RequestMethod.POST)
   // @Override
    //@RequestMapping(value = "/register", method = RequestMethod.POST)
	//public @ResponseBody void setTrainingDataHRM(@RequestBody HrmVO hrmVO) {
	//public void setTrainingDataHRM(@PathVariable("username") String username, @RequestBody HrmVO hrmVO) {
		//
    	//
	//}
	
	/*public void stopTraining(@PathVariable String username, @PathVariable SportType sportType) {
		sportService.stopTraining(username);
	}
	*/
	@Override
	@RequestMapping(value = "/hrmdata/{username}", method = RequestMethod.POST)
	@ResponseBody
	public void setTrainingDataHRM(@PathVariable("username") String username, @RequestBody HrmVO hrmVO) {
		System.out.println(hrmVO.getHrm());
		System.out.println(hrmVO.getDatetime());
		System.out.println(hrmVO.getSportType());
		System.out.println(username);
		sportService.setTrainingDataHRM(username, hrmVO);
	}

	@Override
	@RequestMapping(value = "/hrmdata/{username}/{sport_type}", method = RequestMethod.GET)
	@ResponseBody
	public HrmVO getTrainingData(@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType) {
		HrmVO sportAvtivity = sportService.getTrainingData(username, SportType.valueOf(sportType));
		return sportAvtivity;
	}

	@Override
	@RequestMapping(value = "/hrmdatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}", method = RequestMethod.GET)
	@ResponseBody
	public SportActivityList getTrainingStatisticList(
			@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType,
			@PathVariable("dateFrom") String dateFrom,
			@PathVariable("dateTo") String dateTo,
			@PathVariable("orderBy") String orderBy) {
		SportActivityList sportAvtivityList = null;
		
		sportAvtivityList = sportService.getTrainingStatisticList(username, SportType.valueOf(sportType), dateFrom, dateTo, OrderByType.valueOf(orderBy));
		return sportAvtivityList;
	}


}
