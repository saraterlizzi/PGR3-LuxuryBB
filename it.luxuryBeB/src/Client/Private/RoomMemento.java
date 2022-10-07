package Client.Private;

import Client.Interface.Memento;

public class RoomMemento implements Memento {
    private static RoomMemento instance;

    private String request = null;

    public static RoomMemento getInstance(){
        if (instance==null){
            instance = new RoomMemento();
        }
        return instance;
    }

    public void setMemento(String request){
        this.request=request;
    }

    public String restoreState(){
        return request;
    }
}
