package ui;
import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try{
            File file = new File("src\\ui\\prueba.csv");
            int c = 0;
            BufferedReader bw = new BufferedReader(new FileReader(file));
            while(bw.readLine() != null) c++;
            System.out.print(c);
        }catch(IOException e){
            e.printStackTrace();
        }
    }//End main
}
