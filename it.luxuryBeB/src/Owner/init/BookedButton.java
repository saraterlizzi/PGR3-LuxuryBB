package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

public class BookedButton implements Button {
    private JButton booked = null;

    @Override
    public void createButton() {
        booked = new JButton("Camere prenotate");
        booked.setBounds(50, 240, 200, 30);

        booked.setActionCommand("Owner-Button-Booked");
        booked.addActionListener(OwnerConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(booked);
    }
}
