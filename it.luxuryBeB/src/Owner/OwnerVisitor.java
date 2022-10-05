package Owner;


import Owner.Interface.AbstractFactory;
import Owner.Interface.SocketProxy;
import Owner.Interface.Template.Button;
import Owner.Interface.Template.Form;
import Owner.Interface.Visitor;
import Server.Database;

import javax.swing.*;
import java.util.List;

public class OwnerVisitor implements Visitor {

    private static OwnerVisitor instance=null;

    public static OwnerVisitor getInstance() {
        if (instance == null) {
            instance = new OwnerVisitor();
        }
        return instance;
    }


    @Override
    public void VisitCheck() {
        AbstractFactory IF = FactoryMaker.getInstance().getFactory("init");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        finestra.getContentPane().removeAll();
        finestra.repaint();

        finestra.setVisible(true);
    }

    @Override
    public void VisitInsert() {
        AbstractFactory IF = FactoryMaker.getInstance().getFactory("init");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        finestra.getContentPane().removeAll();
        finestra.repaint();

        Form insert = IF.createForm("insertroom");
        insert.createForm();
        insert.insertForm(finestra);

        finestra.setVisible(true);
    }

    @Override
    public void VisitInit() {
        AbstractFactory IF = FactoryMaker.getInstance().getFactory("init");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        finestra.getContentPane().removeAll();
        finestra.repaint();

        Button booked = IF.createButton("viewbookedrooms");
        Button insert = IF.createButton("insertroom");
        booked.createButton();
        insert.createButton();
        booked.insertButton(finestra);
        insert.insertButton(finestra);

        OwnerProxy.getInstance().write("OWNER,ROOM,Room");
        String rooms = OwnerProxy.getInstance().read();
        if(!rooms.isEmpty()){
            List<String> label = List.of(rooms.split("-"));
            for (int i=0; i<label.size(); i++){
                String[] real_rooms = label.get(i).split(",");

                JLabel numero = new JLabel(real_rooms[2]);
                JLabel tipologia = new JLabel(real_rooms[0]);
                JLabel posti = new JLabel(real_rooms[1]);
                JLabel prezzo = new JLabel(real_rooms[3]);
                JLabel stato = new JLabel(real_rooms[4]);

                JLabel num = new JLabel("Numero camera:");
                JLabel tip = new JLabel("Tipologia camera:");
                JLabel pst = new JLabel("Posti letto:");
                JLabel prz = new JLabel("Prezzo:");
                JLabel sta = new JLabel("Stato:");

                numero.setBounds(300, 100+(50*i),100,30);
                tipologia.setBounds(450, 100+(50*i),100,30);
                posti.setBounds(600,100+(50*i), 100, 30);
                prezzo.setBounds(750, 100+(50*i), 100, 30);
                stato.setBounds(900,100+(50*i),100,30);

                num.setBounds(300, 50+(50*i),100,30);
                tip.setBounds(450, 50+(50*i),100,30);
                pst.setBounds(600,50+(50*i), 100, 30);
                prz.setBounds(750, 50+(50*i), 100, 30);
                sta.setBounds(900,50+(50*i),100,30);

                finestra.add(numero);
                finestra.add(tipologia);
                finestra.add(posti);
                finestra.add(prezzo);
                finestra.add(stato);

                finestra.add(num);
                finestra.add(tip);
                finestra.add(pst);
                finestra.add(prz);
                finestra.add(sta);
            }
        }
        finestra.repaint();
        finestra.setVisible(true);
    }

    public void VisitProxy(String where){
        SocketProxy P = OwnerProxy.getInstance();
        switch (where){
            case "start" -> {
                P.connectionSetup("localhost", 58);
            }
            case "end" -> {
                P.end();
            }
        };
    }
}
