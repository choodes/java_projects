import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class copyingfile {
    public static void main(String[] args) {
        
    
    try{
        FileReader reader= new FileReader("source.txt");
        FileWriter writer=new FileWriter("textfile.txt");
        int ch;
        while((ch=reader.read())!=-1){
            writer.write((char)ch);
        }
        reader.close();
        writer.close();
        
    }
    catch(IOException e){
        System.out.println(e.getMessage());
    }
    }
    
    
}
