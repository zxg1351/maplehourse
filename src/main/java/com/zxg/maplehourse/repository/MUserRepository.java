package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MUserRepository extends JpaRepository<MUserModel, Integer>,JpaSpecificationExecutor {


   List<MUserModel> findByMUserAccountOrMUserTel(String mUserAccount, String mUserTel);

   List<MUserModel> findByMUserAccountAndMUserPassword(String mUserAccount,String mUserPassword);


   @Modifying
   @Transactional
   @Query("update MUserModel mu set mu.mUserName = ?1 , mu.mUserTel = ?2 where mu.id = ?3")
   int setmUesrName(String mUserName,String mUserTel,int id);
}
