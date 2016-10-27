package sk.cyklosoft.hrmservice.util;

import java.util.LinkedHashMap;
import java.util.Map;

public enum OrderByType {

	DATE("Date"),
	HRM_MAX_ASC("Hrm max. asc"),
    HRM_MAX_DESC("Hrm max. desc"),
    HRM_AVG_ASC("Hrm avg. asc"),
    HRM_AVG_DESC("Hrm avg. desc");

    private String value;
    
    OrderByType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Map<SportType, String> getRecommendedTypeMap() {
        Map<SportType, String> recommendedTypeMap = new LinkedHashMap<SportType, String>();
        for(SportType type:SportType.values()) {
            recommendedTypeMap.put(type, type.getValue());
        }
        return recommendedTypeMap;
    }

}