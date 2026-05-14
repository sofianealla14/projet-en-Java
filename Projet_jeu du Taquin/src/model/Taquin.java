package model;

import model.observer.AbstractListenableModel;

/**
 * 
 * @author Jules, Lucas, Eliot, Sofiane, Antonin
 *
 */

public class Taquin extends AbstractListenableModel{
	
	private int[][] caseCoord = {{3,3},{2,2},{2,1},{1,2},{1,1},{1,3},{3,1},{2,3},{3,2}};
	private int[][] victoryCoord = {{3,3},{1,1},{2,1},{3,1},{1,2},{2,2},{3,2},{1,3},{2,3}};
	public boolean isWon = false;
	
	/**
	 * Constructeur du taquin. On appelle la fonction shuffle pour mélanger le tableau du taquin
	 */
	
	public Taquin() {
		shuffle();
	}
	
	/**
	 * 
	 * Renvoie le numéro associé à la position reçue en entrée
	 * 
	 * @param x La coordonnée x de la case
	 * @param y La coordonnée y de la case
	 * @return	le numéro associé à la position
	 */
	
	public int getCaseInt(int x, int y) {
		for(int i = 0; i < 9; i++) {
			if (caseCoord[i][0] == x && caseCoord[i][1] == y) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * Renvoie la coordonnée de la case en fonction du numéro reçu
	 * 
	 * @param n	Le numéro de la case
	 * @return	La coordonnée de la case
	 */
	
	public int[] getCaseCoord(int n) {
		return caseCoord[n];
	}
	
	public int[] getVictoryCoord(int n){
		return victoryCoord[n];
	}
	
	/**
	 * 
	 * Vérifie si les coordonnées de la case, associée au numéro reçu, sont bien 
	 * adjacentes à celles de la case vide. Renvoie un booléen
	 * 
	 * @param n Le numéro de la case
	 * @return Un booléan en fonction de la coordonnée de la case
	 */
	
	public boolean verifPos(int n) {
		
		int[] baseCoord = getCaseCoord(n);
		
		if(baseCoord[0] + 1 == caseCoord[0][0] && baseCoord[1] == caseCoord[0][1]) {
			return true;
		}
		else if(baseCoord[0] - 1 == caseCoord[0][0] && baseCoord[1] == caseCoord[0][1]) {
			return true;
		}
		else if(baseCoord[0] == caseCoord[0][0] && baseCoord[1] + 1 == caseCoord[0][1]) {
			return true;
		}
		else if(baseCoord[0] == caseCoord[0][0] && baseCoord[1] - 1 == caseCoord[0][1]) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Appelle verifPos pour savoir si la case est bien adjacente. Si oui alors on interverti la case vide
	 * et la case associé au numéro reçu.
	 * 
	 * @param n Le numéro de la case
	 */
	
	public void inverse(int n) {
		if(verifPos(n)) {
			int[] fill = caseCoord[n];
			caseCoord[n] = caseCoord[0];
			caseCoord[0] = fill;
			taquinChange();
			isWon = isWon();
		}
	}
	
	/**
	 * 
	 * Surcharge de la fonction inverse(int n) nous permettant de l'appeler avec une position à la place du numéro de la case.
	 * 
	 * @param x Position x de la case
	 * @param y Position y de la case
	 */
	
	public void inverse(int x, int y) {
		inverse(getCaseInt(x,y));
	}
	
	/**
	 * 
	 * Fonction permettant de mélanger le tableau caseCoord
	 * 
	 */
	
	public void shuffle() {
		for(int i = 0; i < 1000; i++) {
			int random = (int) Math.floor(Math.random() * 8 + 1);
			inverse(random);
		}
	}
	
	/**
	 * 
	 * Retourne true si caseCoord est équivalent à victoryCoord, sinon false
	 * 
	 * @return un boolean en fonction caseCoord et victoryCoord
	 */
	
	public boolean isWon() {
		for( int i = 0; i < 9; i++) {
			if(caseCoord[i][0] != victoryCoord[i][0] || caseCoord[i][1] != victoryCoord[i][1])
				return false;
		}
		return true;
	}
	
	
	
}
