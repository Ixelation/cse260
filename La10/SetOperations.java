import java.util.*;
public class SetOperations{
    static String[] str1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
    static String[] str2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
    public static void union(){
        LinkedHashSet<String> s1 = new LinkedHashSet<String>(Arrays.asList(str1));
        LinkedHashSet<String> s2 = new LinkedHashSet<String>(Arrays.asList(str2));
        s2.addAll(s1);
        System.out.println(s2);
    }
    
    public static void intersect(){
        LinkedHashSet<String> s1 = new LinkedHashSet<String>(Arrays.asList(str1));
        LinkedHashSet<String> s2 = new LinkedHashSet<String>(Arrays.asList(str2));
        LinkedHashSet<String> s4 = (LinkedHashSet)s2.clone();
        s4.addAll(s1);
        Iterator i = s4.iterator();
        while (i.hasNext()){
            if (!s1.contains(i.next())||!s2.contains(i.next())) {i.remove();}
        }
        System.out.println(s4);
    }
    
    public static void diff(){
        LinkedHashSet<String> s1 = new LinkedHashSet<String>(Arrays.asList(str1));
        LinkedHashSet<String> s2 = new LinkedHashSet<String>(Arrays.asList(str2));
        s1.removeAll(s2);
        System.out.println(s1);
    }
}