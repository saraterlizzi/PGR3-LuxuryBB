package Owner;


import Owner.Interface.AbstractFactory;

public class FactoryMaker {
    private static FactoryMaker Instance=null;

    public static FactoryMaker getInstance(){
        if (Instance==null){
            Instance = new FactoryMaker();
        }
        return Instance;
    }

    public AbstractFactory getFactory(String factory){
        return switch (factory){

            default -> null;
        };
    }
}
