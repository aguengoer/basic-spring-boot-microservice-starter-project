package com.microservicestarter.user.service;


import com.microservicestarter.user.VO.Department;
import com.microservicestarter.user.VO.ResponseTemplateVO;
import com.microservicestarter.user.entity.UserEntity;
import com.microservicestarter.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public UserEntity saveUser(UserEntity user) {
        log.info("Inside save User service");
        return userRepository.save(user);
    }

    public UserEntity findByUserId(Long userId) {
        log.info("Inside findById User service");
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        UserEntity user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class);

        vo.setDepartment(department);
        vo.setUser(user);

        return vo;
    }
}
