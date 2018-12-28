package sk.cyklosoft.hrmservice.data;

import sk.cyklosoft.hrmservice.vo.HrmVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HrmResponseData {
	
	private HrmVO hrm;
	
	public HrmVO getHrm() {
		return hrm;
	}

	public void setHrm(HrmVO hrm) {
		this.hrm = hrm;
	}

}
