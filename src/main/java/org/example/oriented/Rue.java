package org.example.oriented;

import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Rue {
    private String name;
    private Lieu start;
    private Lieu end;

    public boolean validateRue(Lieu siAllerEnArriere, Lieu siAllerEnAvant) {
        if (Objects.equals(siAllerEnArriere.getName(), siAllerEnAvant.getName())) {
            throw new RuntimeException("Information not valide");
        }
        return true;
    }
}
