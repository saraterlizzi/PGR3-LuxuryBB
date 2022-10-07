package Client.Authentication;

import Client.Authentication.Login.LoginForm;
import Client.Authentication.Login.RegistrationButton;
import Client.Authentication.Registration.RegistrationForm;
import Client.ClientVisitor;
import Client.Interface.Handler.ActionHandler;

import java.awt.event.ActionEvent;

/**
 * Classe che estende ActionHandler per la gestione di eventi provocati dai JButton del sottopackage Authentication
 * @author Filomena De Rosa, Sara Terlizzi
 * @see ActionHandler
 */
public class AuthenticationConcreteHandler extends ActionHandler {

    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static ActionHandler instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new AuthenticationConcreteHandler();
        }
        return instance;
    }

    /** Metodo per la gestione degli ActionEvent dei bottoni
     @param e (evento provocato dal bottone)
     @return nulla poichè void
     */
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
