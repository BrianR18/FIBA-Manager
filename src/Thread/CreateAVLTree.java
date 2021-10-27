package Thread;
import model.FIBA;
import Collections.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class CreateAVLTree extends Thread{

    private BBT<Integer,Integer> avlTree;
    private final int index;
    private final File currentFilePath;
    public CreateAVLTree(BBT<Integer,Integer> avlTree,int i,File path){
        index = i;
        this.avlTree = avlTree;
        currentFilePath = path;
    }//CreateAVLTree

    @Override
    public void run(){
        try {
            createAVLTree();
        }catch (IOException e){
            e.printStackTrace();
        }
    }//End run

    private void createAVLTree() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(currentFilePath));
        String currentLine = br.readLine();
        for(int i = 1; currentLine != null; i++){
            String[] playerData = currentLine.split(";");
            avlTree.insert(Integer.parseInt(playerData[index]),i);
            currentLine = br.readLine();
        }//End for
    }//End createAVLBlocksPerGame
}//End CreateAVLTree
