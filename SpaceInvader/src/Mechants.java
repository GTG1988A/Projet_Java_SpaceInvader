import javax.swing.ImageIcon;

public class Mechants extends OVNI {
	

	public Mechants(int nbVies, int x, int y) {
		super(nbVies, null, x, y);
		this.image =new ImageIcon(getClass().getResource("ressources/cyan.PNG"));
	}

	@Override
	public void mourir() {
		// TODO ajouter des points et disparaitre
	}

}
