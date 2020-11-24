import java.util.LinkedHashSet;
 
public class MyLinkedHashSetClear {
 
    public static void main(String a[]){
         
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        //add elements to HashSet
        lhs.add("first");
        lhs.add("second");
        lhs.add("third");
        System.out.println("My LinkedHashSet content:");
        System.out.println(lhs);
        System.out.println("Clearing LinkedHashSet:");
        lhs.clear();
        System.out.println("Content After clear:");
        System.out.println(lhs);
    }
}