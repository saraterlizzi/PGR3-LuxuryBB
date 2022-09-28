package Owner.init;

import Owner.Interface.Template.Button;

import javax.swing.*;

public class InsertRoomButton implements Button {
    private JButton room = null;

    @Override
    public void createButton() {
        room = new JButton("Aggiornamento camere");
        room.setBounds(50, 240, 200, 30);

    }

    @Override
    public void insertButton(JFrame finestra) {
            finestra.add(room);

    }
}