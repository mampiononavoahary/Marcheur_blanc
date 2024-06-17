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
        Lieu Sekolintsika = new Lieu("Sekolintsika");
        Lieu Marais = new Lieu("Marais");

        Rue rue1 = new Rue("Andriatsihoarana", HEI, Pullman);
        Rue rue2 = new Rue("Ranaivo", Pullman, Balançoire);
        Rue rue3 = new Rue(null, Balançoire, ESTI);
        Rue rue4 = new Rue(null, Pullman, ESTI);
        Rue rue5 = new Rue(null,Pullman,Nexta);
        Rue rue6 =new Rue(null,HEI,Balançoire);
        Rue rue7 =new Rue(null,HEI,Sekolintsika);
        Rue rue8 = new Rue(null,Sekolintsika,Marais);

        Carte carte = Carte.builder()
                .lieux(Arrays.asList(HEI, Pullman, Balançoire, ESTI))
                .rues(Arrays.asList(rue1, rue2, rue3, rue4, rue5, rue6, rue7, rue8))
                .build();

        Marcheur bjarni = new Marcheur("Bjarni");
        Trajet trajet = new Trajet(carte,Marais);
        List<Lieu> chemin = trajet.marcheAleatoire(ESTI,bjarni);

        System.out.println("Chemin suivi par Bjarni :");
        chemin.forEach(lieu -> System.out.println(lieu.getName()));
    }
}