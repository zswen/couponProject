package com.zwen.passbook.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Merchants Object. Corresponds to merchants table in mysql
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {

    /** merchants id, primariy key */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /** merchants name, unique */
    @Basic // @Transient is for fields not necessarily in the table
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /** merchants logo */
    @Basic
    @Column(name = "log_url", nullable = false)
    private String logoUrl;

    /** merchants license */
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /** merchants phone */
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /** merchants address */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /** if this merchants is authorized */
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;

}
