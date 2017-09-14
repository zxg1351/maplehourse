package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.TDepartmentManagerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TDepartmentManagerRepository extends JpaRepository<TDepartmentManagerModel, Integer>,JpaSpecificationExecutor {

    @Modifying
    @Transactional
    @Query("update TDepartmentManagerModel tmm set " +
            "tmm.updateUser =:updateUser," +
            "tmm.updateTime= :updateTime," +
            "tmm.name=:name," +
            "tmm.type=:type " +
            " where tmm.id= :id")
    int editManager(@Param("updateUser") Integer updateUser,
                    @Param("updateTime") Date updateTime,
                    @Param("name") String name,
                    @Param("type") String type,
                    @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update TDepartmentManagerModel tmm set " +
            "tmm.updateUser =:updateUser," +
            "tmm.updateTime=:updateTime," +
            "tmm.delFlag=:delFlag " +
            " where tmm.id= :id")
    int deleteManagerById(@Param("updateUser") Integer updateUser,
                          @Param("updateTime") Date updateTime,
                          @Param("delFlag") String delFlag,
                          @Param("id") Integer id);


    Page<TDepartmentManagerModel> findByDelFlag(String delFlag, Pageable pageable);

}
