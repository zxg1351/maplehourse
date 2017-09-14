package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentWorkerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentWorkerRepository extends JpaRepository<TDepartmentWorkerModel, Integer> ,JpaSpecificationExecutor {


    @Modifying
    @Transactional
    @Query("update TDepartmentWorkerModel tfm set tfm.updateUser =:updateUser," +
            "tfm.updateTime= :updateTime," +
            "tfm.tWorkName = :tWorkName," +
            "tfm.tWorkTel =:tWorkTel," +
            "tfm.tWorkAddress =:tWorkAddress," +
            "tfm.tWorkType=:tWorkType where" +
            " tfm.id= :id")
    int editWorker(@Param("updateUser") Integer updateUser,
                   @Param("updateTime") Date updateTime,
                   @Param("tWorkName") String tWorkName,
                   @Param("tWorkTel") String tWorkTel,
                   @Param("tWorkAddress") String tWorkAddress,
                   @Param("tWorkType") String tWorkType,
                   @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentWorkerModel tfm set tfm.updateUser =:updateUser," +
            "tfm.updateTime=:updateTime," +
            "tfm.delFlag=:delFlag  where " +
            "tfm.id= :id")
    int deleteWorkerById(@Param("updateUser") Integer updateUser, @Param("updateTime") Date updateTime,
                         @Param("delFlag") String delFlag, @Param("id") Integer id);



    Page<TDepartmentWorkerModel> findByDelFlag(String delFlag, Pageable pageable);
}
