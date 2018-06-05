package com.followupme.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchUserOtionDto {
    private SearchOptions searchOptions;
    private String value;


}
