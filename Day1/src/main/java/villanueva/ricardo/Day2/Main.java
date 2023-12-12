package villanueva.ricardo.Day2;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static class CubeGame {
        private final List<Game> games;
        private final int redCubes;
        private final int greenCubes;
        private final int blueCubes;

        public CubeGame(List<Game> games, int redCubes, int blueCubes, int greenCubes){
            this.games = games;
            this.redCubes = redCubes;
            this.greenCubes = greenCubes;
            this.blueCubes = blueCubes;
        }

        public int play(){
            int sumIDs = 0;
            for (Game g: games){
                if (gamePossible(g)){
                    sumIDs += g.getID();
                }
            }

            return sumIDs;
        }

        private boolean gamePossible(Game g) {
            int redCubes = 0;
            int greenCubes = 0;
            int blueCubes = 0;

            for(String attemp: g.getAttemps()){
                String[] values = StringUtils.splitByWholeSeparator(attemp, ", ");
                for (String v: values){
                    String[] result = StringUtils.splitByWholeSeparator(v, " ");
                    switch (result[1]){
                        case "red" -> redCubes += Integer.parseInt(result[0]);
                        case "blue" -> blueCubes += Integer.parseInt(result[0]);
                        case "green" -> greenCubes += Integer.parseInt(result[0]);
                    }
                }
            }

            return redCubes <= this.redCubes && greenCubes <= this.greenCubes && blueCubes <= this.blueCubes;
        }
    }
}

