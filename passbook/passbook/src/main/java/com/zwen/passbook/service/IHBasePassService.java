package com.zwen.passbook.service;

import com.zwen.passbook.vo.PassTemplate;

/**
 * <h1>Pass Hbase service. Drop pass template to hbase</h1>
 * 6-13
 */
public interface IHBasePassService {

    /**
     * <h2>Write Passtemplate to HBase</h2>
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
