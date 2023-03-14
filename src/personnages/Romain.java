package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	private String texte;

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

	public int getForce() {
        return force;
	
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		switch (force) {
			case 0:
				parler("Aïe");
				break;
			default:
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
				break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement!= 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					if (equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else {
						resistanceEquipement += 5;
					}
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	//	public void recevoirCoup(int forceCoup) {
//		// Vérification de la précondition
//		assert force > 0 : "La force doit être positive";
//
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//
//		// Vérification de la postcondition
//		assert force < forceCoup || force == 0 : "La force doit être diminuée";
//	}

	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				equipements[i] = null;
				nbEquipementEjecte++;
			}
		}
		nbEquipement = 0;
		return equipementEjecte;
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


	
	
	

