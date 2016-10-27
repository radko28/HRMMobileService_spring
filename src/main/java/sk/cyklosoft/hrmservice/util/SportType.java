package sk.cyklosoft.hrmservice.util;

import java.util.LinkedHashMap;
import java.util.Map;


public enum SportType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    INDOOR_CYCLING("Indoor cycling"),
    STOP("Stop");


    private String value;
    
    SportType(String value) {
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
