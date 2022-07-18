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

    private RestTemplate restTemplate = new RestTemplate();

    public User saveUser(User user) {

        log.info("Inside saveUser of UserService");
        return userRepository.save(user);

    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId()
                        , Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;

    }

}