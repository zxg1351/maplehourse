package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MCityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MCityRepository extends JpaRepository<MCityModel,Integer> {


    List<MCityModel> findAllByMProvinceId(String provinceId);

}
