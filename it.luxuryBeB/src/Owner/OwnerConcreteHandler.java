package Owner;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Authentication.Login.LoginForm;
import Client.Authentication.Registration.RegistrationForm;
import Owner.Interface.Handler.ActionHandler;
import Owner.Room.InsertRoomForm;
import Owner.init.InsertRoomButton;

import java.awt.event.ActionEvent;

/**
 * Classe che estende ActionHandler per la gestione di eventi provocati dai JButton del sottopackage Owner
 * @author Filomena De Rosa, Sara Terlizzi
 * @see ActionHandler
 */
public class OwnerConcreteHandler extends ActionHandler {

    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static ActionHandler instance = null;


    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new OwnerConcreteHandler();
        }
        return instance;
    }

    /** Metodo per la gestione degli ActionEvent dei bottoni
     @param e (evento provocato dal bottone)
     @return nulla poichè void
     */
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
