import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class SpaceInvader extends JFrame {
	public static final int LARGEUR = 30;
	public static final int HAUTEUR = 20;
	public static int score = 0;
	
	public SpaceInvader() {
		// Modification du titre, taille et position de la fenêtre
		this.setTitle("SpaceInvader the game");
		this.setBounds(200, 100, 1024, 768);
		
		// Initialisation du layout de la fenêtre
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		GridLayout grid = new GridLayout(HAUTEUR,LARGEUR);
		
		JPanel gridPanel = new JPanel(grid);
		gridPanel.setBackground(Color.BLACK);
		gridPanel.setOpaque(true);
		//Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		
		
		JLabel [][] game = new JLabel[HAUTEUR][LARGEUR];
		
		for(int i=0; i<HAUTEUR; i++){
            for(int j=0; j<LARGEUR; j++){
            	game[i][j] = new JLabel();
            	//game[i][j].setBorder(blackline);
            	gridPanel.add(game[i][j]);
            }
        }
		
		mainPanel.add(gridPanel,BorderLayout.CENTER);
		this.add(mainPanel);
		this.addKeyListener(new Grille(game));
	}

	public static void main(String[] args) {
		SpaceInvader jeu = new SpaceInvader();
		jeu.setVisible(true);
	}

}
