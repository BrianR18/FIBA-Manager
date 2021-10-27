package ui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        try{
            File file = new File("src\\ui\\prueba.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String l = br.readLine();
            System.out.println(l);
            for (int i = 0; i < 5;i++){
                l = br.readLine();
                System.out.println(l);
            }//for*/
        }catch(IOException e){
            e.printStackTrace();
            //System.out.println("Qlo excepcion");
        }
    }//End main
}
