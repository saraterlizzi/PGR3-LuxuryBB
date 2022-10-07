package Client.Authentication.Login;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;

import javax.swing.*;

/** Classe per la creazione del bottone inerente alla registrazione del Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */
public class RegistrationButton implements Button {
    /** Attributo per il bottone di registrazione
     */
    private JButton registration = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone
     @return nulla poichè void
     */
    @Override
    public void createButton() {
        registration = new JButton("Registrati");
        registration.setBounds(50, 240, 200, 30);

        registration.setActionCommand("Authentication-Button-Registration");
        registration.addActionListener(AuthenticationConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(registration);
    }
}
