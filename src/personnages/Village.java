package personnages;

public class Village {

private String nom;
private Chef chef;
private Gaulois[] villageois;
private int nbVillageois;
private int nbVillageoisMaximum;


public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois= new Gaulois[nbVillageoisMaximum];
		this.nbVillageois=0;
	}

public void setChef(Chef chef) {
	this.chef=chef;
	}


public String getNom(){
	return nom;

}

public void ajouterHabitant(Gaulois gaulois) {
	
	if(nbVillageois<villageois.length) {
		villageois[nbVillageois]=gaulois;
		nbVillageois++;
		}
}

public Gaulois trouverHabitant(int numerovillageois) {
	if(numerovillageois>=1 && numerovillageois<=nbVillageois) {
		return villageois[numerovillageois-1];
	}
	else {
		return null;
	}
}

public static void main(String[] args) {
    Village village = new Village("Village des Irréductibles", 30);
    
    Chef abraracourcix = new Chef("Abraracourcix", 6, village);
    village.setChef(abraracourcix);
    
    Gaulois asterix = new Gaulois("Astérix", 8);
    village.ajouterHabitant(asterix);
    
    Gaulois obelix = new Gaulois("Obélix", 25);
    village.ajouterHabitant(obelix);
    
    village.afficherVillageois();
  
}


public void afficherVillageois() {
    System.out.println("Chef : " + chef.getNom());
    System.out.println("Villageois : ");
    for (int i = 0; i < nbVillageois; i++) {
        System.out.println(villageois[i].getNom());
    }
}




}