package org.example.oriented;

import java.util.*;

public class Trajet {
    private Carte carte;
    private Lieu currentLocation;

    public Trajet(Carte carte, Lieu currentLocation) {
        this.carte = carte;
        this.currentLocation = currentLocation;
    }

    public List<Lieu> marcheAleatoire(Lieu destination, Marcheur marcheur) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(currentLocation);

        Random random = new Random();
        Set<Lieu> visites = new HashSet<>();
        visites.add(currentLocation);

        Lieu[] previousLocation = { null };

        while (!currentLocation.equals(destination)) {
            List<Rue> ruesPossibles = new ArrayList<>(carte.getRuesFromLieu(currentLocation));
            if (previousLocation[0] != null) {
                final Lieu prevLocation = previousLocation[0];
                ruesPossibles.removeIf(rue -> {
                    Lieu nextLieu = rue.getStart().equals(currentLocation) ? rue.getEnd() : rue.getStart();
                    return nextLieu.equals(prevLocation);
                });
            }

            if (ruesPossibles.isEmpty()) {
                break;
            }

            Rue rueChoisie = ruesPossibles.get(random.nextInt(ruesPossibles.size()));
            previousLocation[0] = currentLocation;
            currentLocation = rueChoisie.getStart().equals(currentLocation) ? rueChoisie.getEnd() : rueChoisie.getStart();
            chemin.add(currentLocation);
            visites.add(currentLocation);
        }

        return chemin;
    }
}
