package Client.Private.booking;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Interface.Template.Form;

import javax.swing.*;

public class BookingDateForm implements Form {

    private static JTextField datainizio = null;

    private static JTextField datafine = null;

    private JButton prenotazione = null;

    private JLabel in, fin, pren = null;


    @Override
    public void createForm() {
        datainizio = new JTextField();
        datafine = new JTextField();
        prenotazione = new JButton("Prenota");
        in = new JLabel("Data inizio:");
        fin = new JLabel("Data fine:");
        pren = new JLabel("Area Prenotazione");

        datainizio.setBounds(50, 100, 200, 30);
        datafine.setBounds(50, 160, 200, 30);
        prenotazione.setBounds(50, 200, 200, 30);
        in.setBounds(50, 70, 240, 30);
        fin.setBounds(50, 130, 240, 30);
        pren.setBounds(50, 40, 230, 30);

        prenotazione.setActionCommand("Private-Form-Booking");
        prenotazione.addActionListener(AuthenticationConcreteHandler.getInstance());
    }

    public static void comunicate(){

    }

    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(datainizio);
        finestra.add(datafine);
        finestra.add(prenotazione);
        finestra.add(in);
        finestra.add(fin);
        finestra.add(pren);
    }
}
