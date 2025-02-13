package jeux;

import tp03.matrice;

public class Puissance4 {
	
	
	private int[][] jeu = new int[8][9];
	
	// initialisation de la matrice jeu
	public void initJeu() {
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[i].length; j++) {
				if (i == 0 || i == 7 || j == 0 || j == 8) {
					jeu[i][j] = -1;
				} else {
					jeu[i][j] = 0;
				}
			}
		}
	}
	// affiche la matrice jeu
	public void afficheJeu() {
		matrice.afficheMat(jeu);
	}
	
	/**
	 * 
	 * @param couleur 1 = jaune, 2 = rouge
	 * @param colonne	{1, ..., 7}
	 * @return true si le coup est valable
	 */
	public boolean joue(int couleur, int colonne) {
		boolean ok = true;
		
		return ok; // si le jeu est valable
	}
	
	public static void main(String[] args) {
		
		Puissance4 partie = new Puissance4();
		partie.initJeu();
		partie.afficheJeu();
		
	}
}
