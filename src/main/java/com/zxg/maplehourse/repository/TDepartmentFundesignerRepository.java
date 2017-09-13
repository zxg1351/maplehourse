package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentFundesignerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentFundesignerRepository extends JpaRepository<TDepartmentFundesignerModel, Integer> {

    @Modifying
    @Transactional
    @Query("update TDepartmentFundesignerModel tfdm set" +
            " tfdm.updateUser =:updateUser," +
            "tfdm.updateTime= :updateTime," +
            "tfdm.name=:name, " +
            "tfdm.type=:type " +
            "where tfdm.id= :id")
    int editFundesigner(@Param("updateUser") Integer updateUser,
                        @Param("updateTime") Date updateTime,
                        @Param("name") String name,
                        @Param("type") String type,
                        @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentFundesignerModel tfdm set " +
            "tfdm.updateUser =:updateUser," +
            "tfdm.updateTime=:updateTime," +
            "tfdm.delFlag=:delFlag " +
            " where tfdm.id= :id")
    int deleteFundesignerById(@Param("updateUser") Integer updateUser,
                              @Param("updateTime") Date updateTime,
                              @Param("delFlag") String delFlag,
                              @Param("id") Integer id);


}
