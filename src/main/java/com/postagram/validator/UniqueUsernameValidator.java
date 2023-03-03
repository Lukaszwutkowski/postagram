package com.postagram.validator;

import com.postagram.dao.UserRepository;
import com.postagram.domain.UniqueUsername;
import com.postagram.domain.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        User inDataBase = userRepository.findByUsername(value);
        if(inDataBase == null) {
            return true;
        }

        return false;
    }
}
