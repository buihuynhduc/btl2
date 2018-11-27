package graphic;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import sound.GameSound;

public class Game extends JPanel{
	private static final String Jmenu = "tag_menu";
	private static final String Jplaygame = "tag_playgame";
	private final CardLayout mLayout;
	private final Graphic graphic;
	private final Processor mMenu;
	private final Play mPlayGame;
	
        public Graphic getGraphic() {
		return graphic;
	}
	public Game(Graphic mGraphic){
		this.graphic = mGraphic;
		setBackground(Color.WHITE);
		mLayout = new CardLayout();
		setLayout(mLayout);
		mMenu = new Processor(this);
		add(mMenu,Jmenu);
		mPlayGame = new Play(this);
		add(mPlayGame, Jplaygame);
		
		setShowMenu();

	}

	
	
	public void setShowPlay(){
		mLayout.show(Game.this, Jplaygame);
		mPlayGame.requestFocus();
		GameSound.getIstance().getAudio(GameSound.MENU).stop();
		GameSound.getIstance().getAudio(GameSound.PLAYGAME).loop();
	}
	public void setShowMenu(){
		mLayout.show(Game.this, Jmenu);
		mMenu.requestFocus();
		GameSound.getIstance().stop();
		GameSound.getIstance().getAudio(GameSound.MENU).loop();
	}

}
