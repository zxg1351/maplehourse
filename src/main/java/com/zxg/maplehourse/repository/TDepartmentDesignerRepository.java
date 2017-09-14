package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentDesignerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentDesignerRepository extends JpaRepository<TDepartmentDesignerModel, Integer>, JpaSpecificationExecutor {
    @Modifying
    @Transactional
    @Query("update TDepartmentDesignerModel tfm set" +
            " tfm.updateUser =:updateUser," +
            "tfm.updateTime= :updateTime," +
            "tfm.name=:name," +
            "tfm.type=:type  where tfm.id= :id")
    int editDesigner(@Param("updateUser") Integer updateUser,
                     @Param("updateTime") Date updateTime,
                     @Param("name") String name,
                     @Param("type") String type,
                     @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentDesignerModel tfm set" +
            " tfm.updateUser =:updateUser," +
            "tfm.updateTime=:updateTime," +
            "tfm.delFlag=:delFlag " +
            " where tfm.id= :id")
    int deleteDesignerById(@Param("updateUser") Integer updateUser,
                           @Param("updateTime") Date updateTime,
                           @Param("delFlag") String delFlag,
                           @Param("id") Integer id);


    Page<TDepartmentDesignerModel> findByDelFlag(String delFlag, Pageable pageable);

}
