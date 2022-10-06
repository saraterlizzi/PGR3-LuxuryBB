package Client.Private;

import Client.Authentication.AuthenticationFacade;
import Client.Authentication.UserMemento;
import Client.ClientProxy;
import Client.FactoryMaker;
import Client.FrameMemento;
import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;

import javax.swing.*;
import java.util.List;

public class PrivateFacade {
    private static PrivateFacade instance=null;

    public static PrivateFacade getInstance() {
        if (instance == null) {
            instance = new PrivateFacade();
        }
        return instance;
    }
    public void PrivateInt(){
        AbstractFactory PF = FactoryMaker.getInstance().getFactory("private");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Button booking = PF.createButton("booking");
        Button recap = PF.createButton("recap");
        booking.createButton();
        booking.insertButton(finestra);
        recap.createButton();
        recap.insertButton(finestra);

        finestra.setVisible(true);
    }
    public void Booking(){
        AbstractFactory PF = FactoryMaker.getInstance().getFactory("private");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form booking = PF.createForm("booking");
        booking.createForm();
        booking.insertForm(finestra);

        finestra.setVisible(true);

    }
    public void Payment(){
        AbstractFactory PF = FactoryMaker.getInstance().getFactory("private");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form payment = PF.createForm("payment");
        payment.createForm();
        payment.insertForm(finestra);

        finestra.setVisible(true);
    }

    public void ViewB(){
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        ClientProxy.getInstance().write("PRIVATE,VIEW,booking,us_email,"+ UserMemento.getInstance().restoreState());
        String riepilogo = ClientProxy.getInstance().read();
        if(!riepilogo.isEmpty()){
            List<String> label = List.of(riepilogo.split("-"));
            for (int i=0; i<label.size(); i++) {
                String[] realriepilogo = label.get(i).split(",");

                JLabel data_inizio = new JLabel(realriepilogo[1]);
                JLabel data_fine = new JLabel(realriepilogo[2]);
                JLabel us_email = new JLabel(realriepilogo[3]);
                JLabel numero_stanza = new JLabel(realriepilogo[4]);

                JLabel dat_in = new JLabel("Data inizio:");
                JLabel dat_fin = new JLabel("Data fine:");
                JLabel us_em = new JLabel("Email:");
                JLabel num_sta = new JLabel("Numero stanza:");

                data_inizio.setBounds(300, 100+(50*i),100,30);
                data_fine.setBounds(450, 100+(50*i),100,30);
                us_email.setBounds(600,100+(50*i), 100, 30);
                numero_stanza.setBounds(750, 100+(50*i), 100, 30);

                dat_in.setBounds(300, 50+(50*i),100,30);
                dat_fin.setBounds(450, 50+(50*i),100,30);
                us_em.setBounds(600,50+(50*i), 100, 30);
                num_sta.setBounds(750, 50+(50*i), 100, 30);

                finestra.add(data_inizio);
                finestra.add(data_fine);
                finestra.add(us_email);
                finestra.add(numero_stanza);

                finestra.add(dat_in);
                finestra.add(dat_fin);
                finestra.add(us_em);
                finestra.add(num_sta);
            }
            }
        }
    }


