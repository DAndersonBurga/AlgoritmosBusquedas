package org.anderson.algoritmosutp.utils;

import org.anderson.algoritmosutp.classes.OxfordDictionary;
import org.anderson.algoritmosutp.classes.Word;

import java.io.*;
import java.util.*;

public class LectorTxt {

    public static OxfordDictionary leerTxt() {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/src/main/resources/static/oxford.txt");
        OxfordDictionary oxfordDictionary = new OxfordDictionary();

        List<Word> words = new ArrayList<>();
        try(
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split("==>");
                Word word = new Word(partes[0], partes[1]);

                words.add(word);
            }

            words.sort(Comparator.comparing(Word::getWord));
            oxfordDictionary.setWords(words.toArray(new Word[0]));

            return oxfordDictionary;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}