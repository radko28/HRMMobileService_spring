package sk.cyklosoft.hrmservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.hrmservice.util.OrderByType;
import sk.cyklosoft.hrmservice.vo.SportActivity;

public class ComparatorFactory {
	public Comparator<SportActivity> getComparator(OrderByType orderBy) {
		Comparator<SportActivity> comparator = null;
		switch(orderBy) {
			case HRM_AVG_ASC:
				comparator =  new HrmAvgAscComparator();	
				break;
			case HRM_AVG_DESC:
				comparator =  new HrmAvgDescComparator();	
				break;
			case HRM_MAX_ASC:
				comparator =   new HrmMaxAscComparator();	
				break;
			case HRM_MAX_DESC:
				comparator =   new HrmMaxDescComparator();	
				break;
		}
		return comparator;
	}
}
