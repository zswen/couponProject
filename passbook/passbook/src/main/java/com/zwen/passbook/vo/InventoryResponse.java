package com.zwen.passbook.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>Response for Inventory for users</h1>
 * 6-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    /** User Id */
    private Long userId;

    /** Pass templates info. Unassigned and not expired templates for a user */
    private List<PassTemplateInfo> passTemplateInfos;
}
