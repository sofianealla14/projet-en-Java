package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Taquin;

/**
 * 
 * Classe permettant de créer l'interface graphique.
 * 
 * @author Jules, Lucas, Eliot, Sofiane, Antonin
 * 
 */

@SuppressWarnings("serial")
public class TaquinGUI extends JFrame implements MouseListener {

	private Taquin taquin;
	
	/**
	 * 
	 * Constructeur de la classe TaquinGUI. A l'instanciation, création et ajout d'une vue TaquinView.
	 * Ajout des events Listeners pour les cliques et les touches du clavier puis finit par afficher l'interface graphique et
	 * lancer le jeu en console. 
	 * 
	 * @param taquin Récupération du modèle taquin.
	 */
	
	public TaquinGUI(Taquin taquin) {
		this.taquin = taquin;
		TaquinView view = new TaquinView(taquin);
		setTitle("Taquin");
		add(view);
		
		view.addMouseListener(this);
		view.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				int posX = e.getX();
				int posY = e.getY();
				int[] pos = getPos(posX,posY);
				int n = taquin.getCaseInt(pos[0], pos[1]);
				for(int i = 0; i < 9; i++) {
					if (i == n && taquin.verifPos(n))
						view.shining[i] = true;
					else
						view.shining[i] = false;
				}
				view.repaint();
			}
			
		});
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				for(int i = 0; i < 9 ; i++) {
					view.shining[i] = false;
				}
				if(!taquin.isWon) {
					int keyCode = e.getKeyCode();
					int[] pos = taquin.getCaseCoord(0);
				    switch( keyCode ) { 
				        case KeyEvent.VK_UP:
				            taquin.inverse(pos[0], pos[1] + 1);
				            break;
				        case KeyEvent.VK_DOWN:
				            taquin.inverse(pos[0], pos[1] - 1);
				            break;
				        case KeyEvent.VK_LEFT:
				            taquin.inverse(pos[0] + 1, pos[1]);
				            break;
				        case KeyEvent.VK_RIGHT :
				            taquin.inverse(pos[0] - 1, pos[1]);
				            break;
				     }
				    displayConsole();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		displayConsole();
		consolePlay();
	}
	
	/**
	 * Cette fonction affiche le taquin dans la console.
	 */
	private void displayConsole() {
		System.out.println("");
		for(int i = 1; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				int n = taquin.getCaseInt(j,i);
				if (n != 0)
					System.out.print(n);
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Cette fonction permet au joueur de jouer dans la console.
	 */
	private void consolePlay() {
		if(!taquin.isWon) {
			System.out.println("Veuillez entre le numéro de la case que vous voulez déplacer : ");
			Scanner in = new Scanner(System.in);
			int n = 0;
			try{
				 n = in.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Ce n'est pas un chiffre");
			}
			taquin.inverse(n);
			displayConsole();
			consolePlay();
		}
	}
	
	/**
	 * 
	 * Renvoie un tableau de deux entiers. Le premiers entier étant une position x par rapport à notre posX
	 * et le y par rapport à notre posY.
	 * 
	 * @param posX 
	 * @param posY
	 * @return un tableau de deux entiers.
	 */
	public int[] getPos(int posX, int posY) {
		int x,y;
		if(posX < 200)
			x = 1;
		else if(posX < 400)
			x = 2;
		else 
			x = 3;
		if(posY < 200) 
			y = 1;
		else if(posY < 400)
			y = 2;
		else
			y = 3;
		int[] pos = {x,y};
		return pos;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 *Cette fonction récupère la position en x et en y puis joue le coup en fonction de la position.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(!taquin.isWon) {
			int posX = e.getX();
			int posY = e.getY();
			int[] pos = getPos(posX,posY);
			taquin.inverse(pos[0],pos[1]);
			displayConsole();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
