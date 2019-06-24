package com.zwen.passbook.dao;

import com.zwen.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Merchants Dao interface. Data Access Object for retrieving information from database.
 * We don't need to implement it. JPA will do it for us
 */

public interface MerchantsDao extends JpaRepository<Merchants, Integer> { // <table, key>
    /**
     * retrieve object by using id
     *
     * @return {@link Merchants}
     * @prarm id
     */
    Merchants findById(Integer id);

    /**
     * @param name
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
