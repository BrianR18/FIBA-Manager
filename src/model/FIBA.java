package model;
import Collections.*;
import Thread.CreateTrees;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FIBA {
    private final String DEFAULT_FOLDER = "data\\players_data.csv";
    private final String separator = ",";
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
        boolean created = true;
        if(currentFilePath == null){
            currentFilePath = new File(DEFAULT_FOLDER);
            created = currentFilePath.createNewFile();
            if(!created)
                createTrees();
        }//End if
        BufferedWriter bw = new BufferedWriter(new FileWriter(currentFilePath,true));
        int k = countLines() + 1;
        String toWrite = name+separator+age+separator+team+separator+pointMatch+separator+assistsGame
                +separator+reboundsGame+separator+steelGame+separator+blockGame;
        toWrite = (k == 1)?toWrite:"\n"+toWrite;
        bw.write(toWrite);
        AVLAssistsGame.insert(k,assistsGame);
        AVLPointMatch.insert(k,pointMatch);
        AVLReboundsGame.insert(k,reboundsGame);
        AVLSteelGame.insert(k,steelGame);
        BSTBlockGame.insert(k,blockGame);
        bw.close();
    }//End addPlayer

    public void importDataFile(File data){
        currentFilePath = data;
        BSTBlockGame = new BST<>();
        AVLAssistsGame = new BBT<>();
        AVLPointMatch = new BBT<>();
        AVLReboundsGame = new BBT<>();
        AVLSteelGame = new BBT<>();
        createTrees();
    }//End importDataFile

    public ArrayList<Player> searchPlayers(int key,String searchCriteria) throws IOException{
        ArrayList<Player> playersFound = null;
        if(currentFilePath != null){
            BufferedReader br = new BufferedReader(new FileReader(currentFilePath));
            List<Integer> founds = getTreeToSearch(searchCriteria).search(key);
            playersFound = new ArrayList<>();
            if(!founds.isEmpty()){
                Collections.sort(founds);
                int listIndex = 0;
                String playerData = br.readLine();
                for(int i = 1; listIndex < founds.size() && playerData != null; i++){
                    if(i == founds.get(listIndex)){
                        String[] cP = playerData.split(separator);
                        Player player = new Player(cP[0],Integer.parseInt(cP[1]),cP[2],Integer.parseInt(cP[3]),
                        Integer.parseInt(cP[4]),Integer.parseInt(cP[5]),Integer.parseInt(cP[6]),Integer.parseInt(cP[7]));
                        playersFound.add(player);
                        listIndex++;
                    }//End if
                    playerData = br.readLine();
                }//end for
            }//End if
        }//End if
        return playersFound;
    }//End getPlayersByBlocksPerGame

    private BST<Integer,Integer> getTreeToSearch(String searchCriteria){
        BST<Integer,Integer> toSearch = null;
        SearchCriteria c = SearchCriteria.valueOf(searchCriteria);
        switch (c){
            case BLOQUEOS: toSearch = BSTBlockGame; break;
            case ROBOS: toSearch = AVLSteelGame; break;
            case PUNTOS: toSearch = AVLPointMatch; break;
            case REBOTES: toSearch = AVLReboundsGame; break;
            case ASISTENCIAS: toSearch = AVLAssistsGame; break;
        }//End switch
        return toSearch;
    }//End getTreeSearchCriteria

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
        bg.start();
    }//End createAVLTrees

    private int countLines() throws IOException{
        int c = 0;
        try{
            BufferedReader bw = new BufferedReader(new FileReader(currentFilePath));
            while(bw.readLine() != null) c++;
        }catch(IOException e){ e.printStackTrace();}
        return c;
    }//End coutnLines


    public void deletePlayer(Player playerToDelete){
        int pointMatch = playerToDelete.getPointMatch();
        int reboundsGame = playerToDelete.getReboundsGame();
        int assistsGame = playerToDelete.getAssistsGame();
        int stealGame = playerToDelete.getStealGame();
        int blockGame = playerToDelete.getBlockGame();

        BSTBlockGame.delete(BSTBlockGame.searchOneValue(blockGame));
        AVLPointMatch.delete(AVLPointMatch.searchOneValue(pointMatch));
        AVLAssistsGame.delete(AVLAssistsGame.searchOneValue(assistsGame));
        AVLReboundsGame.delete(AVLReboundsGame.searchOneValue(reboundsGame));
        AVLSteelGame.delete(AVLSteelGame.searchOneValue(stealGame));
    }

    public void modifiedPlayer(Player oldPlayer, Player newPlayer){
        deletePlayer(oldPlayer);
    }//End modifiedPlayer
}//End FIBA
