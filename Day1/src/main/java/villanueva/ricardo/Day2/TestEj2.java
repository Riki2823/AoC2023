package villanueva.ricardo.Day2;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestEj2 {

    @Test
    public void sampleInput() {
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""";

        Map<Integer, String[]> gameMap = processInput(input);
        List<Game> games = new ArrayList<>();
        gameMap.forEach((key, value) ->{
            games.add(new Game(key, value));
        });

        System.out.println("Hola");
    }

    public static Map<Integer, String[]> processInput(String input) {
        Map<Integer, String[]> gameMap = new HashMap<>();

        String[] lines = StringUtils.splitByWholeSeparator(input, "\n");
        for (String line : lines) {
            String[] parts = StringUtils.splitByWholeSeparator(line, ":");
            if (parts.length == 2) {
                String gameInfo = StringUtils.trim(parts[0]);
                String restOfString = StringUtils.trim(parts[1]);

                int gameNumber = Integer.parseInt(gameInfo.split(" ")[1]);

                String[] values = restOfString.split(";");

                for (int i = 0; i < values.length; i++) {
                    values[i] = StringUtils.trim(values[i]);
                }

                gameMap.put(gameNumber, values);
            }
        }

        return gameMap;
    }
}
