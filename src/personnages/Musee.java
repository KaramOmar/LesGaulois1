package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees;

	public Musee() {
	     trophees = new Trophee[200];
	      nbTrophees = 0;
	    }

	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
	     Trophee trophee = new Trophee(gaulois, equipement);
	      trophees[nbTrophees] = trophee;
	       nbTrophees++;
	    }
	public String extraireInstructionsCaml() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("let musee = [\n");
	    for (int i = 0; i < nbTrophees; i++) {
	        Trophee troph = trophees[i];
	        sb.append("\"").append(troph.getGaulois().getNom()).append("\", \"").append(troph.getEquipement().getNom()).append("\";\n");
	    }
	    sb.append("]");
	    return sb.toString();
	}


	}

