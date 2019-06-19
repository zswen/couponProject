package com.zwen.passbook.vo;

import com.zwen.passbook.constant.ErrorCode;
import com.zwen.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Actuall coupon object. Object is used to pass between services
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    /** id of merchant */
    private Integer id;

    /** title of coupon */
    private String title;

    /** coupon summary */
    private String summary;

    /** coupon details */
    private String desc;

    /** maximum number of this coupon */
    private Long limit;

    /** if this coupon has token */
    private Boolean hasToken; // token are stored in Redis Set for performance

    /** background color */
    private Integer background;

    /** start time */
    private Date start;

    /** expired time */
    private Date end;

    /**
     * check if this coupon is a valid one
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (merchantsDao.findById(id) == null) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }
        return ErrorCode.SUCCESS;
    }
}
