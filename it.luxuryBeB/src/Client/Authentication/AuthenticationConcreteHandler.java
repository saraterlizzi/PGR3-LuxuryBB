package Client.Authentication;

import Client.Authentication.Login.LoginForm;
import Client.Authentication.Login.RegistrationButton;
import Client.Authentication.Registration.RegistrationForm;
import Client.ClientVisitor;
import Client.Interface.Handler.ActionHandler;

import java.awt.event.ActionEvent;

/**
 * Scopo della classe
 * @author Filomena De Rosa, Sara Terlizzi
 * @see ActionHandler
 */
public class AuthenticationConcreteHandler extends ActionHandler {

    private static ActionHandler instance = null;

    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new AuthenticationConcreteHandler();
        }
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Authentication")){
            if(e.getActionCommand().contains("Form")){
                if ((e.getActionCommand().contains("Login"))){
                    LoginForm.comunicate();
                } else if (e.getActionCommand().contains("Registration")) {
                    RegistrationForm.comunicate();
                }
            } else if ((e.getActionCommand().contains("Button"))) {
                if(e.getActionCommand().contains("Registration")){
                   Client.ClientVisitor.getInstance().VisitAuthentication("register");
                }
            }
        } else {
            super.successor.actionPerformed(e);
        }
    }
}
