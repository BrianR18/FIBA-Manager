package model;

public class Player {
    private String name;
    private int age;
    private String team;
    private  int pointMatch;
    private  int reboundsGame;
    private  int assistsGame;
    private  int stealGame;
    private  int blockGame;

    public Player(String name, int age, String team, int pointMatch, int reboundsGame, int assistsGame, int stealGame, int blockGame) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.pointMatch = pointMatch;
        this.reboundsGame = reboundsGame;
        this.assistsGame = assistsGame;
        this.stealGame = stealGame;
        this.blockGame = blockGame;
    }//End player constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPointMatch() {
        return pointMatch;
    }

    public void setPointMatch(int pointMatch) {
        this.pointMatch = pointMatch;
    }

    public int getReboundsGame() {
        return reboundsGame;
    }

    public void setReboundsGame(int reboundsGame) {
        this.reboundsGame = reboundsGame;
    }

    public int getAssistsGame() {
        return assistsGame;
    }

    public void setAssistsGame(int assistsGame) {
        this.assistsGame = assistsGame;
    }

    public int getStealGame() {
        return stealGame;
    }

    public void setStealGame(int stealGame) {
        this.stealGame = stealGame;
    }

    public int getBlockGame() {
        return blockGame;
    }

    public void setBlockGame(int blockGame) {
        this.blockGame = blockGame;
    }
}//End player Class
