package model;
import Collections.*;
import Thread.CreateTrees;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
        AVLAssistsGame.insert(k,assistsGame);
        AVLPointMatch.insert(k,pointMatch);
        AVLReboundsGame.insert(k,reboundsGame);
        AVLSteelGame.insert(k,steelGame);
        bw.close();
    }//End addPlayer

    public void importDataFile(File data){
        currentFilePath = data;
        createTrees();
    }//End importDataFile

    public ArrayList<Player> getPlayers(int key,String searchCriteria) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(currentFilePath));
        List<Integer> founds = getTreeToSearch(searchCriteria).search(key);
        ArrayList<Player> playersFound = new ArrayList<>();
        if(!founds.isEmpty()){
            Collections.sort(founds);
            int listIndex = 0;
            String playerData = br.readLine();
            for(int i = 1; listIndex < founds.size() && playerData != null; i++){
                if(i == founds.get(listIndex)){
                    String[] cP = playerData.split(separator);
                    Player player = new Player(cP[0],Integer.parseInt(cP[1]),cP[2],Integer.parseInt(cP[3]),
                    Integer.parseInt(cP[4]),Integer.parseInt(cP[5]),Integer.parseInt(cP[6]),Integer.parseInt(cP[7]) );
                    playersFound.add(player);
                    listIndex++;
                }//End if
                playerData = br.readLine();
            }//end for
        }//End if
        return playersFound;
    }//End getPlayersByBlocksPerGame

    private BST<Integer,Integer> getTreeToSearch(String searchCriteria){
        BST<Integer,Integer> toSearch = null;
        SearchCriteria c = SearchCriteria.valueOf(searchCriteria);
        switch (c){
            case BLOCKS_PER_GAME: toSearch = BSTBlockGame; break;
            case STEELS_PER_GAME: toSearch = AVLSteelGame; break;
            case POINTS_PER_MATCH: toSearch = AVLPointMatch; break;
            case REBOUNDS_PER_GAME: toSearch = AVLReboundsGame; break;
            case ASSISTS_PER_GAME: toSearch = AVLAssistsGame; break;
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
}//End FIBA
