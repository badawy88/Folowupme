package com.followupme.users.utility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <h1>SearchUserOptionUtility class</h1>
 * <p>
 * An utitity to be used to facilate search for user and eleminate any mistake <br>
 * It will have "search by option" and the value
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-05
 */
@Data
@AllArgsConstructor
public class SearchUserOptionUtility {
    private SearchOptions searchOptions;
    private String value;
}
