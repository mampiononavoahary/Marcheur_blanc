import org.example.oriented.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MarcheTest {
    @Test
    void MarcheTest(){
        Lieu HEI = new Lieu("HEI");
        Lieu Pullman = new Lieu("Pullman");
        Lieu Balançoire = new Lieu("Balançoire");
        Lieu ESTI = new Lieu("ESTI");
        Lieu Nexta = new Lieu("Nexta");
        Lieu Sekolintsika = new Lieu("Sekolintsika");
        Lieu Marais = new Lieu("Marais");
        Lieu Boulevard = new Lieu("Boulevard");

        Rue rue1 = new Rue("Andriatsihoarana", HEI, Pullman);
        Rue rue2 = new Rue("Ranaivo", Pullman, Balançoire);
        Rue rue3 = new Rue(null, Balançoire, ESTI);
        Rue rue4 = new Rue(null, Pullman, ESTI);
        Rue rue5 = new Rue(null,Pullman,Nexta);
        Rue rue6 =new Rue(null,HEI,Balançoire);
        Rue rue7 =new Rue(null,HEI,Sekolintsika);
        Rue rue8 = new Rue(null,Sekolintsika,Marais);
        Rue rue9 = new Rue(null,Balançoire,Boulevard);
        Rue rue10 = new Rue(null,Boulevard,ESTI);
        Carte carte = Carte.builder()
                .lieux(Arrays.asList(Marais,Sekolintsika,HEI, Pullman,Nexta, Balançoire,Boulevard, ESTI))
                .rues(Arrays.asList(rue1, rue2, rue3, rue4, rue5, rue6, rue7, rue8, rue9, rue10))
                .build();

        Marcheur bjarni = new Marcheur("Bjarni");
        Trajet trajet = new Trajet(carte,Marais);
        List<Lieu> chemin = trajet.marcheAleatoire(ESTI,bjarni);
        Assertions.assertEquals(Marais, chemin.get(0));

        Assertions.assertEquals(ESTI, chemin.get(chemin.size() - 1));

        for (int i = 0; i < chemin.size() - 1; i++) {
            Lieu current = chemin.get(i);
            Lieu next = chemin.get(i + 1);
            boolean connected = carte.getRues().stream()
                    .anyMatch(rue -> (rue.getStart().equals(current) && rue.getEnd().equals(next)) ||
                            (rue.getStart().equals(next) && rue.getEnd().equals(current)));
            Assertions.assertTrue(connected, "Lieu " + current.getName() + " n'est pas connecté à " + next.getName());
        }
    }
}
