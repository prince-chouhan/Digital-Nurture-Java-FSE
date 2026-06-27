package com.princechouhan.ormqueryhandson.repository;

import com.princechouhan.ormqueryhandson.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
