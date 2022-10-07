package Client.Private.booking;


import Client.ClientProxy;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import javax.swing.*;
import java.util.List;

public class BookingDateForm implements Form {


    private JDatePicker datainizio = null;

    private static JFrame finestra = null;

    private JDatePicker datafine = null;

    private JButton prenotazione = null;

    private JLabel in, fin = null;

    private static  UtilDateModel inizio, fine = null;


    @Override
    public void createForm() {
        inizio = new UtilDateModel();
        fine = new UtilDateModel();

        datainizio = new JDatePicker(inizio);
        datafine = new JDatePicker(fine);

        prenotazione = new JButton("Ricerca");
        in = new JLabel("Data inizio:");
        fin = new JLabel("Data fine:");

        datainizio.setBounds(50, 100, 200, 30);
        datafine.setBounds(320, 100, 200, 30);
        prenotazione.setBounds(550, 100, 100, 25);
        in.setBounds(50, 70, 240, 30);
        fin.setBounds(320, 70, 240, 30);

        prenotazione.setActionCommand("Private-Form-Booking");
        prenotazione.addActionListener(PrivateConcreteHandler.getInstance());
    }

    public static void comunicate(){
       String di = inizio.getYear()+"-"+inizio.getMonth()+"-"+inizio.getDay();
       String du = fine.getYear()+"-"+fine.getMonth()+"-"+ fine.getDay();

        ClientProxy.getInstance().write("BOOKING,ROOMS,Room,data_inizio,"+di+",data_fine,"+du);
        String rooms = ClientProxy.getInstance().read();
        if(!rooms.isEmpty()){
            List<String> label = List.of(rooms.split("-"));
            for (int i=0; i<label.size(); i++){
                String[] real_rooms = label.get(i).split(",");

                JLabel numero = new JLabel(real_rooms[2]);
                JLabel tipologia = new JLabel(real_rooms[0]);
                JLabel posti = new JLabel(real_rooms[1]);
                JLabel prezzo = new JLabel(real_rooms[3]);

                JButton prenota = new JButton("Prenota");

                JLabel num = new JLabel("Numero camera:");
                JLabel tip = new JLabel("Tipologia camera:");
                JLabel pst = new JLabel("Posti letto:");
                JLabel prz = new JLabel("Prezzo:");


                numero.setBounds(300, 100+(50*i),100,30);
                tipologia.setBounds(450, 100+(50*i),100,30);
                posti.setBounds(600,100+(50*i), 100, 30);
                prezzo.setBounds(750, 100+(50*i), 100, 30);
                prenota.setBounds(900,100+(50*i),100,30);

                num.setBounds(300, 50+(50*i),100,30);
                tip.setBounds(450, 50+(50*i),100,30);
                pst.setBounds(600,50+(50*i), 100, 30);
                prz.setBounds(750, 50+(50*i), 100, 30);

                finestra.add(numero);
                finestra.add(tipologia);
                finestra.add(posti);
                finestra.add(prezzo);
                finestra.add(prenota);

                finestra.add(num);
                finestra.add(tip);
                finestra.add(pst);
                finestra.add(prz);

            }
        }
        finestra.repaint();
        finestra.setVisible(true);

    }

    @Override
    public void insertForm(JFrame finestra) {
        BookingDateForm.finestra =finestra;
        finestra.add(datainizio);
        finestra.add(datafine);
        finestra.add(prenotazione);
        finestra.add(in);
        finestra.add(fin);
    }
}
