import java.util.*;
import java.io.*;
import java.lang.Integer;
public class Letters{
    public void letters(String filename){
        FileReader reader = new FileReader(filename);
        BufferedReader b = new BufferedReader(reader);
        HashMap map = new HashMap<String, Integer>();
        map.put("A", 0);
        map.put("E", 0);
        map.put("I", 0);
        map.put("O", 0);
        map.put("U", 0);
        map.put("Consonants", 0);
        char a = ' ';
        while (b.read()!=-1){
            a = (char)(b.read());
            switch(a){
                case 'A':
                    map.put("A", ((map.get("A")).intVal()+1));
                case 'E':
                    map.put("E", (map.get("E")).intVal()+1);
                case 'I':
                    map.put("I", (map.get("I")).intVal()+1);
                case 'O':
                    map.put("O", (map.get("O")).intVal()+1);
                case 'U':
                    map.put("U", (map.get("U")).intVal()+1);
                default: map.put(Consonants, (map.get(Consonants)).intVal()+1);
            }
        }
    }
}