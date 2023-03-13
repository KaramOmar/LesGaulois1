package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;

	
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		if (force < 0) {
			this.force = 0;
		} else {
			this.force = force;
		}
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		// Vérification de la précondition
		assert force > 0 : "La force doit être positive";

		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}

		// Vérification de la postcondition
		assert force < forceCoup || force == 0 : "La force doit être diminuée";
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[0] = equipement;
			nbEquipement++;
			parler("s'équipe avec un " + equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				parler("possède déjà un " + equipement + " !");
			} else {
				equipements[1] = equipement;
				nbEquipement++;
				parler("s'équipe avec un " + equipement);
			}
			break;
		case 2:
			parler("est déjà bien protégé !");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.getNom() + " a une force de " + minus.force);

		// Tester
		Equipement casque1 = Equipement.CASQUE;
		Equipement casque2 = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;

		minus.sEquiper(casque1);
		minus.sEquiper(casque2);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque1);
	}
}
