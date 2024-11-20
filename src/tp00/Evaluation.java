package tp00;

import java.util.Scanner;

public class Evaluation {

	/**
	 * Calcule la décision sur base de la note
	* @param note un entier entre 0 et 100
	* @return la décision
	*/
	public static String calculDecision(int note) {
		assert note >= 0 && note <= 100 : "La note doit être entre 0 et 100";
		String res;
		if (note < 30)
			res = "Refus";
		else if (note < 50)
			res = "Ajourné";
		else
			res = "Réussite";
		return res;
	}

	/**
	 * Lancement des exemples
	 * @param args
	 */
	public static void main(String[] args) {
		// ouverture d'un scanner sur l'entrée standard
		Scanner scan = new Scanner(System.in);
		int note;
		boolean erreur;
		String choix;
		do {
			// Input
			do {
				System.out.print("Entrez un nombre: ");
				note = scan.nextInt();
				erreur = (note < 0) || (note > 100);
				if (erreur)
					System.out.println("Entrez un nombre entre 0 et 100");
			} while (erreur);

			// Traitement
			String res = calculDecision(note);

			// Output
			System.out.println("Note: " + note + " Résultat: " + res);
			System.out.print("Voulez-vous continuer? (O/N)");
			choix = scan.next();
		} while ("o".equalsIgnoreCase(choix));
		System.out.println("FIN");
		// fermeture du scanner
		scan.close();
	}

}
