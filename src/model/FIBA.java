package model;
import Collections.BBT;
import Collections.BST;
import java.util.ArrayList;

public class FIBA {
    BST<Integer,Integer> BSTBlockGame;
    BBT<Integer,Integer> AVLAssistsGame;
    BBT<Integer,Integer> AVLPointMatch;
    BBT<Integer,Integer> AVLReboundsGame;
    BBT<Integer,Integer> AVLSteelGame;

    public FIBA(){
        BSTBlockGame = new BST<>();
        AVLAssistsGame = new BBT<>();
        AVLPointMatch = new BBT<>();
        AVLReboundsGame = new BBT<>();
        AVLSteelGame = new BBT<>();
    }//End FIBA constructor

    public void addPlayer(String name, int age,String team, int pointMatch,
                          int assistsGame, int reboundsGame, int steelGame, int blockGame){

    }//End addPlayer

    public ArrayList<String> getPlayersByBlocksPerGame(int key){
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
}//End FIBA
