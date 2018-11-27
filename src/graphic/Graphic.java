package graphic;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import sound.GameSound;

public class Graphic extends JFrame{
	public static final int WIDTHJF = 840;
	public static final int HEIGHTJF = 610;
	private Game mContainer;

	public Graphic() {
		setSize(WIDTHJF, HEIGHTJF);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mContainer = new Game(this);
		add(mContainer);
		addWindowListener(mwindow);
	}

	private WindowAdapter mwindow = new WindowAdapter() 
        {
		@Override
		public void windowClosing(WindowEvent e)
                {
			GameSound.getIstance().stop();
			Play.IS_RUNNING = false;
		}
	};
}
