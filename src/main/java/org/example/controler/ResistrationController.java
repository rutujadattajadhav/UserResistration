package org.example.controler;

import org.example.exception.ServiceException;
import org.example.exception.ValidationException;
import org.example.model.ApplicationResponce;
import org.example.model.ResistrationModel;
import org.example.service.ResistrationService;
import org.example.validations.DeleteUserValidation;
import org.example.validations.SaveUserValidation;
import org.example.validations.UpdateUserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ControllerAdvice
@RestController
public class ResistrationController {
    @Autowired
   private ResistrationService resistrationService;

    @Autowired
    private SaveUserValidation saveUserValidation;
    @PostMapping("/saveResisterUser")
    public  ApplicationResponce saveResisterUser(@RequestBody ResistrationModel resistrationModel)  {
        try{
            saveUserValidation.validate( resistrationModel);
            ApplicationResponce applicationResponce = resistrationService.saveUser(resistrationModel);
            return applicationResponce;
        }catch(ValidationException validate){
             ApplicationResponce applicationResponce  =new ApplicationResponce();
            List errorList =validate.getMessages();
            applicationResponce.setError(errorList);
            return applicationResponce;}
        catch (ServiceException ex){
            ApplicationResponce applicationResponce  =new ApplicationResponce();
            List errorList =ex.getErrormessage();
            applicationResponce.setError(errorList);
            return applicationResponce;
        }
    }

    @Autowired
    private UpdateUserValidation updateUserValidation;

    @PutMapping("/updateuser")
    public ApplicationResponce updateSaveUser(@RequestBody ResistrationModel resistrationModel){
       try{
           updateUserValidation.validate(resistrationModel);
           ApplicationResponce applicationResponce=resistrationService.updateSaveUser(resistrationModel);
           return applicationResponce;
       } catch (ValidationException validate) {
           List errorList=validate.getMessages();
           ApplicationResponce applicationResponce  =new ApplicationResponce();
           applicationResponce.setError(errorList);
           return applicationResponce;}
           catch (ServiceException ex) {
           List errorList=ex.getErrormessage();
           ApplicationResponce applicationResponce  =new ApplicationResponce();
           applicationResponce.setError(errorList);
           return applicationResponce;
       }
    }



    @Autowired
    private DeleteUserValidation deleteUserValidation;
    @DeleteMapping("/deleteUser")
    public ApplicationResponce deleteResisterUser(@RequestHeader String mob){
        try {
            //deleteUserValidation.validate(mob);
            ApplicationResponce applicationResponce=resistrationService.deleteResisterUser(mob);
            return applicationResponce;
        } //catch (ValidationException validate) {
           // List errorList=validate.getMessages();
            //ApplicationResponce applicationResponce =new ApplicationResponce();
            //applicationResponce.setError(errorList);
            //return applicationResponce;}

         catch (ServiceException e) {
            List errorList=e.getErrormessage();
            ApplicationResponce applicationResponce =new ApplicationResponce();
            applicationResponce.setError(errorList);
            return applicationResponce;
        }


    }

}
