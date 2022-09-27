package Client.Private.choose;

import Client.Interface.Template.Button;

import javax.swing.*;

public class RecapButton implements Button {
    private JButton recap = null;

    @Override
    public void createButton() {
        recap = new JButton("Riepilogo");
        recap.setBounds(50, 240, 200, 30);
    }

    @Override
    public void insertButton(JFrame finestra) {
       finestra.add(recap);
    }
}
