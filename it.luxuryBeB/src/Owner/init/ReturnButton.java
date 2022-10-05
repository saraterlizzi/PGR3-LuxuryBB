package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

public class ReturnButton implements Button {

    private JButton returnb = new JButton("Torna indietro");

    @Override
    public void createButton() {
        returnb.setBounds(50, 15, 200, 30);

        returnb.setActionCommand("Owner-Button-Back");
        returnb.addActionListener(OwnerConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(returnb);
    }
}
