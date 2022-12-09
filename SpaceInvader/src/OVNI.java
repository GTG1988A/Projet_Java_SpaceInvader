import javax.swing.ImageIcon;

public abstract class OVNI {
	protected int nbVies;
	protected ImageIcon image;
	protected int x;
	protected int y;

	public OVNI(int nbVies, ImageIcon image, int x,int y) {
		this.nbVies = nbVies;
		this.image = image;
		this.x = x;
		this.y = y;
	}

	public void seFaireToucher() {
		nbVies -= 1;
		if (nbVies == 0) {
			mourir();
		}
	}

	public abstract void mourir();

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
		default :
			break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ImageIcon getImage() {
		return image;
	}
	
	

}
