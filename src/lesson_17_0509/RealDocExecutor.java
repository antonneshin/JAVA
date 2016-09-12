package src.lesson_17_0509;

/**
 * Created by Student on 05.09.2016.
 */
public class RealDocExecutor implements ExecBehavior {
    @Override
    public void exec(Document doc) {
        doc.getAccA().setSalodo(doc.getAccA().getSalodo()-doc.getSumma());

        doc.getAccB().setSalodo(doc.getAccB().getSalodo()+doc.getSumma());

        System.out.println("from accA to accB = "+doc.getSumma());
    }
}
