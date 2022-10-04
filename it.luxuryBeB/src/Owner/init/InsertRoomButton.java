package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

public class InsertRoomButton implements Button {
    private JButton room = null;

    @Override
    public void createButton() {
        room = new JButton("Aggiornamento camere");
        room.setBounds(50, 200, 200, 30);

        room.setActionCommand("Owner-Button-Insert");
        room.addActionListener(OwnerConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
            finestra.add(room);

    }
}
