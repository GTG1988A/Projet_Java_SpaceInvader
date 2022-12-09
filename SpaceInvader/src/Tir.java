import javax.swing.ImageIcon;

public class Tir {
	protected ImageIcon image;
	protected int x;
	protected int y;
	
	

	public Tir(int x, int y) {
		this.image = new ImageIcon(getClass().getResource("ressources/tir.PNG"));// = new ImageIcon()
		this.x = x;
		this.y = y;
	}

	public void seDeplacer(Direction dir) {
		switch (dir) {
		case DROITE:
			if (x < SpaceInvader.LARGEUR) {
				x += 1;
			}
			break;
		case GAUCHE:
			if (x > 0) {
				x -= 1;
			}
			break;

		case BAS:
			if (y < SpaceInvader.HAUTEUR) {
				y += 1;
			}
			break;
		case HAUT:
			if (y > 0) {
				y -= 1;
			}
			break;
		}
	}


	public void Collision() {
		
	}
	
	public ImageIcon getImage() {
		return image;
	}



	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
