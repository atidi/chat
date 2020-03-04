package com.company.validator;

import com.company.dto.UserDto;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

@Component
public class UserDtoValidator implements Validator {

    Pattern pattern ;

    @Autowired
    private UserService userService;



    @PostConstruct
    public void init() {
        pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto dto = ((UserDto) o);
        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.first.name.required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.last.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.do.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.password.do.not.empty");

      /*  if (dto.getPassword().length() < 8 || dto.getPassword().length() > 19) {
            errors.rejectValue("password", "error.password.length", new Object[] { "8", "20" }, null);
        }*/
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            errors.rejectValue("email","error.password.not.match");

        if (!(pattern.matcher(dto.getEmail()).matches()))
            errors.rejectValue("email", "error.email.invalid");

        if(userService.isEmailExists(dto.getEmail()))
            errors.rejectValue("email","error.email.already.exists");
    }
}
