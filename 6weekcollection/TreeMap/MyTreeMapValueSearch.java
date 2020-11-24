import java.util.TreeMap;
 
public class MyTreeMapValueSearch {
 
    public static void main(String a[]){
        TreeMap<String, String> hm = new TreeMap<String, String>();
        //add key-value pair to TreeMap
        hm.put("first", "FIRST INSERTED");
        hm.put("second", "SECOND INSERTED");
        hm.put("third","THIRD INSERTED");
        System.out.println(hm);
        if(hm.containsValue("SECOND INSERTED")){
            System.out.println("The TreeMap contains value SECOND INSERTED");
        } else {
            System.out.println("The TreeMap does not contains value SECOND INSERTED");
        }
        if(hm.containsValue("first")){
            System.out.println("The TreeMap contains value first");
        } else {
            System.out.println("The TreeMap does not contains value first");
        }
    }
}