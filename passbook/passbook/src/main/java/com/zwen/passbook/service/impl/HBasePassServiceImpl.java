package com.zwen.passbook.service.impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.zwen.passbook.service.IHBasePassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vo.PassTemplate;

/**
 * <h1>Pass Hbase service Implementation. Drop pass template to hbase</h1>
 */

@Slf4j
@Service
public class HBasePassServiceImpl implements IHBasePassService {

    private HbaseTemplate hbaseTemplate;

    @Override
    public boolean dropPassTemplateToHBase(PassTemplate passTemplate) {
        return false;
    }
}
