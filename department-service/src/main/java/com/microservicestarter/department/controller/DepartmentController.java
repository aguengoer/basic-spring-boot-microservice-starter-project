package com.microservicestarter.department.controller;

import com.microservicestarter.department.entity.DepartmentEntity;
import com.microservicestarter.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public DepartmentEntity saveDeparment(@RequestBody DepartmentEntity department) {
        log.info("Inside department controller save");
        return departmentService.saveDeparment(department);
    }

    @GetMapping("/{id}")
    public DepartmentEntity findByDepartmentId(@PathVariable("id") Long departmentId) {
        log.info("Inside department controller findById");

        return departmentService.findByDepartmentId(departmentId);
    }
}
