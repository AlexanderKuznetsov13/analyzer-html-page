package ru.agk13145.projects.htmlpageanalyzer.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Util {

    private static final String DELIMITER = "[,.!?\'\";:()\n\r\t\\[\\] ]";

    public static String[] splitWords(String string) {
        return string.split(DELIMITER);
    }

    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            if (!counts.containsKey(word)) {
                counts.put(word, 1);
            } else
                counts.put(word, counts.get(word) + 1);
        }
        return counts;
    }

}
