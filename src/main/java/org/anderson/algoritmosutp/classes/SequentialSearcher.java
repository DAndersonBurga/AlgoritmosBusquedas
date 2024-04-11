package org.anderson.algoritmosutp.classes;

import org.springframework.stereotype.Component;

@Component
public class SequentialSearcher implements Search {
    @Override
    public int search(Word[] words, String query) {
        int posicion = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].getWord().equals(query)) {
                posicion = i;
                break;
            }
        }

        return posicion;
    }
}
