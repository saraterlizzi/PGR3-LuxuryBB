package Client;

import Client.Interface.AbstractFactory;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;

import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        ClientVisitor CV = ClientVisitor.getInstance();

        //CV.VisitProxy("start");

        CV.VisitAuthentication("login");
    }
}
