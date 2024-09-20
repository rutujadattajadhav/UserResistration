package org.example.model;

import java.util.List;

public class ApplicationResponce {
     private Object data;
     private List<Error> error;


     public void setError(List<Error> error) {
          this.error = error;
     }

     public void setData(Object data) {
          this.data = data;
     }


     public Object getData() {
          return data;
     }

     public List<Error> getError() {
          return error;
     }

     @Override
     public String toString() {
          return "ApplicationResponce{" +
                  "data=" + data +
                  ", error=" + error +
                  '}';
     }
}
