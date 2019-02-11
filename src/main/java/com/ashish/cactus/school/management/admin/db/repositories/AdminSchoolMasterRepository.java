package com.ashish.cactus.school.management.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.management.admin.db.model.AdminSchoolMaster;

@Component
public interface AdminSchoolMasterRepository extends CrudRepository <AdminSchoolMaster, Integer>{
}
