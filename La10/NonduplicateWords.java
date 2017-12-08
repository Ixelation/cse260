import java.util.*;
public class NonduplicateWords{
    public void nonDuplicate(){
        Scanner sn = new Scanner(File);
        TreeSet set = new TreeSet<String>();
        while (sn.hasNextLine()){
            set.add(sn.nextLine());
        }
        System.out.println(set);
    }
}