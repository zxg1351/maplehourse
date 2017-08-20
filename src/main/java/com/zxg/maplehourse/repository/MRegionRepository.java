package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MProvinceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface MRegionRepository extends JpaRepository<MProvinceModel,Integer> {



    List<MProvinceModel> findAllBy();


}
