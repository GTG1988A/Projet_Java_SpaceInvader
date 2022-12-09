import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Vaisseau {
	private int cptBalles;
	private int cptVies;
	private int positionHorizontale;
	private ImageIcon image;
	Timer t;
	
	public Vaisseau() {
		this.image = new ImageIcon(getClass().getResource("ressources/blue.PNG"));
		this.cptBalles= 10; //TODO A définir
		this.cptVies= 3; //TODO A définir
		this.positionHorizontale= SpaceInvader.LARGEUR/2; //largeur/2
	}
	
	public void seDeplacer(Direction dir) {
		if(dir.equals(Direction.DROITE)) {
			//positionHorizontale = positionHorizontale == SpaceInvader.largeur ? positionHorizontale : positionHorizontale +1 ;
			if(positionHorizontale < SpaceInvader.LARGEUR-1) {
				positionHorizontale +=1;
			}
		}else if(dir.equals(Direction.GAUCHE)){
			if(positionHorizontale > 0) {
				positionHorizontale -=1;
			}
		}
	}
	
	public void tirer() {
		cptBalles -=1;
	}

	public int getPositionHorizontale() {
		return positionHorizontale;
	}

	public ImageIcon getImage() {
		return image;
	}
	
	
}
