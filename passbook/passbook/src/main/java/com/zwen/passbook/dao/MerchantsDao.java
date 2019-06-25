package com.zwen.passbook.dao;

import com.zwen.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>Merchants Dao interface</h1>
 * 6-4
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * <h2>Retrieve Merchant object by id</h2>
     * @param id Merchant id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * <h2>Retrieve Merchant object by name</h2>
     * @param name Merchants name
     * @return {@link Merchants}
     */
    Merchants findByName(String name);

    /**
     * <h2>Given ids, retrieve merchants</h2>
     * @param ids Merchants ids
     * @return {@link Merchants}
     */

    List<Merchants> findAllBy(List<Integer> ids);

}
