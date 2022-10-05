package Owner.init;

import Owner.Interface.Template.Button;

import javax.swing.*;

public class ModifyStateButton implements Button {

    private JButton Modify = null;

    @Override
    public void createButton() {
        Modify = new JButton("Modifica stato");
        Modify.setBounds(50, 280, 200, 30);
    }

    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(Modify);
    }
}
