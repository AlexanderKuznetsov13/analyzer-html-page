package ru.agk13145.projects.htmlpageanalyzer.util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {

    @Test
    void countWords() {
        Map<String, Integer> counts = Util.countWords(new String[]{"слово1", "слово1", "слово2", "слово3", "слово1"});
        assertEquals(3, counts.get("слово1"));
        assertEquals(1, counts.get("слово2"));
        assertNull(counts.get("йцуйцуйцуйцу"));
    }

    @Test
    void splitWords() {
        String toTest = "Данная(строка)нужна!для[тестирования]строки\nна\tпредмет]наличия\tспец\tсимволов";
        String[] splitWords = Util.splitWords(toTest);
        String[] expected= {"Данная", "строка", "нужна", "для","тестирования", "строки", "на", "предмет","наличия","спец","символов"};
        assertArrayEquals(expected, splitWords);
    }

}
