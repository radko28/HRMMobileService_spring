package sk.cyklosoft.hrmservice.mobile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import sk.cyklosoft.hrmservice.vo.HrmVO;

import sk.cyklosoft.hrmservice.vo.SportActivityList;

@RequestMapping("/sport")
public interface UserSport {
	
//start training	
	/*@RequestMapping(value = "/{username}/{sport_type}", method = RequestMethod.POST)
    public @ResponseBody void startTraining(@PathVariable String username, @PathVariable SportType sportType);
	*/
//stop training	
	/*@RequestMapping(value = "/{username}/{sport_type}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void stopTraining(@PathVariable String username, @PathVariable SportType sportType);
	*/
//set training data
	@RequestMapping(value = "/hrmdata/{username}", method = RequestMethod.POST)
	public @ResponseBody void setTrainingDataHRM(@PathVariable("username") String username,@RequestBody HrmVO hrm);
	
//last, current	real time reading
	@RequestMapping(value = "/hrmdata/{username}/{sport_type}", method = RequestMethod.GET)
    public @ResponseBody HrmVO getTrainingData(@PathVariable("username") String username, @PathVariable("sport_type") String sportType);
	
//individual ladder	
	@RequestMapping(value = "/hrmdatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}", method = RequestMethod.GET)
    public @ResponseBody SportActivityList getTrainingStatisticList(@PathVariable("username") String username, @PathVariable("sport_type") String sportType, 
    		@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo, @PathVariable("orderBy") String orderBy);
	
}
