package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MCityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MCityRepository extends JpaRepository<MCityModel,Integer>,JpaSpecificationExecutor {


    List<MCityModel> findAllByMProvinceId(String provinceId);




}
