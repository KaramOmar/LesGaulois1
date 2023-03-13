package personnages;

import java.util.Random;

public class Druide {
    private String nom;
    private int force;
    private int maxForcePotion;

    public Druide(String nom, int force, int maxForcePotion) {
        this.nom = nom;
        this.force = force;
        this.maxForcePotion = maxForcePotion;
        parler("Je suis le druide " + nom + " et j'ai une force de " + force + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + "»");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    public int getForcePotion() {
        Random rand = new Random();
        return rand.nextInt(maxForcePotion) + 1;
    }

    public void preparerPotion() {
        int forcePotion = getForcePotion();
        parler("Je prépare une potion de force " + forcePotion + ".");
    }

    public void booster(Gaulois gaulois) {
        if (gaulois.getNom().equals("Obelix")) {
            parler("Non, Obélix !... Tu n’auras pas de potion magique !");
            return;
        }
        int forcePotion = getForcePotion();
        gaulois.boirePotion(forcePotion);
        parler("Je donne une potion de force " + forcePotion + " au gaulois " + gaulois.getNom() + ".");
    }
}
