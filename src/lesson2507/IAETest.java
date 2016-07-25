package src.lesson2507;

/**
 * Created by Student on 25.07.2016.
 */
class SBTEmployee
{
    public SBTEmployee(int grade)
    {
        if ((grade<0)||(grade>16))
        {
            throw new IllegalArgumentException();
        }
    }
}
public class IAETest {
    public static void main(String[] args)
    {
        SBTEmployee sbte1=new SBTEmployee(2);
        SBTEmployee sbte2=new SBTEmployee(20);
    }
}
