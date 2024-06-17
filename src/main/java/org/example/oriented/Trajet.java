package org.example.oriented;

import java.util.*;
import java.util.stream.Collectors;

// Trajet.java
public class Trajet {
    private Carte carte;
    private Lieu start;

    public Trajet(Carte carte, Lieu start) {
        this.carte = carte;
        this.start = start;
    }

    public List<Lieu> marcheAleatoire(Lieu destination, Marcheur marcheur) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(start);
        if (trouverChemin(start, destination, chemin, new HashSet<>())) {
            return chemin;
        } else {
            return Collections.emptyList();  // Si aucun chemin n'est trouvé
        }
    }

    private boolean trouverChemin(Lieu current, Lieu destination, List<Lieu> chemin, Set<Lieu> visites) {
        if (current.equals(destination)) {
            return true;
        }

        visites.add(current);
        List<Rue> options = carte.getRues().stream()
                .filter(rue -> rue.getStart().equals(current) || rue.getEnd().equals(current))
                .collect(Collectors.toList());

        Collections.shuffle(options);  // Pour introduire un aspect aléatoire

        for (Rue rue : options) {
            Lieu next = rue.getStart().equals(current) ? rue.getEnd() : rue.getStart();
            if (!visites.contains(next)) {
                chemin.add(next);
                if (trouverChemin(next, destination, chemin, visites)) {
                    return true;
                }
                chemin.remove(chemin.size() - 1);  // Backtracking
            }
        }

        visites.remove(current);
        return false;
    }
}

