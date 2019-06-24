package com.zwen.passbook.vo;

import com.zwen.passbook.constant.ErrorCode;
import com.zwen.passbook.dao.MerchantsDao;
import com.zwen.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 5-7
 * This is merchants' creation operation request object. used for creating a merchants and pass information through different services
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    /**
     * merchants name
     */
    private String name;

    /**
     * merchant logo url
     */
    private String logoUrl;

    /**
     * merchant license
     */
    private String businessLicenseUrl;

    /**
     * merchant phone
     */
    private String phone;

    /**
     * merchant address
     */
    private String address;

    /**
     * check if this is a validate request
     *
     * @param merchantsDao
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }
        if (this.logoUrl == null) {
            return ErrorCode.EMPTY_LOGO;
        }
        if (this.businessLicenseUrl == null) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if (this.address == null) {
            return ErrorCode.EMPTY_ADDRESS;
        }
        if (this.phone == null) {
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     * Convert this request object to a Merchants object which will be fit for database
     *
     * @return {@link Merchants}
     */
    public Merchants toMerchants() {
        Merchants merChants = new Merchants();

        merChants.setName(name);
        merChants.setLogoUrl(logoUrl);
        merChants.setBusinessLicenseUrl(businessLicenseUrl);
        merChants.setAddress(address);
        merChants.setPhone(phone);

        return merChants;
    }
}
