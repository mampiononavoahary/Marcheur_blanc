package org.example.oriented;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carte {
    private List<Lieu> lieux;
    private List<Rue> rues;

    public List<Rue> getRuesFromLieu(Lieu lieu) {
        return rues.stream().filter(rue -> rue.getStart().equals(lieu) || rue.getEnd().equals(lieu)).toList();
    }
}
