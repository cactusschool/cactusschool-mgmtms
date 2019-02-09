package com.ashish.cactus.school.notice.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.notice.admin.db.model.SchoolMaster;

@Component
public interface SchoolMasterRepository extends CrudRepository <SchoolMaster, Integer>{
}
