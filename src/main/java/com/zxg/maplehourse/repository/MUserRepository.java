package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MUserRepository extends JpaRepository<MUserModel, Integer> {


   List<MUserModel> findByMUserAccountOrMUserTel(String mUserAccount, String mUserTel);

   List<MUserModel> findByMUserAccountAndMUserPassword(String mUserAccount,String mUserPassword);
}
