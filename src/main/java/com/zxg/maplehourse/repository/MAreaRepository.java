package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MAreaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.logging.SimpleFormatter;

public interface MAreaRepository extends JpaRepository<MAreaModel, Integer>, JpaSpecificationExecutor {


    List<MAreaModel> findAllByMCityId(String mCityId);

}
