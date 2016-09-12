package src.lesson_17_0509;

/**
 * Created by Student on 05.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Document d = new Document(new InfoDocExecBehavior());

        DocumentExecutor de = new DocumentExecutor();

        Account accA = new Account();
        accA.setSalodo(100L);

        Account accB = new Account();
        accB.setSalodo(30L);

        d.setAccA(accA);
        d.setAccB(accB);

        d.setSumma(10L);

        de.exec(d);

    }
}
