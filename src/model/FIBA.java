package model;
import Collections.BBT;
import Collections.BST;
import Thread.CreateTrees;
import java.io.*;
import java.util.ArrayList;

public class FIBA {
    private final String separator = ";";
    private BST<Integer,Integer> BSTBlockGame;//bg
    private BBT<Integer,Integer> AVLAssistsGame;//ag
    private BBT<Integer,Integer> AVLPointMatch;//pm
    private BBT<Integer,Integer> AVLReboundsGame;//rg
    private BBT<Integer,Integer> AVLSteelGame;//sg
    /*
    * The csv file must have the next format
    * name;age;team;pm;ag;rg;sg;bg
    *   0   1   2   3  4  5  6  7
    * */
    private File currentFilePath;

    public FIBA(){
        BSTBlockGame = new BST<>();
        AVLAssistsGame = new BBT<>();
        AVLPointMatch = new BBT<>();
        AVLReboundsGame = new BBT<>();
        AVLSteelGame = new BBT<>();
    }//End FIBA constructor

    public void addPlayer(String name, int age,String team, int pointMatch,
                          int assistsGame, int reboundsGame, int steelGame, int blockGame) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(currentFilePath,true));
        int k = countLines() + 1;
        bw.write("\n"+name+separator+age+separator+team+separator+pointMatch+separator+assistsGame
                +separator+reboundsGame+separator+steelGame+separator+blockGame);
        AVLAssistsGame.insert(assistsGame,k);
        AVLPointMatch.insert(pointMatch,k);
        AVLReboundsGame.insert(reboundsGame,k);
        AVLSteelGame.insert(steelGame,k);
        bw.close();
    }//End addPlayer

    public void importDataFile(File data){
        currentFilePath = data;
        createTrees();
    }//End importDataFile

    public ArrayList<Player> getPlayersByBlocksPerGame(int key){

        return null;
    }//End getPlayersByBlocksPerGame

    public ArrayList<String> getPlayersByAssistsPerGame(int key){
        return null;
    }//End getPlayersByAssistsPerGame

    public ArrayList<String> getPlayersByPointsPerMatch(int key){
        return null;
    }//End getPlayersByPointsPerMatch

    public ArrayList<String> getPlayersByReboundsPerGame(int key){
        return null;
    }//End getPlayersByReboundsPerGame

    public ArrayList<String> getPlayersBySteelsPerGame(int key){
        return null;
    }//End getPlayersBySteelsPerGame

    private void createTrees(){

        CreateTrees pm = new CreateTrees(AVLPointMatch,3,currentFilePath);
        CreateTrees ag = new CreateTrees(AVLAssistsGame,4,currentFilePath);
        CreateTrees rg = new CreateTrees(AVLReboundsGame,5,currentFilePath);
        CreateTrees sg = new CreateTrees(AVLSteelGame,6,currentFilePath);
        CreateTrees bg = new CreateTrees(BSTBlockGame,7,currentFilePath);
        pm.start();
        ag.start();
        rg.start();
        sg.start();
    }//End createAVLTrees

    private int countLines() throws IOException{
        int c = 0;
        try{
            BufferedReader bw = new BufferedReader(new FileReader(currentFilePath));
            while(bw.readLine() != null) c++;
        }catch(IOException e){ e.printStackTrace();}
        return c;
    }//End coutnLines
}//End FIBA
