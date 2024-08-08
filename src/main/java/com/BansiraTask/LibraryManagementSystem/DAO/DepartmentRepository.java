package com.BansiraTask.LibraryManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BansiraTask.LibraryManagementSystem.Entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

}
