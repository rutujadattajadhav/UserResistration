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
public class UpdateUserValidation {
    public void validate(ResistrationModel resistrationModel) throws ValidationException {
        List<Error> errorList =new ArrayList<>();
        if(Objects.isNull(resistrationModel)){
            errorList.add(new Error("object is null","2"));
        }else{
            if(StringUtils.isEmpty(resistrationModel.getFname())){
                errorList.add(new Error("First name is null","2"));
            }
            if(StringUtils.isEmpty(resistrationModel.getLname())){
                errorList.add(new Error("Last name is null","2"));
            }
            if(StringUtils.isEmpty(resistrationModel.getMob())){
                errorList.add(new Error(" mob is null","2"));
            }
            if(StringUtils.isEmpty(resistrationModel.getPassword())){
                errorList.add(new Error(" password is null","2"));
            }
            if(StringUtils.isEmpty(resistrationModel.getConfirmPassword())){
                errorList.add(new Error(" confirmpassword is null","2"));
            }
        }
      if(!errorList.isEmpty()){
          throw new ValidationException(errorList,3);
      }

    }
}
