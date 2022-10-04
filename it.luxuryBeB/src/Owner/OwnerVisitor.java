package Owner;


import Owner.Interface.AbstractFactory;
import Owner.Interface.SocketProxy;
import Owner.Interface.Template.Button;
import Owner.Interface.Template.Form;
import Owner.Interface.Visitor;

import javax.swing.*;

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
