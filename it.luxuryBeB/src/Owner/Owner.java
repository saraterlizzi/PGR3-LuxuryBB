package Owner;

import Client.ClientVisitor;

public class Owner {
    public static void main (String[] args){
        OwnerVisitor OV = OwnerVisitor.getInstance();

        OV.VisitInit();
    }
    }
