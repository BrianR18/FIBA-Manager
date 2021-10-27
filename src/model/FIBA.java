package model;
import Collections.BBT;
import Collections.BST;
import Thread.CreateAVLTree;
import java.io.*;
import java.util.ArrayList;

public class FIBA {
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
                          int assistsGame, int reboundsGame, int steelGame, int blockGame){

    }//End addPlayer

    public void importDataFile(File data){
        currentFilePath = data;
        createAVLTrees();
    }//End importDataFile

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

    private void createAVLTrees(){
        CreateAVLTree pm = new CreateAVLTree(AVLPointMatch,3,currentFilePath);
        CreateAVLTree ag = new CreateAVLTree(AVLAssistsGame,4,currentFilePath);
        CreateAVLTree rg = new CreateAVLTree(AVLReboundsGame,5,currentFilePath);
        CreateAVLTree sg = new CreateAVLTree(AVLSteelGame,6,currentFilePath);
        pm.start();
        ag.start();
        rg.start();
        sg.start();
    }//End createAVLTrees

}//End FIBA
