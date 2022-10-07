package Client;

import Client.Interface.Memento;

public class UserMemento implements Memento {

    private static UserMemento instance= null;

    public static UserMemento getInstance() {
        if(instance==null){
            instance=new UserMemento();
        }
        return instance;
    }

    private String mail = null;

    public String RestoreState() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
