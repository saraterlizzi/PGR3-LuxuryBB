package Client;

import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Luxury B&B");
        AbstractFactory AF = FactoryMaker.getInstance().getFactory("auth");

       /* Form login = AF.createForm("login");
        login.createForm();
        login.insertForm(finestra);
        Button registration = AF.createButton("registration");
        registration.createButton();

        registration.insertButton(finestra);
          */


        Form Regi = AF.createForm("Registration");
        Regi.createForm();
        Regi.insertForm(finestra);
        finestra.setSize(800, 740);
        finestra.setLayout(null);
        finestra.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(finestra, "Sicuro di Chiudere ?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        finestra.setVisible(true);
    }
}
