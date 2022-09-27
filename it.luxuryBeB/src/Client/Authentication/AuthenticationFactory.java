package Client.Authentication;

import Client.Authentication.Login.LoginForm;
import Client.Authentication.Login.RegistrationButton;
import Client.Authentication.Registration.RegistrationForm;
import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Template.Text;

public class AuthenticationFactory implements AbstractFactory {

    @Override
    public Form createForm(String type) {
        return switch (type)
                {
                    case "login" -> new LoginForm();
                    case "registration" -> new RegistrationForm();
                    default -> null;
                };
    }

    @Override
    public Button createButton(String type) {
        return switch (type)
        {
            case "registration" -> new RegistrationButton();
            default -> null;
        };
    }

    @Override
    public Text createText(String type) {
        return null;
    }
}
