package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MProvinceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface MProvinceRepository extends JpaRepository<MProvinceModel,Integer> ,JpaSpecificationExecutor{



    List<MProvinceModel> findAllBy();

    List<MProvinceModel> findAllByMProvinceName(String mProvinceName);


//    @Override
//    Page<MProvinceModel> findAll(Pageable pageable);
}
