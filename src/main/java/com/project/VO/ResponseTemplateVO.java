package com.project.VO;

import com.project.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class is created so that this application can interact with the Department microservice.
// It allows endpoint information from both microservices to be returned as a single object.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private Department department;

}