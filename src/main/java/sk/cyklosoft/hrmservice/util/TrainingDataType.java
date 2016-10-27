package sk.cyklosoft.hrmservice.util;

public enum TrainingDataType {
	
    HRM("hrm"),
    SPEED("Speed"),
    DISTANCE("Distance"),
    TIME("Time"),
    WEIGHT("Weight");

	
	private String value;
	
	TrainingDataType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }


}
