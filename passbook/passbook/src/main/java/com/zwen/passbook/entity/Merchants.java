package com.zwen.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <h1>Merchants Object</h1>
 * 6-4
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {

    /** merchant id */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /** Merchant name */
    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /** Merchant logo */
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /** Merchant license */
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /** Phone */
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /** Address */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /** Merchant is valid */
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit;

}
