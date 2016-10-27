package sk.cyklosoft.hrmservice.vo;

import java.util.List;

import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.util.SportType;

public class SportActivityList {
	List<SportActivity> sportActivity;
	private String dateFrom;
	private String dateTo;
	private SportType sportType;
	private OrderByType orderBy;
	
	public List<SportActivity> getSportActivity() {
		return sportActivity;
	}
	public void setSportActivity(List<SportActivity> sportActivity) {
		this.sportActivity = sportActivity;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public SportType getSportType() {
		return sportType;
	}
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
	public OrderByType getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(OrderByType orderBy) {
		this.orderBy = orderBy;
	}
	
	

}
