package jeux;

import java.util.Scanner;

import tp03.matrice;

public class Puissance4 {
	// codes des cases ==> static car idem pour tous les objets et fixe
	private static final int BORDURE = -1;
	private static final int VIDE = 0;
	public static final int JAUNE = 1;
	public static final int ROUGE = 2;
	
	private int[][] jeu = new int[8][9];
	
	// initialisation de la matrice jeu
	public void initJeu() {
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[i].length; j++) {
				if (i == 0 || i == 7 || j == 0 || j == 8) {
					jeu[i][j] = BORDURE;
				} else {
					jeu[i][j] = VIDE;
				}
			}
		}
	}
	// affiche la matrice jeu
	public void afficheJeu() {
		System.out.println("-----------------------------------------------------");
		matrice.afficheMat2(jeu);
		System.out.println("-----------------------------------------------------");
	}
	
	/**
	 * 
	 * @param couleur 1 = jaune, 2 = rouge
	 * @param colonne	{1, ..., 7}
	 * @return true si le coup est valable
	 */
	public boolean joue(int couleur, int colonne) {
		boolean ok = true;
		boolean inserer = false;
		int i = 1;
		while (ok & !inserer) {
			if (jeu[i][colonne] != VIDE) {
				if (jeu[i-1][colonne] == VIDE) {
					jeu[i-1][colonne] = couleur;
					inserer = true;
				} else {
					ok = false;
				}
			} else {
				i++;
			}
		}
		return ok; // si le jeu est valable
	}
	
	/**
	 * 
	 * @param couleur
	 * @param posX = position X du dernier pion joué
	 * @param posY = position Y du dernier pion joué
	 * @param dirX = direction X
	 * @param dirY = direction Y
	 * @param pion = nombre de pion deja trouvé
	 * @return le nombre de pion du joueur sur la ligne/diagonal
	 */
	public int checkLigne(int couleur, int posX, int posY, int dirX, int dirY, int pion) {
		int nbrPion = pion;
		int i = posX + dirX;
		int j = posY + dirY;
		while (jeu[i][j] == couleur && nbrPion < 4) {
			i += dirX;
			j += dirY;
			nbrPion++;
		}
		return nbrPion;
	}
	
	public boolean gagner(int couleur, int colonne) {
		boolean gagner = false;
		int i = 1;
		// cherche la position du dernier pion joue
		while (jeu[i][colonne] == VIDE) {
			i++;
		}
		
		int posX = i;
		int posY = colonne;
		
		// check horizontal
		int nbrPion = checkLigne(couleur, posX, posY, 0, 1, 1); // check direction droite
		if (nbrPion < 4) {
			nbrPion = checkLigne(couleur, posX, posY, 0, -1, nbrPion); // check direction gauche
		}
		if (nbrPion == 4) {
			gagner = true;
		} else {
			// check vertical
			nbrPion = checkLigne(couleur, posX, posY, 1, 0, 1); // check direction bas
			if (nbrPion < 4) {
				nbrPion = checkLigne(couleur, posX, posY, -1, 0, nbrPion); // check direction haut
			}
			if (nbrPion == 4) {
				gagner = true;
			} else {
				// check 1ere diagonal
				nbrPion = checkLigne(couleur, posX, posY, 1, 1, 1); // check direction bas/droite
				if (nbrPion < 4) {
					nbrPion = checkLigne(couleur, posX, posY, -1, -1, nbrPion); // check direction haut/gauche
				}
				if (nbrPion == 4) {
					gagner = true;
				} else {
					// check 2eme diagonal
					nbrPion = checkLigne(couleur, posX, posY, -1, 1, 1); // check direction bas/gauche
					if (nbrPion < 4) {
						nbrPion = checkLigne(couleur, posX, posY, 1, -1, nbrPion); // check direction haut/droite
					}
					if (nbrPion == 4) {
						gagner = true;
					}
				}
			}
		}
		return gagner;
	}
	
	public static void main(String[] args) {
		
		Puissance4 partie = new Puissance4();
		Scanner scan = new Scanner(System.in);
		String choix;
		do {
			partie.initJeu();
			boolean jeuFini = false;
			int nbrJeu = 0;
			int joueur;
			
			System.out.println("Bienvenue a Puissance4");
			do {
				partie.afficheJeu();
				joueur = nbrJeu % 2;
				if (joueur == 0) {
					joueur = JAUNE;
				} else {
					joueur = ROUGE;
				}
				String joueur_color = matrice.getColor(joueur);
				System.out.printf("%sJoueur %d joue.\u001B[0m%n", joueur_color, joueur);
				System.out.println("Entré un numero de colonne (1 a 7)");
				int colonne;
				boolean erreur;
				do {
					colonne = scan.nextInt();
					erreur = (colonne < 1) || (colonne > 7);
					if (erreur) {
						System.out.println("Entré un numero de colonne uniquement de 1 a 7");
					}
				} while (erreur);
				if (partie.joue(joueur, colonne)) {
					nbrJeu++;
					jeuFini = partie.gagner(joueur, colonne);
					if (jeuFini) {
						partie.afficheJeu();
						System.out.println("Joueur " + joueur + " gagne! Felicitation.");
					} 
					if (nbrJeu == 42 && !jeuFini) { // 42 limite de coup possible dans le puissance4
						jeuFini = true;
						partie.afficheJeu();
						System.out.println("Le puissance4 est complet, pas de gagnant.");
					}
				} else {
					System.out.println("Coup pas valide recommencé.");
				}
			} while (!jeuFini);
			System.out.println("Voulez-vous recommencer? (O/N)");
			choix = scan.next();
		} while ("o".equalsIgnoreCase(choix));
		System.out.println("Merci d'avoir joué, revenez quand vous voulez.");
		scan.close();
	}
}