package Client.Authentication.Login;

import Client.Interface.Template.Button;

import javax.swing.*;

public class RegistrationButton implements Button {

    private JButton registration = null;

    @Override
    public void createButton() {
        registration = new JButton("Registrati");
        registration.setBounds(20, 400, 230, 30);
    }

    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(registration);
    }
}