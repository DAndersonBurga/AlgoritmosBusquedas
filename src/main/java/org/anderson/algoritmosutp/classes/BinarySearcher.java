package org.anderson.algoritmosutp.classes;

import org.springframework.stereotype.Component;

@Component
public class BinarySearcher implements Search {
    @Override
    public int search(Word[] words, String query) {

        int limiteInferior = 0;
        int limiteSuperior = words.length - 1;
        int indice;

        while (limiteInferior <= limiteSuperior) {
            indice = (limiteInferior + limiteSuperior) / 2;
            int comparacion = words[indice].getWord().compareTo(query);

            if (comparacion == 0) {
                return indice;
            } else if (comparacion < 0) {
                limiteInferior = indice + 1;
            } else {
                limiteSuperior = indice - 1;
            }
        }

        return -1;
    }
}
