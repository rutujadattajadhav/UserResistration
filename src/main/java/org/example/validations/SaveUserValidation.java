package org.example.validations;

import org.example.exception.ValidationException;
import org.example.model.Error;
import org.example.model.ResistrationModel;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SaveUserValidation {
    public void validate (ResistrationModel resistrationModel) throws ValidationException {
        List<Error> errorList = new ArrayList<Error>();
        if (Objects.isNull(resistrationModel)) {
            errorList.add(new Error("Object is null", "300"));
        } else {
            if (StringUtils.isEmpty(resistrationModel.getFname())) {
                errorList.add(new Error("first name is null", "300"));
            }
            if (StringUtils.isEmpty(resistrationModel.getLname())) {
                errorList.add(new Error("Last name is null", "300"));
            }
            if (StringUtils.isEmpty(resistrationModel.getMob())) {
                errorList.add(new Error(" mob is null", "300"));
            }
            if (StringUtils.isEmpty(resistrationModel.getPassword())) {
                errorList.add(new Error("password is null", "300"));
            }
            if (StringUtils.isEmpty(resistrationModel.getConfirmPassword())) {
                errorList.add(new Error("confirmPassword is null", "300"));
            }
        }
if(!errorList.isEmpty()){
    throw new ValidationException(errorList,3);
}
    }
}
