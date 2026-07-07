import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;

public  class simpledairy{
   
         private static final  String dairy="dairy.txt";
        
        private  static Scanner scanner=new Scanner(System.in);
         public static void main(String[] args) {
            
        
        Boolean running=true;
     
        while(running){
            option();
             
             int choice=scanner.nextInt();
             scanner.nextLine();
        switch(choice){
            case 1:
                enter(scanner);
                break;
            case 2:
                view();
                break;
            case 3:
                running =false;
                break;
            default:
                System.out.println("invalid entry.please enter the correct option");
                
        }}
    }

    
    public static void   option(){
        System.out.println("write entries");
        System.out.println("1.entry");
        System.out.println("2.view");
        System.out.println("3. exit");
        System.out.println("enter your choice:");

    }
    public static void enter(Scanner scanner){
        System.out.println("enter your entry:");
        String entry=scanner.nextLine();
        try(FileWriter writer=new FileWriter(dairy,true) ){
            
            writer.write(LocalDateTime.now()+entry+"\n");
             }
        catch(IOException e){
                System.out.println(e.getMessage());
             }


    }
    public static void  view(){
        try(FileReader reader=new FileReader(dairy)){
            int ch;
            while((ch=reader.read())!=-1){
                System.out.print((char) ch);
            }
        }
        catch(IOException e){
            System.out.print(e.getMessage());
        }
    }
}