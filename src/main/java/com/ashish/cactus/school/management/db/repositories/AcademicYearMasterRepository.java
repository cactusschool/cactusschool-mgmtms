package com.ashish.cactus.school.management.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.management.db.model.AcademicYear;

@Component
public interface AcademicYearMasterRepository extends CrudRepository <AcademicYear, Integer>{
}
