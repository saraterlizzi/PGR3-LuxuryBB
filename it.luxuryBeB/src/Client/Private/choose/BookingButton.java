package Client.Private.choose;

import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone inerente alla prenotazione della camera
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */
public class BookingButton implements Button {
    /** Attributo per il bottone di prenotazione della camera
     */
    private JButton booking = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone
     @return nulla poichè void
     */
    @Override
    public void createButton() {
        booking = new JButton("Prenotazione");
        booking.setBounds(50, 240, 200, 30);

        booking.setActionCommand("Private-Button-Booking");
        booking.addActionListener(PrivateConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(booking);
    }
}
