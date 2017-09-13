package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentFinanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentFinanceRepository extends JpaRepository<TDepartmentFinanceModel, Integer> {


    @Modifying
    @Transactional
    @Query("update TDepartmentFinanceModel tfm set" +
            " tfm.updateUser =:updateUser," +
            "tfm.updateTime= :updateTime," +
            "tfm.name=:name where tfm.id= :id")
    int editFinance(@Param("updateUser") Integer updateUser,
                    @Param("updateTime") Date updateTime,
                    @Param("name") String name,
                    @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentFinanceModel tfm set" +
            " tfm.updateUser =:updateUser," +
            "tfm.updateTime=:updateTime," +
            "tfm.delFlag=:delFlag " +
            " where tfm.id= :id")
    int deleteFinanceById(@Param("updateUser") Integer updateUser,
                          @Param("updateTime") Date updateTime,
                          @Param("delFlag") String delFlag,
                          @Param("id") Integer id);

}
