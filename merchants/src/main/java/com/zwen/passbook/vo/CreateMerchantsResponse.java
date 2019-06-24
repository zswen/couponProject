package com.zwen.passbook.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5.7
 * merchants creation operation response object
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /**
     * the Id we generated in database, will give it back to merchants. Failure will return -1
     */
    private Integer id;


}
