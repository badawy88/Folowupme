package com.followupme.users.utility;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>SearchOptions class</h1>
 * <p>
 * All Search Users Options <br>
 * Ex: Search by email or Search by username <br>
 * Any new option can be added easily here
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-05
 */
public enum SearchOptions {

    EMAIL("email"), USERNAME("username");
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
