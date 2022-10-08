package Owner;

/**
 * Classe main del package Owner
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Owner.OwnerVisitor
 * @see Owner.OwnerProxy
 */
import Client.ClientVisitor;

public class Owner {

    /**
     Metodo main dell'intero package Owner
     @param args valori presi tramite linea di comando
     */
    public static void main (String[] args){
        OwnerVisitor OV = OwnerVisitor.getInstance();

        OV.VisitProxy("start");

        OV.VisitInit();
    }
}
