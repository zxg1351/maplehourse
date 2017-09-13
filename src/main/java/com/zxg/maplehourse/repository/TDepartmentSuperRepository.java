package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentSuperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentSuperRepository extends JpaRepository<TDepartmentSuperModel, Integer> {

    @Modifying
    @Transactional
    @Query("update TDepartmentSuperModel tsm set tsm.updateUser =:updateUser," +
            "tsm.updateTime= :updateTime," +
            "tsm.name=:name," +
            "tsm.type=:type" +
            " where" +
            " tsm.id= :id")
    int editFinance(@Param("updateUser") Integer updateUser,
                    @Param("updateTime") Date updateTime,
                    @Param("name") String name,
                    @Param("type") String type,
                    @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentSuperModel tsm set tsm.updateUser =:updateUser," +
            "tsm.updateTime=:updateTime," +
            "tsm.delFlag=:delFlag " +
            " where tsm.id= :id")
    int deleteFinanceById(@Param("updateUser") Integer updateUser,
                          @Param("updateTime") Date updateTime,
                          @Param("delFlag") String delFlag,
                          @Param("id") Integer id);


}
