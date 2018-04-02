package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Department;
import com.pm.productretail.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTaskMaker(AppUser taskMaker);

    List<Task> findAllByDepartment(Department department);
}
