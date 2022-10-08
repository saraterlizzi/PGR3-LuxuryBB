package Client.Authentication;

import Client.Authentication.Login.LoginForm;
import Client.Authentication.Login.RegistrationButton;
import Client.Authentication.Registration.RegistrationForm;
import Client.Interface.AbstractFactory;
import Client.Interface.Handler.ActionHandler;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Template.Text;

/**
 * Classe che implementa il pattern Abstract Factory per la creazione di famiglie di oggetti all'interno del
   sottopackage Authentication
 * @author Filomena De Rosa, Sara Terlizzi
 * @see AbstractFactory
 */
public class AuthenticationFactory implements AbstractFactory {

    /** Metodo per l'istanziamento del form
     @param type (quale form si vuole istanziare)
     @return form (assegnato in base a quello richiesto)
     */
    @Override
    public Form createForm(String type) {
        return switch (type)
                {
                    case "login" -> new LoginForm();
                    case "registration" -> new RegistrationForm();
                    default -> null;
                };
    }

    /** Metodo per l'istanziamento dei bottoni
     @param type (quale bottone si vuole istanziare)
     @return button (assegnato in base a quello richiesto)
     */
    @Override
    public Button createButton(String type) {
        return switch (type)
        {
            case "registration" -> new RegistrationButton();
            default -> null;
        };
    }

    /** Metodo per l'istanziamento del testo
     @param type (quale tipologia di testo si vuole istanziare)
     @return null
     */
    @Override
    public Text createText(String type) {
        return null;
    }
}
