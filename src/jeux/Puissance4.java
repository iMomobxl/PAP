package jeux;

import java.util.Scanner;

import tp03.matrice;

public class Puissance4 {
	private static Scanner scan = new Scanner(System.in);

	// une autre facon de declarer la matrice
	private static final int[][] ETAT_INIT_MATRICE =
		{
				{-1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1,  0,  0,  0,  0,  0,  0,  0, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1}
		};
	// codes des cases ==> static car idem pour tous les objets et fixe
	private static final int BORDURE = -1;
	private static final int VIDE = 0;
	private static final int JAUNE = 1;
	private static final int ROUGE = 2;
	private static final boolean TOUR_DES_JAUNES = true;
	private static final boolean TOUR_DES_ROUGES = false;
	private static final int NB_CASES = 42;
	
	private boolean tour; // tour = true -> joueur JAUNE, tour = false -> joueur ROUGE
	private int nbrPions;
	private boolean fin;
	private boolean gagne;
	
	private String joueurJaune;
	private String joueurRouge;
	private int lignePion;
	private int colonnePion;
	
	private int[][] jeu = new int[8][9];
	
	/**
	 * Constructeur
	 * @param joueur1 = nom du joueur 1
	 * @param joueur2 = nom du joueur 2
	 */
	public Puissance4(String joueur1, String joueur2) {
		this.joueurJaune = joueur1;
		this.joueurRouge = joueur2;
		initJeu();
		this.fin = false;
		this.gagne = false;
		this.nbrPions = 0;
		this.tour = Math.random() < 0.5 ? TOUR_DES_JAUNES : TOUR_DES_ROUGES;
	}
	

	private void start() {
		boolean ok;
		if (fin) {
			System.out.println("Cette partie est deja finie!");
		}
		while (!fin) {
			do {
				afficheJeu();
				int colonne = choisirColonne();
				ok = inserPionV2(pionJoueur(), colonne);
				if (!ok) {
					System.out.println("La colonne est remplie!!");
				}
			} while (!ok);
			nbrPions++;
			this.gagne = false; //test4ALaSuite();
			fin = gagne || (nbrPions == NB_CASES);
			if (!fin) {
				tour = !tour; // change de joueur si fin est false
			}
		}
		if (gagne) {
			System.out.println(joueurActuel() + " gagne");
		} else if (fin) {
			afficheJeu();
			System.out.println("Partie finie pas de gagnant.");
		}
	}
	
	/**
	 * retourne le nom du joueur
	 * @return
	 */
	private String joueurActuel() {
		return tour == TOUR_DES_JAUNES ? joueurJaune : joueurRouge;
	}

	/**
	 * test si le dernier coup est gagnant
	 * @return
	 */
	private boolean test4ALaSuite() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * retourne le code couleur du joueur qui joue
	 * @return
	 */
	private int pionJoueur() {
		return tour == TOUR_DES_JAUNES ? JAUNE : ROUGE;
	}

	/**
	 * choix d'une colonne (1...7)
	 * @return
	 */
	private int choisirColonne() {
		int colonne;
		boolean erreur;
		
		System.out.println(joueurActuel() + " joue, choisit la colonne");		
		System.out.println("Entrez une colonne entre 1 et 7: ");
		do {
			colonne = scan.nextInt();
			erreur = (colonne >= 1) && (colonne <= 7);
			if (!erreur) {
				System.out.println("ERREUR: Entrez un nombre entre 1 et 7");
			}
		} while (!erreur);
		return colonne;
	}


	/**
	 * Initialisation de la matrice jeu
	 */
	private void initJeu() {
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
	
	/**
	 * Deuxieme facon d'initialiser en utilisatn ETAT_INIT_MATRICE
	 */
	private void iniJeuV2() {
		jeu = ETAT_INIT_MATRICE.clone();
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
	public boolean inserPion(int couleur, int colonne) {
		this.colonnePion = colonne;
		boolean ok = true;
		boolean inserer = false;
		int i = 1;
		while (ok & !inserer) {
			if (jeu[i][colonne] != VIDE) {
				if (jeu[i-1][colonne] == VIDE) {
					jeu[i-1][colonne] = couleur;
					inserer = true;
					this.lignePion = i - 1;
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
	 * correction inserPionV2
	 * @param couleur
	 * @param colonne
	 * @return
	 */
	public boolean inserPionV2(int couleur, int colonne) {
		this.colonnePion = colonne;
		if (jeu[1][colonne] != VIDE) {
			return false;
		}
		int i = 2;
		while (jeu[i][colonne] == VIDE) {
			//System.out.println("jeu[" + i + "][colonne] " + jeu[i][colonne]);
			i++;
		}
		jeu[i - 1][colonne] = couleur;
		//System.out.println("jeu[" + i + "- 1][colonne] " + jeu[i-1][colonne]);
		this.lignePion = i - 1;
		return true;
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue a Puissance4");
		System.out.println("Nom du joueur 1?");
		String nomJoueur1 = scan.next();
		System.out.println("Nom du joueur 2?");
		String nomJoueur2 = scan.next();
		Puissance4 partie = new Puissance4(nomJoueur1, nomJoueur2);
		//Puissance4 partie = new Puissance4("nomJoueur1", "nomJoueur2");
		partie.start();
		scan.close();
		
		
		
		
		
		/*
		 * Puissance4 partie = new Puissance4("J1", "J2"); Scanner scan = new
		 * Scanner(System.in); String choix; do { partie.initJeu(); boolean jeuFini =
		 * false; int nbrJeu = 0; int joueur;
		 * 
		 * System.out.println("Bienvenue a Puissance4"); do { partie.afficheJeu();
		 * joueur = nbrJeu % 2; if (joueur == 0) { joueur = JAUNE; } else { joueur =
		 * ROUGE; } String joueur_color = matrice.getColor(joueur);
		 * System.out.printf("%sJoueur %d joue.\u001B[0m%n", joueur_color, joueur);
		 * System.out.println("Entré un numero de colonne (1 a 7)"); int colonne;
		 * boolean erreur; do { colonne = scan.nextInt(); erreur = (colonne < 1) ||
		 * (colonne > 7); if (erreur) {
		 * System.out.println("Entré un numero de colonne uniquement de 1 a 7"); } }
		 * while (erreur); if (partie.inserPion(joueur, colonne)) { nbrJeu++; jeuFini =
		 * partie.gagner(joueur, colonne); if (jeuFini) { partie.afficheJeu();
		 * System.out.println("Joueur " + joueur + " gagne! Felicitation."); } if
		 * (nbrJeu == 42 && !jeuFini) { // 42 limite de coup possible dans le puissance4
		 * jeuFini = true; partie.afficheJeu();
		 * System.out.println("Le puissance4 est complet, pas de gagnant."); } } else {
		 * System.out.println("Coup pas valide recommencé."); } } while (!jeuFini);
		 * System.out.println("Voulez-vous recommencer? (O/N)"); choix = scan.next(); }
		 * while ("o".equalsIgnoreCase(choix));
		 * System.out.println("Merci d'avoir joué, revenez quand vous voulez.");
		 * scan.close();
		 */
	}
}