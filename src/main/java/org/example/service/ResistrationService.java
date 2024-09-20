package org.example.service;

import org.example.exception.ServiceException;
import org.example.model.ApplicationResponce;
import org.example.model.Error;
import org.example.model.ResistrationModel;
import org.example.repository.ResistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResistrationService {
   @Autowired
   private ResistrationRepository resistrationRepository;

   public ApplicationResponce saveUser(ResistrationModel resistrationModel) throws ServiceException {
       List<Error> errorList=new ArrayList<>();
       ApplicationResponce applicationResponce=new ApplicationResponce();
       if(resistrationRepository.findById(resistrationModel.getMob()).isPresent()){
           errorList.add(new Error("User already exit","8"));
           applicationResponce.setError(errorList);
           throw new ServiceException(errorList);
       }else{
           resistrationRepository.save(resistrationModel);
           applicationResponce.setData("Add user Successfully");
           return applicationResponce;
       }
    }

    public ApplicationResponce updateSaveUser(ResistrationModel resistrationModel) throws ServiceException {
        ApplicationResponce applicationResponce=new ApplicationResponce();
       if(resistrationRepository.findById(resistrationModel.getMob()).isPresent()){
           resistrationRepository.save(resistrationModel);
           applicationResponce.setData("Update usr successfully");
           return applicationResponce;
       }else{
           List<Error> errorList=new ArrayList<>();
           errorList.add(new Error("user not  exist","4"));
           applicationResponce.setError(errorList);
           throw new ServiceException(errorList);
       }
    }

    public ApplicationResponce deleteResisterUser(String mob) throws ServiceException {
        ApplicationResponce applicationResponce=new ApplicationResponce();
       if(resistrationRepository.findById(mob).isPresent()){
           resistrationRepository.deleteById(mob);
           applicationResponce.setData("Delete user Succefully");
           return applicationResponce;
       }else{
           List<Error> errorList=new ArrayList<>();
           applicationResponce.setError(errorList);
           throw new ServiceException(errorList);
       }
    }
}
