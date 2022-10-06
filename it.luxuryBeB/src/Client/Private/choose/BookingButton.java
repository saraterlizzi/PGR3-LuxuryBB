package Client.Private.choose;

import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

public class BookingButton implements Button {
    private JButton booking = null;
    @Override
    public void createButton() {
        booking = new JButton("Prenotazione");
        booking.setBounds(50, 240, 200, 30);

        booking.setActionCommand("Private-Button-Booking");
        booking.addActionListener(PrivateConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(booking);
    }
}
