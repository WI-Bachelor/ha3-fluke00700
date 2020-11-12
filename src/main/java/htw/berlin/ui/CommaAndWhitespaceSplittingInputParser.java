package htw.berlin.ui;

import htw.berlin.ui.InputParser;

import java.util.*;
import java.util.stream.Collectors;

public class CommaAndWhitespaceSplittingInputParser implements InputParser {
    @Override
    public Map<String, Integer> countKeywords(String line, Set<String> keywords) {

        if (line == null) {
            line = "";
        }
        Map<String, Integer> countedWords = new HashMap<String, Integer>();
        keywords.forEach(keyword ->
        {
            countedWords.put(keyword, 0);
        });
        String[] arrayLine = line.split("[ ,./?!_]");

        for (String currentWord : arrayLine) {
            if (countedWords.containsKey(currentWord))
                countedWords.replace(currentWord, countedWords.get(currentWord) + 1);
        }

        return countedWords;
    }
}

