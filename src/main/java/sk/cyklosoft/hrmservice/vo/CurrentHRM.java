package sk.cyklosoft.hrmservice.vo;

public class CurrentHRM {
	
	int hrm;
	String time;
	
	public CurrentHRM(int hrm, String time) {
		this.hrm = hrm;
		this.time = time;
	}

	public int getHrm() {
		return hrm;
	}

	public void setHrm(int hrm) {
		this.hrm = hrm;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	

}
