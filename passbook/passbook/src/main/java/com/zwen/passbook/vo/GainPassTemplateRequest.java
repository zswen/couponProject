package com.zwen.passbook.vo;

import com.zwen.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User pick up pass template request</h1>
 * 6-18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {

    /** User id */
    private Long userId;

    /** Passtemplate Object */
    private PassTemplate passTemplate;

    /** Merchants who published this pass */
    private Merchants merchants;
}
