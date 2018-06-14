package io.viktorot.jokes;

import java.util.Arrays;
import java.util.List;

public class Joker {

    private static List<String> JOKE_LIST = Arrays.asList("1", "2", "3", "4", "5");

    private Joker() {
    }

    public static String getRandomJoke() {
        int ind = (int) (Math.random() % JOKE_LIST.size());
        return JOKE_LIST.get(ind);
    }
}

