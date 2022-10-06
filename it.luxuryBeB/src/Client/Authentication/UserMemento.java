package Client.Authentication;

import Client.Interface.Memento;

public class UserMemento implements Memento {
   private static UserMemento instance;
   private String email, password, id=null;

   public static UserMemento getInstance(){
       if (instance==null){
           instance=new UserMemento();
       }
       return instance;
    }

    public void setMemento (String email, String password, String id){
        this.email=email;
        this.password=password;
        this.id=id;
    }
    public String restoreState(){
        return email;
    }


}
