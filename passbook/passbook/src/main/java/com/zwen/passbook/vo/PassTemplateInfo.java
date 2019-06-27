package com.zwen.passbook.vo;


import com.zwen.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <h1>Pass template info. Merchant published but not yet been picked up by a user</h1>
 * 6-18
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo extends PassTemplate {

    /** Pass template */
    private PassTemplate passTemplate;

    /** Merchant who posted this pass template */
    private Merchants merchants;

}
