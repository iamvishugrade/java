import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
 
public class MyReverseOrderMap 
{
 
    public static void main(String a[]){
       
TreeMap<String, String> hm = new TreeMap<String, String>();
        //add key-value pair to TreeMap
        hm.put("java", "language");
        hm.put("computer", "machine");
        hm.put("india","country");
        hm.put("mango","fruit");
        hm.put("game","cricket");
        System.out.println("TreeMap Entries:");
        System.out.println(hm);
        Map<String, String> rm = hm.descendingMap();
        System.out.println("Reverse Map Content: ");
        System.out.println(rm);
    }
}
 

     
