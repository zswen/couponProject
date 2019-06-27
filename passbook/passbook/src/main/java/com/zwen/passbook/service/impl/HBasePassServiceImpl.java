package com.zwen.passbook.service.impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.zwen.passbook.constant.Constants;
import com.zwen.passbook.service.IHBasePassService;
import com.zwen.passbook.utils.RowKeyGenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vo.PassTemplate;

/**
 * <h1>Pass Hbase service Implementation. Drop pass template to hbase</h1>
 * 6-14
 */

@Slf4j
@Service
public class HBasePassServiceImpl implements IHBasePassService {

    /** Inject HBase Client to this class*/
    private final HbaseTemplate hbaseTemplate;

    @Autowired
    public HBasePassServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public boolean dropPassTemplateToHBase(PassTemplate passTemplate) {
        if (passTemplate == null) return false;
        String rowKey = RowKeyGenUtil.genPassTemplateRowKey(passTemplate); // Generate a unique rowKey

        try {
            if (hbaseTemplate.getConnection().getTable(
                    TableName.valueOf(Constants.PassTemplateTable.TABLE_NAME)
            ).exists(new Get(Bytes.toBytes(rowKey)))) { // Check if we have a duplication here
                log.warn("RowKey {} is already exist!", rowKey);
            }
        } catch (Exception ex) {
            log.error("DropPassTemplateToHBase Error: {}", ex.getMessage());
            return false;
        }

        Put put = new Put(Bytes.toBytes(rowKey)); // Create put object


        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.ID),  // Qualifier
                Bytes.toBytes(passTemplate.getId())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.TITLE),  // Qualifier
                Bytes.toBytes(passTemplate.getTitle())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.SUMMARY),  // Qualifier
                Bytes.toBytes(passTemplate.getSummary())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.DESC),  // Qualifier
                Bytes.toBytes(passTemplate.getDesc())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.HAS_TOKEN),  // Qualifier
                Bytes.toBytes(passTemplate.getHasToken())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B), // Family
                Bytes.toBytes(Constants.PassTemplateTable.BACKGROUND),  // Qualifier
                Bytes.toBytes(passTemplate.getBackground())); // Value

        /** Column group C */
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C), // Family
                Bytes.toBytes(Constants.PassTemplateTable.LIMIT),  // Qualifier
                Bytes.toBytes(passTemplate.getId())); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C), // Family
                Bytes.toBytes(Constants.PassTemplateTable.START),  // Qualifier
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getStart()))); // Value

        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C), // Family
                Bytes.toBytes(Constants.PassTemplateTable.END),  // Qualifier
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getEnd()))); // Value


        hbaseTemplate.saveOrUpdate(Constants.PassTemplateTable.TABLE_NAME, put);

        return true;
    }
}
