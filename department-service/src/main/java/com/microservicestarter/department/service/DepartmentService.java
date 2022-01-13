package com.microservicestarter.department.service;

import com.microservicestarter.department.entity.DepartmentEntity;
import com.microservicestarter.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity saveDeparment(DepartmentEntity department) {
        log.info("Inside save department service");
        return departmentRepository.save(department);
    }

    public DepartmentEntity findByDepartmentId(Long departmentId) {
        log.info("Inside findById department service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
