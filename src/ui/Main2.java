package ui;
import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        try{
            File f = new File("src\\ui\\prueba2.csv");
            if(f.createNewFile()){
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                String a = "Si funciono";
                bw.write(a);
                bw.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }//End main
}
