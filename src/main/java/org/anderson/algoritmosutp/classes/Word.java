package org.anderson.algoritmosutp.classes;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Word implements Comparable<Word> {
    private String word;
    private String meaning;


    @Override
    public int compareTo(Word o) {
        return this.getWord().compareTo(o.getWord());
    }
}
