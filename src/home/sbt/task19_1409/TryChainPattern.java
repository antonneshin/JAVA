package src.home.sbt.task19_1409;

/**
 * Created by Пентагон on 14.09.2016.
 */

abstract class MobileOperator {
    public static int ENGENIER = 3;
    public static int MANAGER = 2;
    public static int CALL_OPERATOR = 1;
    public int opetorType;

    protected MobileOperator next;

    public MobileOperator setNext(MobileOperator operator){
        next = operator;
        return operator;
    }

    public void processRequest(String request, int requestType){
        if(requestType>opetorType) {
            System.out.println("from "+opetorType+" level: delegate your request to another specialist");
            next.processRequest(request, requestType);
            return;
        }
        specialistProcessing(request);

    }
    public void specialistProcessing(String request){};
}

class EngenierMobileOperator extends MobileOperator{
    public EngenierMobileOperator(int operatorType){
        this.opetorType = operatorType;
    }
    public void specialistProcessing(String request){
        System.out.println("I am an engenier. I can help you with your problem: "+request);
    }
}

class ManagerMobileOperator extends MobileOperator{
    public ManagerMobileOperator(int operatorType){
        this.opetorType = operatorType;
    }
    public void specialistProcessing(String request){
        System.out.println("I am an manager. I can help you with your problem: "+request);
    }
}

class PhoneMobileOperator extends MobileOperator{
    public PhoneMobileOperator(int operatorType){
        this.opetorType = operatorType;
    }
    public void specialistProcessing(String request){
        System.out.println("I am an phone-operator. I can help you with your problem: "+request);
    }
}

public class TryChainPattern {
    public static void main(String[] args) {
        MobileOperator oper,oper1, oper2;
        oper = new PhoneMobileOperator(1);
        oper1 = oper.setNext(new ManagerMobileOperator(2));
        oper2 = oper1.setNext(new EngenierMobileOperator(3));

        oper.processRequest("tell about rouming prices",2);
    }
}
