package Client.Private.booking;


import Client.Authentication.UserMemento;
import Client.ClientProxy;
import Client.ClientVisitor;
import Client.Interface.Handler.ActionHandler;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;
import Client.Private.RoomMemento;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

       String di = inizio.getYear()+"-"+(inizio.getMonth()+1)+"-"+inizio.getDay();
       String du = fine.getYear()+"-"+(fine.getMonth()+1)+"-"+ fine.getDay();

        ClientProxy.getInstance().write("BOOKING,ROOMS,Room,data_inizio,"+di+",data_fine,"+du);
        String rooms = ClientProxy.getInstance().read();
        if(!rooms.isEmpty()){
            List<String> label = List.of(rooms.split("/"));
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


                numero.setBounds(50, 200+(100*i),100,30);
                tipologia.setBounds(150, 200+(100*i),100,30);
                posti.setBounds(270,200+(100*i), 100, 30);
                prezzo.setBounds(350, 200+(100*i), 100, 30);
                prenota.setBounds(400,200+(100*i),100,30);

                num.setBounds(50, 150+(100*i),100,30);
                tip.setBounds(150, 150+(100*i),100,30);
                pst.setBounds(270,150+(100*i), 100, 30);
                prz.setBounds(350, 150+(100*i), 100, 30);

                prenota.addActionListener(new ActionHandler() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RoomMemento.getInstance().setMemento("booking,codice,"+ThreadLocalRandom.current().nextInt()+",data_inizio,"+di+",data_fine,"+du+",us_email,"+ UserMemento.getInstance().restoreState()+",numero_stanza,"+real_rooms[2]);
                        ClientVisitor.getInstance().VisitPrivate("payment");
                    }
                });

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
