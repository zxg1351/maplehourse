package com.zxg.maplehourse.repository;

import com.zxg.maplehourse.model.MUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MUserRepository extends JpaRepository<MUserModel, Integer> {
}
