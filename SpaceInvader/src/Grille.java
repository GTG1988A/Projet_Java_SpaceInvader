import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JLabel;

public class Grille implements KeyListener{
	private Vaisseau vaisseau;
	private List<OVNI> ovnis;
	private List<Tir> tirs;
	private JLabel [][] grillePanels;
	Timer t;
	public Grille(JLabel [][] grillePanels) {
		super();
		this.vaisseau = new Vaisseau();
		this.ovnis = new ArrayList<>();
		this.tirs = new ArrayList<>();
		this.grillePanels = grillePanels;
		creerVagueMechants(1);
		update();
		 t = new Timer(150, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i=0; i<tirs.size();i++) {
					tirs.get(i).seDeplacer(Direction.HAUT);
					}
					 update();
				}
	        });
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_LEFT:
                vaisseau.seDeplacer(Direction.GAUCHE);
                break;
            case KeyEvent.VK_RIGHT:
            	vaisseau.seDeplacer(Direction.DROITE);
                break;
            case KeyEvent.VK_SPACE:
            	tirer();
                break;
        }
        update();
		
	}
	
	private List<Mechants> creerLigneMechants(int difficulte, int hauteur) {
		List<Mechants> ovnisAAjouter = new ArrayList<>();
		switch (difficulte) {
		case 1: //nullosTier
			for(int i = 0; i< SpaceInvader.LARGEUR -4;++i) {
				ovnisAAjouter.add(new Mechants(1, i, hauteur));
			}
			break;
		case 2:
			for(int i = 0; i< SpaceInvader.LARGEUR -4;++i) {
				ovnisAAjouter.add(new Mechants(2, i, hauteur));
			}
			break;
		default:
			break;
		}
		return ovnisAAjouter;
	}
	
	private void creerVagueMechants(int difficulte) {
		switch (difficulte) {
		case 1: //nullosTier
			for(int i = 0; i< 3;++i) {
				this.ovnis.addAll(creerLigneMechants(1,i));
			}
			break;
		case 2:
			for(int i = 0; i< 5;++i) {
				this.ovnis.addAll(creerLigneMechants(2,i));
			}
			break;
		default:
			break;
		}
	}

	private void tirer() {
		tirs.add(new Tir( vaisseau.getPositionHorizontale(),SpaceInvader.HAUTEUR-2));
        t.start();
//			if (cptBalles!=0) {
//	        vaisseau.tirer();
//			}
		}

	private void update() {
		//vide la grille
		for(int i=0; i<SpaceInvader.HAUTEUR; i++){
            for(int j=0; j<SpaceInvader.LARGEUR; j++){
            	grillePanels[i][j].setIcon(null);
            }
        }
		
		//on redessine les elements
		grillePanels[SpaceInvader.HAUTEUR-1][vaisseau.getPositionHorizontale()].setIcon(vaisseau.getImage());
		for(OVNI o : ovnis){
			grillePanels[o.getY()][o.getX()].setIcon(o.getImage());
		}
		for(Tir t : tirs){
			grillePanels[t.getY()][t.getX()].setIcon(t.getImage());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
