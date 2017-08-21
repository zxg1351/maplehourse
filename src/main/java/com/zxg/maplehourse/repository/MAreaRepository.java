package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MAreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.logging.SimpleFormatter;

public interface MAreaRepository extends JpaRepository<MAreaModel,Integer> {




    List<MAreaModel> findAllByMCityId(String mCityId);


}
