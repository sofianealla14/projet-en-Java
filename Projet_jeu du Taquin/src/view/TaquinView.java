package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Taquin;
import model.observer.ModelListener;


/**
 * 
 * Cette classe est une Vue qui va permettre d'afficher notre Taquin dans l'interface graphique.
 * 
 * @author  Jules, Lucas, Eliot, Sofiane, Antonin
 *
 */
@SuppressWarnings("serial")
public class TaquinView extends JPanel implements ModelListener {

	public static int DIM = 200;
	private Taquin taquin;
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	private BufferedImage img;
	public boolean[] shining = {false,false,false,false,false,false,false,false,false}; 
	
	/**
	 * 
	 * Constructeur de la classe TaquinView.
	 * 
	 * @param taquin 
	 */
	public TaquinView(Taquin taquin) {
		this.taquin = taquin;
		this.taquin.addListener(this);
		setPreferredSize(new Dimension(DIM * 3, DIM * 3));
		try {
			img = ImageIO.read(getClass().getResource("/resources/img.jpg"));
		}catch(IOException e) {
			System.out.println(e);
		}
		decompImg();
	}
	/**
	 * Cette fonction paint notre Vue. Elle dessine les cases du taquin à leurs positions et affiche aussi leurs chiffres. En cas de victoire, 
	 * toutes les cases s'affichent et un message apparait.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g.setColor(Color.WHITE);
		if(!taquin.isWon) {
			for(int i = 1; i < 9; i++) {
				int[] pos = taquin.getCaseCoord(i);
				g.drawImage(images.get(i),DIM * (pos[0] - 1), DIM * (pos[1] - 1), DIM, DIM, null);
				if (shining[i]) {
					g.setColor(Color.RED);
					g.drawRect(DIM * (pos[0] - 1)+1, DIM * (pos[1] - 1)+1, DIM-2, DIM-2);
				}
				g.setColor(Color.WHITE);
				g.drawString(String.valueOf(i),95 + DIM * (pos[0] - 1),  110 + DIM * (pos[1] - 1));
			}
		}
		else {
			for(int i = 0; i < 9; i++) {
				int[] pos = taquin.getCaseCoord(i);
				g.drawImage(images.get(i), DIM * (pos[0] - 1), DIM * (pos[1] - 1), DIM, DIM, null);
			}
			g.setColor(Color.RED);
			g.drawString("YOU'VE WON",140,300);
		}		
	}
	/**
	 * 
	 * @param xImg 
	 * @param yImg
	 * @return le minimum de la division par 3, arrondi à l'inférieur, de la largeur et de la hauteur de l'image. 
	 */
	private int diviseur ( int xImg, int yImg) { 
		return (int)Math.min(Math.floorDiv(xImg,3),(Math.floorDiv(yImg,3))); 
	}
	
	 /**
	  * Cette fonction décompose notre image stockée dans la variable img de telle sorte à créer un tableau associant les morceaux
	  * d'images à leurs numéros. (exemple : le numéro 0, la case vide, est associé au tout dernier morceau de l'image).
	  */
	private void decompImg (){
		int cote = diviseur(img.getTileWidth(),img.getTileHeight());
		for(int i = 0; i< 9; i++) {
			int[] pos = taquin.getVictoryCoord(i);
			images.add(img.getSubimage(cote * (pos[0] - 1), cote * (pos[1] - 1),cote,cote));
		}
	}
	
	
	/**
	 * Cette fonction appelle repaint qui repeint notre Vue. Elle est à la base du modèle écouteur. 
	 */
	@Override
	public void modelUpdated(Object source) {
		// TODO Auto-generated method stub
		repaint();
	}

}
