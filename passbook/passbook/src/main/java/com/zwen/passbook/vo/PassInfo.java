package com.zwen.passbook.vo;

import com.zwen.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Pass info. Pass templates that users have picked up. From pass table in HBase</h1>
 * 6-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassInfo {

    /** info of a picked up pass */
    private Pass pass;

    /** pass template */
    private PassTemplate passTemplate;

    /** Merchants */
    private Merchants merchants;
}
