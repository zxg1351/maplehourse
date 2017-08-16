package com.zxg.maplehourse.Repository;

import com.zxg.maplehourse.Model.MProvinceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
public interface MProvinceRepository extends JpaRepository<MProvinceModel,Integer> {



    List<MProvinceModel> findAllBy();


}
