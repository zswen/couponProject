package com.zwen.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h2>Template that has already been assigned to a user </h2>
 * 6-6
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pass {

    /** User id */
    private Long userId;

    /** rowKey in HBase */
    private String rowKey;

    /** Passtemplate rowkey in HBase. Foreign key */
    private String templateId;

    /** Template token. Can be null (-1) */
    private String token;

    /** Date assigned to this user */
    private Date assignedDate;

    /** Used/Consumed date. not null means has been used*/
    private Date conDate;
}
