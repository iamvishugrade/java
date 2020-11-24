import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
 
public class MySetWithCollection {
    public static void main(String a[]){
        List<String> li = new ArrayList<String>();
        li.add("one");
        li.add("two");
        li.add("three");
        li.add("four");
        System.out.println("List: "+li);
        //create a treeset with the list
        TreeSet<String> myset = new TreeSet<String>(li);
        System.out.println("Set: "+myset);
    }
}