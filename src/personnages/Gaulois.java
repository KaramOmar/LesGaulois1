package personnages;

import java.util.Random;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.effetPotion = 1;
        parler("Je suis le gaulois " + nom + " et j'ai une force de " + force + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
        }
    }

    public void frapper(Gaulois autre) {
        parler("Je frappe le gaulois " + autre.getNom() + ".");
        int forceCoup = force / 3 * effetPotion;
        autre.recevoirCoup(forceCoup);
    }

    public void boirePotion(int forcePotion) {
        if (this.nom.equals("Obélix")) {
            parler("Non, Obélix !... Tu n'auras pas de potion magique !");
        } else {
            effetPotion = forcePotion;
            if (forcePotion == 3) {
                parler("Merci Druide, je sens que ma force est 3 fois décuplée.");
            }
        }
    
    }
}
	
    
    