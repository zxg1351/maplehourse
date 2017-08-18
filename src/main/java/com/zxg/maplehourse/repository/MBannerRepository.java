package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MBannerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface MBannerRepository extends JpaRepository<MBannerModel, Integer> {


    List<MBannerModel> findAll();

    List<MBannerModel> findByMBannerNameLike(String mBannerName);
}
