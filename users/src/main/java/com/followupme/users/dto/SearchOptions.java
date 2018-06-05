package com.followupme.users.dto;

import java.util.HashMap;
import java.util.Map;

public enum SearchOptions {

    EMAIL("email"),USERNAME("username");
    private String value;
    private static final Map<String, SearchOptions> OPTIONS_MAP = new HashMap<>();

    static {
        for (SearchOptions myEnum : values()) {
            OPTIONS_MAP.put(myEnum.getSearchOption(), myEnum);
        }
    }



    SearchOptions(String value) {
        this.value = value;
    }

    public String getSearchOption() {
        return value;
    }

    public static SearchOptions getByValue(String value) {
        return OPTIONS_MAP.get(value);
    }

}
