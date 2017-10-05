import java.util.*;
public class IteratorsOnLinked{
    public static void main(String args[]){
        LinkedList list = new LinkedList();
        Iterator<Integer> it = new LinkedList.iterator();
        for (int i=0; i<5000000; i++){
            list.add(i);
        }
        
        long startTime = System.currentTimeMillis();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
    }
}