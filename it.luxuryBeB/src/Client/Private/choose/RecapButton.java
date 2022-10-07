package Client.Private.choose;

import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

public class RecapButton implements Button {
    private JButton recap = null;

    @Override
    public void createButton() {
        recap = new JButton("Riepilogo");
        recap.setBounds(50, 280, 200, 30);

        recap.setActionCommand("Private-Button-View");
        recap.addActionListener(PrivateConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
       finestra.add(recap);
    }
}
