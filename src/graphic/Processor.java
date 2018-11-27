package graphic;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sound.GameSound;

public class Processor extends JPanel{
	private final int padding = 15;;
	private Graphic mGraphic;
	private Game mContainer;
	private JLabel lbbackground;
	private JLabel JLPlayGame;
	private JLabel lbOption;
	private JLabel lbHigthScore;
	private JLabel JLExit;
	private ImageIcon backgroundIcon;
	
	public Processor(Game mContainer){
		this.mContainer = mContainer;
		this.mGraphic = mContainer.getGraphic();
		setBackground(Color.BLACK);
		setLayout(null);
		initComps(mGraphic);
		initbackground();
	}
	
	public void initComps(Graphic mGui){
		JLPlayGame = setLabel((mGui.getWidth()-150)/2-30, (mGui.getHeight()-30)/2-150, "/Images/Play.png");
		lbOption = setLabel(JLPlayGame.getX(),JLPlayGame.getY() + JLPlayGame.getHeight()+padding, "/Images/Option.png");
		lbHigthScore = setLabel(lbOption.getX(),lbOption.getY() + lbOption.getHeight()+padding, "/Images/HightScore.png");
		JLExit = setLabel(lbHigthScore.getX(),lbHigthScore.getY() + lbHigthScore.getHeight()+padding, "/Images/Exit.png");
		
		JLPlayGame.addMouseListener(mMouseAdapter);
		lbOption.addMouseListener(mMouseAdapter);
		lbHigthScore.addMouseListener(mMouseAdapter);
		JLExit.addMouseListener(mMouseAdapter);
		
		add(JLPlayGame);
		add(JLExit);
		
	}
	
	public void initbackground(){
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -10, mGraphic.getWidth(), mGraphic.getHeight());
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu.png"));
		lbbackground.setIcon(backgroundIcon);
		add(lbbackground);
	}
	
	public JLabel setLabel(int x, int y, String ImageIcon){
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}
	
	private MouseAdapter mMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource()==JLPlayGame){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play2.png"));
				JLPlayGame.setIcon(playIcon);
			}
			if(e.getSource()==JLExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit2.png"));
				JLExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource()==JLPlayGame){
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play.png"));
				JLPlayGame.setIcon(playIcon);
			}
			if(e.getSource()==JLExit){
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit.png"));
				JLExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource()==JLExit){
				GameSound.getIstance().getAudio(GameSound.MENU).stop();
				mGraphic.dispose();
				Play.IS_RUNNING=false;
			}
			if(e.getSource()==JLPlayGame){
				mContainer.setShowPlay();
			}
		}
	};
	
}	
