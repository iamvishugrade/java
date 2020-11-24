import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
 
public class MyTreeMapEntrySet 
{
     
    public static void main(String a[]){
        TreeMap<String, String> hm = new 	TreeMap<String, String>();
        //add key-value pair to TreeMap
        hm.put("first", "FIRST INSERTED");
        hm.put("second", "SECOND INSERTED");
        hm.put("third","THIRD INSERTED");
        System.out.println(hm);
        //getting value for the given key from TreeMap
        Set<Entry<String, String>> entires = hm.entrySet();
        for(Entry<String,String> ent:entires)
{
            System.out.println(ent.getKey()+" ==> "+ent.getValue());
        }
    }
}