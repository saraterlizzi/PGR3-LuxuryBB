package Client.Private;

import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Template.Text;
import Client.Private.booking.BookingDateForm;
import Client.Private.booking.PaymentCardForm;
import Client.Private.choose.BookingButton;
import Client.Private.choose.RecapButton;

public class PrivateFactory implements AbstractFactory {
    @Override
    public Form createForm(String type) {
        return switch (type){
            case "booking" -> new BookingDateForm();
            case "payment" -> new PaymentCardForm();
            default -> null;
        };
    }

    @Override
    public Button createButton(String type) {
        return switch (type){
            case "booking" -> new BookingButton();
            case "recap" -> new RecapButton();
            default -> null;
        };
    }

    @Override
    public Text createText(String type) {
        return null;
    }
}
