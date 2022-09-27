package Owner.init;

import Owner.Interface.Template.Button;

import javax.swing.*;

public class BookedButton implements Button {
    private JButton booked = null;

    @Override
    public void createButton() {
        booked = new JButton("Camere prenotate");
        booked.setBounds(50, 240, 200, 30);
    }

    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(booked);
    }
}
