package Client.Private;

import Client.Authentication.AuthenticationFacade;
import Client.FactoryMaker;
import Client.FrameMemento;
import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;

import javax.swing.*;

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
    }
    public void Booking(){
        AbstractFactory PF = FactoryMaker.getInstance().getFactory("private");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form booking = PF.createForm("booking");
        booking.createForm();
        booking.insertForm(finestra);

    }
    public void Payment(){
        AbstractFactory PF = FactoryMaker.getInstance().getFactory("private");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form payment = PF.createForm("payment");
        payment.createForm();
        payment.insertForm(finestra);

    }

}
