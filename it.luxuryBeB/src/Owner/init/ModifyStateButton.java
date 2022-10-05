package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

public class ModifyStateButton implements Button {

    private JButton Modify = null;

    @Override
    public void createButton() {
        Modify = new JButton("Modifica stato");
        Modify.setBounds(50, 280, 200, 30);

        Modify.setActionCommand("Owner-Button-Modify");
        Modify.addActionListener(OwnerConcreteHandler.getInstance());
    }

    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(Modify);
    }
}
