package Client.Private;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Authentication.Login.LoginForm;
import Client.Authentication.Registration.RegistrationForm;
import Client.ClientVisitor;
import Client.Interface.Handler.ActionHandler;
import Client.Private.booking.BookingDateForm;
import Client.Private.booking.PaymentCardForm;

import java.awt.event.ActionEvent;

/**
 * Classe che estende ActionHandler per la gestione di eventi provocati dai JButton del sottopackage Private
 * @author Filomena De Rosa, Sara Terlizzi
 * @see ActionHandler
 */
public class PrivateConcreteHandler extends ActionHandler {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static ActionHandler instance = null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new PrivateConcreteHandler();
        }
        return instance;
    }

    /** Metodo per la gestione degli ActionEvent dei bottoni
     @param e (evento provocato dal bottone)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("Private")){
            if(e.getActionCommand().contains("Form")){
                if ((e.getActionCommand().contains("Booking"))){
                    BookingDateForm.comunicate();
                } else if (e.getActionCommand().contains("Payment")) {
                    PaymentCardForm.comunicate();
                }
            } else if ((e.getActionCommand().contains("Button"))) {
                if(e.getActionCommand().contains("Booking")){
                    ClientVisitor.getInstance().VisitPrivate("booking");
                } else if (e.getActionCommand().contains("Payment")) {
                    ClientVisitor.getInstance().VisitPrivate("payment");
                } else if (e.getActionCommand().contains("View")) {
                     ClientVisitor.getInstance().VisitPrivate("view");
                } else if (e.getActionCommand().contains("Back")) {
                    ClientVisitor.getInstance().VisitPrivate("init");
                }
            }
        }
    }
}
