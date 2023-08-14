package ru.mdimension.tests.rest.backend.eventCenter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KulturaTest {

    @DataProvider(name = "simpleData")
    public Object[][] testDifferentStringLists(){
        return new Object[][]{
                {Arrays.asList("Hello", "world", "in", "a", "frame")},
                {Arrays.asList("Hi", "there")},
                {Collections.singletonList("")},
                {Arrays.asList("", "")},
                {Collections.singletonList(" ")},
                {Arrays.asList(" ", " ")},
                {Arrays.asList("Don't", "worry", ", ", "be", "happy!")},
                {Arrays.asList("approximately", "short", "text")}
        };
    }

    @Test(dataProvider = "simpleData")
    public void testTask(List<String> strings) {
        getFraseInFrame(strings);
    }

    private void getFraseInFrame(List<String> phrase) {
        int maxCount = phrase.stream()
                .mapToInt(String::length)
                .max().orElse(0);
        borders(maxCount);

        for (String word : phrase) {
            int spaces = maxCount - word.length();
            System.out.println("* " + word + Stream.generate(() -> " ").limit(spaces).collect(
                    Collectors.joining()) + " *");
        }
        borders(maxCount);
    }

    private void borders(int maxCount) {
        for (int i = 0; i < maxCount + 4; i++) {
            System.out.print('*');
        }
        System.out.println();
    }
}
