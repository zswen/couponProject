package com.zwen.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Log Object</h1>
 * 6-5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    /** Log action type */
    private String action;

    /** User id */
    private Long userId;

    /** timestamp */
    private Long timestamp;

    /** Client id address */
    private String remoteIp;

    /** Log info */
    private Object info = null;
}
