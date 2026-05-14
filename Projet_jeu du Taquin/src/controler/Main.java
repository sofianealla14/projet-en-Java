package controler;

import model.Taquin;
import view.TaquinGUI;

/**
 * 
 * Classe Main permettant le lancement du Jeu.
 * 
 * @author Jules, Lucas, Eliot, Sofiane, Antonin
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Taquin taquin = new Taquin();
		new TaquinGUI(taquin);
		
	}
	
}
