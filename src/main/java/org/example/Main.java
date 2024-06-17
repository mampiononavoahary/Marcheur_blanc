package org.example;

import org.example.oriented.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Lieu HEI = new Lieu("HEI");
        Lieu Pullman = new Lieu("Pullman");
        Lieu Balançoire = new Lieu("Balançoire");
        Lieu ESTI = new Lieu("ESTI");
        Lieu Nexta = new Lieu("Nexta");

        Rue rue1 = new Rue("Andriatsihoarana", HEI, Pullman);
        Rue rue2 = new Rue("Ranaivo", Pullman, Balançoire);
        Rue rue3 = new Rue(null, Balançoire, ESTI);
        Rue rue4 = new Rue(null, Pullman, ESTI);
        Rue rue5 = new Rue(null,Pullman,Nexta);
        Rue rue6 =new Rue(null,HEI,Balançoire);

        Carte carte = Carte.builder()
                .lieux(Arrays.asList(HEI, Pullman, Balançoire, ESTI))
                .rues(Arrays.asList(rue1, rue2, rue3, rue4, rue5, rue6))
                .build();

        Marcheur bjarni = new Marcheur("Bjarni");
        Trajet trajet = new Trajet(carte,HEI);
        List<Lieu> chemin = trajet.marcheAleatoire(ESTI,bjarni);

        System.out.println("Chemin suivi par Bjarni :");
        chemin.forEach(lieu -> System.out.println(lieu.getName()));
    }
}