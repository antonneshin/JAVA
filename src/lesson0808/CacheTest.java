package src.lesson0808;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
class DataHolder implements Serializable{
    String value="123";
}
public class CacheTest {
    public static void main(String[] args) {
        String fileName="cache.bin";
        DataHolder dataHolder=new DataHolder();
//        try{
//            ObjectOutputStream fis=new ObjectOutputStream(new FileOutputStream(fileName));
//            fis.writeObject(dataHolder);
//        } catch(Exception e){
//            e.printStackTrace();
//        }

        try{
            ObjectInputStream fin=new ObjectInputStream((new FileInputStream(fileName)));
            dataHolder=(DataHolder)fin.readObject();
            System.out.println(dataHolder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
