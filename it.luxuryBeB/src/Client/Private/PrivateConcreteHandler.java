package Client.Private;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Authentication.Login.LoginForm;
import Client.Authentication.Registration.RegistrationForm;
import Client.ClientVisitor;
import Client.Interface.Handler.ActionHandler;
import Client.Private.booking.BookingDateForm;
import Client.Private.booking.PaymentCardForm;

import java.awt.event.ActionEvent;

public class PrivateConcreteHandler extends ActionHandler {
    private static ActionHandler instance = null;

    public static ActionHandler getInstance(){
        if (instance==null)
        {
            instance=new PrivateConcreteHandler();
        }
        return instance;
    }

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
                    ClientVisitor.getInstance().VisitPrivate("registration");
                } else if (e.getActionCommand().contains("Payment")) {
                    ClientVisitor.getInstance().VisitPrivate("payment");
                }
            }
        } else {
            super.successor.actionPerformed(e);
        }
    }
}
