package villanueva.ricardo.Day3;

import java.util.ArrayList;
import java.util.List;

public class GLEngine {
    private String[] lines;

    public GLEngine(String[] lines){
        this.lines = lines;
    }

    public int fix(){
        int ret = 0;
        for (int i = 0; i < lines.length; i++){
            char[] values = lines[i].toCharArray();
            for (int j = 0; j < values.length; j++){
                if (!Character.isDigit(values[j])){
                    continue;
                }
                String tempNum = String.valueOf(values[j]);
                boolean keepSiendoNum = true;
                int counter = 1;
                List<Integer> positions = new ArrayList<>();
                positions.add(j);
                while (keepSiendoNum){
                    if ((j + counter) == values.length){
                        keepSiendoNum = false;
                        continue;
                    }
                    if (Character.isDigit(values[j+counter])){
                        tempNum += String.valueOf(values[j+counter]);
                        positions.add(j+counter);
                        counter++;
                    }else {
                        keepSiendoNum = false;
                    }
                }
                j = j+counter;
                if (haveAbjacentCHAR(positions, lines, i)){
                    ret += Integer.parseInt(tempNum);
                }
            }
        }
        return ret;
    }

    private boolean haveAbjacentCHAR(List<Integer> positions, String[] lines, int linePosition) {
        boolean isAbjacent = false;

        Integer position0 = positions.get(0);
        if (position0 != 0){
            char c = lines[linePosition].charAt(position0 -1);
            if (!String.valueOf(c).equals(".")){
                isAbjacent = true;
            }
        }

        if (positions.get(positions.size()-1) != lines.length-1){
            char c = lines[linePosition].charAt(positions.get(positions.size()-1)+1);
            if (!String.valueOf(c).equals(".")){
                isAbjacent = true;
            }
        }
        String up = "";
        String down = "";
        if (linePosition != 0){
            int lastPositionLine = lines[linePosition - 1].length() - 1;
            if (position0 == 0 && positions.get(positions.size()-1) == lastPositionLine){
                up = lines[linePosition -1].substring(position0, lastPositionLine);
            } else if (position0 != 0 && positions.get(positions.size()-1) == lastPositionLine) {
                up = lines[linePosition -1].substring(position0 -1, lastPositionLine);
            } else if (position0 == 0 && positions.get(positions.size() - 1) != lastPositionLine) {
                up = lines[linePosition -1].substring(position0, lastPositionLine +1);
            }else {
                up = lines[linePosition -1].substring(position0 -1, lastPositionLine +1);
            }
            char[] upChars = up.toCharArray();
            for (char c: upChars){
                if (!String.valueOf(c).equals(".")){
                    isAbjacent = true;
                }
            }
        }
        if (linePosition != lines.length-1){
            int lastPositionLine = lines[linePosition + 1].length() - 1;
            if (position0 == 0 && positions.get(positions.size()-1) == lastPositionLine){
                down = lines[linePosition +1].substring(position0, lastPositionLine);
            } else if (position0 != 0 && positions.get(positions.size()-1) == lastPositionLine) {
                down = lines[linePosition +1].substring(position0 -1, lastPositionLine);
            } else if (position0 == 0 && positions.get(positions.size() - 1) != lastPositionLine) {
                down = lines[linePosition +1].substring(position0, lastPositionLine +1);
            }else {
                down = lines[linePosition +1].substring(position0 -1, lastPositionLine +1);
            }
            char[] downChars = down.toCharArray();
            for (char c: downChars){
                if (!String.valueOf(c).equals(".")){
                    isAbjacent = true;
                }
            }
        }
        return isAbjacent;
    }
}
