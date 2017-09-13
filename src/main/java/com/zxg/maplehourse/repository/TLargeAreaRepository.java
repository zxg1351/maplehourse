package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TLargeAreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TLargeAreaRepository extends JpaRepository<TLargeAreaModel, Integer> {

    @Modifying
    @Transactional
    @Query("update TLargeAreaModel tlam set tlam.updateUser =:updateUser,tlam.updateTime= :updateTime," +
            "tlam.largeAreaName=:largeAreaName where tlam.id= :id")
    int editFinance(@Param("updateUser") Integer updateUser, @Param("updateTime") Date updateTime, @Param("largeAreaName") String largeAreaName,
                    @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TLargeAreaModel tlam set tlam.updateUser =:updateUser,tlam.updateTime=:updateTime,tlam.delFlag=:delFlag  where tlam.id= :id")
    int deleteFinanceById(@Param("updateUser") Integer updateUser, @Param("updateTime") Date updateTime,
                          @Param("delFlag") String delFlag, @Param("id") Integer id);


}
