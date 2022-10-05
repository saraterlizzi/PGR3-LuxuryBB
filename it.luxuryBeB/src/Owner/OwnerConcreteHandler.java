package Owner;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Authentication.Login.LoginForm;
import Client.Authentication.Registration.RegistrationForm;
import Owner.Interface.Handler.ActionHandler;
import Owner.Room.InsertRoomForm;
import Owner.init.InsertRoomButton;

import java.awt.event.ActionEvent;

public class OwnerConcreteHandler extends ActionHandler {
    private static ActionHandler instance = null;

    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new OwnerConcreteHandler();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Owner")){
            if(e.getActionCommand().contains("Button")){
                if (e.getActionCommand().contains("Insert")){
                    OwnerVisitor.getInstance().VisitInsert();
                } else if (e.getActionCommand().contains("Booked")) {
                    OwnerVisitor.getInstance().VisitCheck();
                } else if (e.getActionCommand().contains("Back")) {
                    OwnerVisitor.getInstance().VisitInit();
                } else if (e.getActionCommand().contains("Modify")){
                    OwnerVisitor.getInstance().VisitModify();
                }
            } else if (e.getActionCommand().contains("Form")) {
                if(e.getActionCommand().contains("Insert")){
                    InsertRoomForm.comunicate();
                }
            }
        } else {
            super.successor.actionPerformed(e);
        }

    }
}
