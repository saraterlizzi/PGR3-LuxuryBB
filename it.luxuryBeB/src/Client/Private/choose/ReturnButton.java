package Client.Private.choose;


import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

public class ReturnButton implements Button {

    private JButton returnb = new JButton("Torna indietro");

    @Override
    public void createButton() {
        returnb.setBounds(10, 25, 100, 30);

        returnb.setActionCommand("Private-Button-Back");
        returnb.addActionListener(PrivateConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(returnb);
    }
}
