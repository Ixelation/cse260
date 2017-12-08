import java.util.*;
import java.io.*;
import java.lang.String.*;
public class ToHTML{
    public static void convert(String filename){
        HashSet<String> keywords = new HashSet<>(Arrays.asList("abstract", "continue", "for", "new", "switch" 
                    + "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if" 
                    + "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else" 
                    + "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch" 
                    + "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class" 
                    + "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"));
        Iterator it = keywords.iterator();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String current = null;
            FileWriter fileWriter = new FileWriter(filename.substring(0, filename.indexOf(".java")).concat(".html"));
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("<!DOCTYPE html> \n <html> \n <body> <span style=\"color:black;\">");
            while ((current = reader.readLine()) != null){
                writer.write("<p>");
                while (it.hasNext()){
                    String ckey = (String)it.next();
                    if (current.indexOf(ckey)!=-1) {
                        writer.write("<b style=\"color:navy;\">");
                        writer.write(current.substring(current.indexOf(ckey), current.indexOf(ckey)+ckey.length()));
                        current = current.substring(current.indexOf(ckey)+ckey.length());
                        writer.write("</b>");
                        break;
                    }
                }
                if (current.indexOf("//")!=-1||current.indexOf("/*")!=-1) {
                    writer.write("<span style=\"color:green;\">");
                    writer.write(current);
                    writer.write("<span style=\"color:black;\">");
                }
                if (current.indexOf("\"")!=-1){
                    writer.write("<span style =\"color:blue;\">");
                    int i=current.indexOf("\"");
                    writer.write(current.substring(i, current.substring(i+1).indexOf("\"")));
                    writer.write("<span style =\"color:black;\">");
                }
                else {writer.write(current);}
                writer.write("</p>");
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e) {System.out.println("File not found.");}
        catch (IOException e) {e.printStackTrace();}

    }
}
