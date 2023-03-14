package personnages;
import java.util.Random;

public class Gaulois {
    private String nom;
    private int force;
    private int nbTrophees;
    private Equipement[] trophees = new Equipement[100];
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

   
    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
       
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
            this.trophees[nbTrophees] = trophees[i];
        }
       
    }
    

    
    
    
    
     public void recevoirCoup(int forceCoup) {
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
        }
    }
   
     public void faireUneDonation(Musee musee) {
    	    if (nbTrophees > 0) {
    	        System.out.print("Le gaulois " + nom + " : \"Je donne au musée tous mes trophees :");
    	        for (int i = 0; i < nbTrophees; i++) {
    	            musee.donnerTrophee(this, trophees[i]);
    	            System.out.print("\n- " + trophees[i].getNom());
    	            trophees[i] = null;
    	        }
    	        nbTrophees = 0;
    	        System.out.println("\"");
    	    } else {
    	        parler("Je n'ai aucun trophee a donner.");
    	    }
    	}

     
	/*public void frapper(Gaulois autre) {
        parler("Je frappe le gaulois " + autre.getNom() + ".");
        int forceCoup = force / 3 * effetPotion;
        autre.recevoirCoup(forceCoup);
    }*/

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
