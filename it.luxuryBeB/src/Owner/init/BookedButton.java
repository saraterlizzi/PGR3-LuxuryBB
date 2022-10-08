package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone inerente alla visualizzazione delle prenotazioni
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */
public class BookedButton implements Button {
    /** Attributo per il bottone di visualizzazione delle prenotazioni
     */
    private JButton booked = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone
     */
    @Override
    public void createButton() {
        booked = new JButton("Camere prenotate");
        booked.setBounds(50, 240, 200, 30);

        booked.setActionCommand("Owner-Button-Booked");
        booked.addActionListener(OwnerConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(booked);
    }
}
