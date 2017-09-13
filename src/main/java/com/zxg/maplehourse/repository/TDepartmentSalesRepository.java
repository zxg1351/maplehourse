package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentSalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentSalesRepository extends JpaRepository<TDepartmentSalesModel, Integer> {

    @Modifying
    @Transactional
    @Query("update TDepartmentSalesModel tdsm set " +
            "tdsm.updateUser =:updateUser," +
            "tdsm.updateTime= :updateTime," +
            "tdsm.saleName=:saleName," +
            "tdsm.saleType=:saleType" +
            " where tdsm.id= :id")
    int editSales(@Param("updateUser") Integer updateUser,
                  @Param("updateTime") Date updateTime,
                  @Param("saleName") String saleName,
                  @Param("saleType") String saleType,
                  @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentSalesModel tdsm set" +
            " tdsm.updateUser =:updateUser," +
            "tdsm.updateTime=:updateTime," +
            "tdsm.delFlag=:delFlag " +
            " where tdsm.id= :id")
    int deleteSalesById(@Param("updateUser") Integer updateUser,
                        @Param("updateTime") Date updateTime,
                        @Param("delFlag") String delFlag,
                        @Param("id") Integer id);


}
