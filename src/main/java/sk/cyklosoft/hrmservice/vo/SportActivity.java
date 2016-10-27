package sk.cyklosoft.hrmservice.vo;

import java.util.List;

public class SportActivity {
	
	private int hrmMax;
	private int hrmAvg;
	private String date;
	private List<Integer> hrm;
	
	public int getHrmMax() {
		return hrmMax;
	}
	public void setHrmMax(int hrmMax) {
		this.hrmMax = hrmMax;
	}
	public int getHrmAvg() {
		return hrmAvg;
	}
	public void setHrmAvg(int hrmAvg) {
		this.hrmAvg = hrmAvg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Integer> getHrm() {
		return hrm;
	}
	public void setHrm(List<Integer> hrm) {
		this.hrm = hrm;
	}
	

}
