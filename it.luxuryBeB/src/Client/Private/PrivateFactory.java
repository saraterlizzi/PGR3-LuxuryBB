package Client.Private;

import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Template.Text;
import Client.Private.booking.BookingDateForm;
import Client.Private.booking.PaymentCardForm;
import Client.Private.choose.BookingButton;
import Client.Private.choose.RecapButton;
import Client.Private.choose.ReturnButton;

/**
 * Classe che implementa il pattern Abstract Factory per la creazione di famiglie di oggetti all'interno del
 sottopackage Private
 * @author Filomena De Rosa, Sara Terlizzi
 * @see AbstractFactory
 */
public class PrivateFactory implements AbstractFactory {
    /** Metodo per l'istanziamento del form
     @param type (quale form si vuole istanziare)
     @return form (assegnato in base a quello richiesto)
     */
    @Override
    public Form createForm(String type) {
        return switch (type){
            case "booking" -> new BookingDateForm();
            case "payment" -> new PaymentCardForm();
            default -> null;
        };
    }

    /** Metodo per l'istanziamento dei bottoni
     @param type (quale bottone si vuole istanziare)
     @return button (assegnato in base a quello richiesto)
     */
    @Override
    public Button createButton(String type) {
        return switch (type){
            case "booking" -> new BookingButton();
            case "recap" -> new RecapButton();
            case "back" -> new ReturnButton();
            default -> null;
        };
    }

    /** Metodo per l'istanziamento del testo
     @param type (quale tipologia di testo si vuole istanziare)
     @return nulla
     */
    @Override
    public Text createText(String type) {
        return null;
    }
}
