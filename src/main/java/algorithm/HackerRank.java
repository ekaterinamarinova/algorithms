package algorithm;

import java.util.Arrays;

/**
 * Solutions from HackerRank problems are contained here
 */
public class HackerRank {

    /**
     * As Gary is hiking, he enters sequences of mountains and valleys.
     *
     * A mountain is when he has exceeded sea level and walked back down,
     * for example /\ is a mountain, represented as string it would be 'UD'.
     *
     * A valley is when he has gotten below sea level and walked back up,
     * for example \/ is a valley, represented as a string it would be 'DU'.
     *
     * Given a string, representing Gary's path, count how many valleys
     * he has entered and walked out of.
     *
     * @param s - string representing Gary's path.
     */
    public int countGarrysValleys(String s) {
        int seaLevel = 0;
        int valleyCount = 0;
        String[] eachStep = s.toLowerCase().split("");

        for (String direction : eachStep) {
            if ("u".equals(direction)) {
                ++seaLevel;
            } else {
                --seaLevel;
                continue;
            }

            if (seaLevel == 0) {
                ++valleyCount;
            }
        }
        System.out.println(valleyCount);
        return valleyCount;
    }

    /**
     * Emma is playing a new mobile game that starts with consecutively numbered clouds.
     * Some of the clouds are thunderheads and others are cumulus.
     * She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
     * She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting
     * position to the last cloud. It is always possible to win the game.
     *
     * For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
     */
    public static int countEmmasEasiestPath(int[] c) {
        byte steps = 0;
        int twoSteps;

        for (int i = 0; i < c.length - 1; i++) {
            twoSteps = i + 2;

            if (twoSteps < c.length && c[twoSteps] == 0) {
                ++i;
                ++steps;
                continue;
            }

            if (c[i] == 0) {
                ++steps;
            }
        }
        return steps;
    }

    /**
     * Given a string {@code s} that is "printed" {@code n} amount of times,
     * get the first {@code n} characters and return how many times does the
     * character 'a' occur.
     *
     * @param s - starting string
     * @param n - get the first {@code n} characters
     * @return  - how many times does 'a' occur in the given substring
     */
    public static int repeatedString(String s, int n) {
        return new String(new char[n])
                .replace("\0", s)
                .toLowerCase()
                .substring(0, n)
                .replaceAll("[b-z]", "")
                .split("")
                .length;
    }

    public static int repeatedStringWithStream(String s, int n) {
        String[] chars = new String(new char[n])
                .replace("\0", s)
                .split("");

        return (int) Arrays.stream(chars)
                .filter("a"::equals)
                .count();

    }

}
