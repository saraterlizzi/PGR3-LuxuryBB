package Client.Authentication.Login;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Interface.Template.Button;

import javax.swing.*;

public class RegistrationButton implements Button {

    private JButton registration = null;

    @Override
    public void createButton() {
        registration = new JButton("Registrati");
        registration.setBounds(50, 140, 200, 30);

        registration.setActionCommand("Authentication-Button-Registration");
        registration.addActionListener(AuthenticationConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(registration);
    }
}
