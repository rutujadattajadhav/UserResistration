package org.example.validations;

import org.example.exception.ValidationException;
import org.example.model.Error;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DeleteUserValidation {

    public void validate( String mob) throws ValidationException {
        List<Error> errorList=new ArrayList<>();
       if(Objects.isNull(mob)) {
           errorList.add(new Error("mob is null", "2"));
       }

       if(!errorList.isEmpty()){
           throw new ValidationException(errorList,3);
       }
    }
}
