package sk.cyklosoft.hrmservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.hrmservice.vo.SportActivity;

public class HrmAvgAscComparator implements Comparator<SportActivity> {

	@Override
	public int compare(SportActivity arg0, SportActivity arg1) {
		int result = arg0.getHrmAvg() < arg1.getHrmAvg() ? -1 : arg0.getHrmAvg() > arg1.getHrmAvg() ? 1 : 0;  
		return result;
	}

}
