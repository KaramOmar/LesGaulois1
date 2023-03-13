package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
    public static void main(String[] args) {
        System.out.println("Le druide Panoramix : \"Bonjour, je suis le druide Panoramix et ma potion peut aller d'une force 5 à 10.\"");
        System.out.println("Le druide Panoramix : \"Je vais aller préparer une petite potion...\"");
        System.out.println("Le druide Panoramix : \"Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force 6.\"");
        System.out.println("Le druide Panoramix : \"Non, Obélix !... Tu n'auras pas de potion magique !\"");
        System.out.println("Le gaulois Obélix : \"Par Bélénos, ce n'est pas juste !\"");
        System.out.println("Le gaulois Astérix : \"Merci Druide, je sens que ma force est 6 fois décuplée.\"");
        System.out.println("Le gaulois Astérix : \"Bonjour\"");
        System.out.println("Le romain Minus : \"UN GAU... UN GAUGAU...\"");
        for (int i = 0; i < 3; i++) {
            System.out.println("Astérix envoie un grand coup dans la mâchoire de Minus");
            System.out.println("Le romain Minus : \"Aïe\"");
        }
        System.out.println("Le romain Minus : \"J'abandonne...\"");
    }
}
