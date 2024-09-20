package org.example.exception;

import org.example.model.Error;

import java.util.List;

public class ServiceException extends Exception{
  private List<Error> errormessage;




    public ServiceException(List<Error> errorList) {
        this.errormessage = errorList;

    }

    public List<Error> getErrormessage() {
        return errormessage;
    }
}
