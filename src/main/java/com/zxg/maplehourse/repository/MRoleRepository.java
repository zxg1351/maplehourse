package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MRoleModel;
import com.zxg.maplehourse.model.MUserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface MRoleRepository extends JpaRepository<MRoleModel, Integer>,JpaSpecificationExecutor{


    @Modifying
    @Transactional
    @Query("update MRoleModel mr set mr.updateUser =:updateUser,mr.updateTime= :updateTime,mr.mRoleName=:mRoleName,mr.mRoleNumber=:mRoleNumber where mr.id= :id")
    int editRole(@Param("updateUser") Integer updateUser, @Param("updateTime") Date updateTime, @Param("mRoleName") String mRoleName,
                 @Param("mRoleNumber") String mRoleNumber, @Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update MRoleModel mr set mr.updateUser =:updateUser,mr.updateTime=:updateTime,mr.delFlag=:delFlag  where mr.id= :id")
    int deleteRoleById(@Param("updateUser") Integer updateUser, @Param("updateTime") Date updateTime, @Param("delFlag") String delFlag, @Param("id") Integer id);



    Page<MRoleModel> findByDelFlag(String delFlag, Pageable pageable);
}
