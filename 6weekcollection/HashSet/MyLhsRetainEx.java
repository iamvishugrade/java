import java.util.LinkedHashSet;
 
public class MyLhsRetainEx {
 
    public static void main(String a[]){
         
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        //add elements to LinkedHashSet
        lhs.add("first");
        lhs.add("second");
        lhs.add("third");
        lhs.add("apple");
        lhs.add("rat");
        System.out.println(lhs);
        LinkedHashSet<String> subSet = new LinkedHashSet<String>();
        subSet.add("rat");
        subSet.add("second");
        subSet.add("first");
        lhs.retainAll(subSet);
        System.out.println("LinkedHashSet content:");
        System.out.println(lhs);
    }
}