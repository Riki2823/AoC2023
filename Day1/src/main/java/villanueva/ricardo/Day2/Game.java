package villanueva.ricardo.Day2;

public class Game {
    private int ID;
    private String[] attemps;
    public Game(int ID, String[] attemps){
        this.attemps = attemps;
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public String[] getAttemps() {
        return attemps;
    }
}
