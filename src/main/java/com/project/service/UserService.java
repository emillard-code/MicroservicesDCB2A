package com.project.service;

import com.project.VO.Department;
import com.project.VO.ResponseTemplateVO;
import com.project.model.User;
import com.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {

        log.info("Slf4j: Inside saveUser of UserService");
        return userRepository.save(user);

    }

    // This method returns both Department and User objects as one ResponseTemplateVO object.
    // It interacts with the Department microservice to get information from it, for its own functions.
    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Slf4j: Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = new RestTemplate()
                .getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;

    }

}