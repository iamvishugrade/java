import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
 
public class MySubTreeMap 
{
     
    public static void main(String a[])
{
       
        TreeMap<String, String> hm = new          TreeMap<String, String>();
       
        hm.put("java", "language");
        hm.put("computer", "machine");
        hm.put("india","country");
        hm.put("mango","fruit");
        hm.put("game","cricket");
        System.out.println("TreeMap Entries:");
        System.out.println(hm);
        Map<String, String> subMap1 = hm.subMap("game", "java");
        System.out.println("Sub-Map enties:");
        System.out.println(subMap1);
        //how to get lower boundary also part of sub-map
        Map<String, String> subMap2 = hm.subMap("game", true, "java", true);
        System.out.println("Sub-Map enties:");
        System.out.println(subMap2);
        //how to omit upper boundary in the sub-map
        Map<String, String> subMap3 = hm.subMap("game", false, "java", true);
        System.out.println("Sub-Map enties:");
        System.out.println(subMap3);
    }
}
 
class MyCompr implements Comparator<String>
{
 
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
     
}