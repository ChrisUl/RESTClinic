package info.novatec.rest.clinic.util;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * Generator for IDs.
 */
public class IdGenerator {

    private static final int MIN = 1;
    private static final int MAX = 10000;

    public static String generateIdByName(String name) {
        String id = "";
        StringTokenizer stringTokenizer = new StringTokenizer(name.toLowerCase());

        id += stringTokenizer.nextToken().charAt(0);
        id += stringTokenizer.nextToken();

        return id;
    }

    /**
     * Generates a random integer.
     *
     * @return random integer
     */
    public static int generateRandomId() {
        Random rand = new Random();
        return rand.nextInt((MAX - MIN) + 1) + MIN;
    }
}
