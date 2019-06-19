package com.zwen.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5-6
 * object for responding http request
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    /** Error code */
    private Integer errorCode;

    /** error message. Return empty if request succeeded*/
    private String errorMsg = "";

    /** return object */
    private Object data;

    /**
     * Response constructor
     * @param data
     */
    public Response(Object data) {
        this.data = data;
    }
}
