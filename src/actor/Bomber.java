package actorgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import com.bhuy.bomb.gui.GUI;


public class Bomber extends Actor{
	public static int ALLOW_RUN=0;
	public static int DISALLOW_RUN=1;
	protected int sizeBomb;
        protected int quantityBomb;
        protected int score;
        
               protected int status;
               protected  int heart;
	
	
	
	public Bomber(int a,int b,int c, int d, int s, int sz, int qu) {
		this.x = a;
		this.y = b;
		this.type = c;
		this.runBomb=DISALLOW_RUN;
		this.orient = d;
		this.speed = s;
		this.sizeBomb = sz;
		this.quantityBomb = qu;
		this.heart = 2;
		this.score=0;
		this.status = Actor.ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bomber_right.png")).getImage();
		width = img.getWidth(null);
		height = img.getHeight(null)-20;
	}

	public void setNew(int a,int b)
        {
		this.x = a;
		this.y = b;
		this.status = ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/bomber_right.png")).getImage();
	}
        public void setScore(int score) 
        {
		this.score = score;
	}

	public int getScore()
        {
		return score;
	}

	
	public void setImg(Image im) {
		this.img = im;
	}
	
	public int getStatus()
        {
		return status;
	}

	public void setStatus(int st)
        {
		this.status = st;
	}

	public int getQuantityBomb() {
		return quantityBomb;
	}

	public void setQuantityBomb(int quantityBomb) 
        {
		if(quantityBomb>5)
                {
			return;
		}
		this.quantityBomb = quantityBomb;
	}


	public void setSizeBomb(int sizeBomb)
        {
		if(sizeBomb>3)
                {
			return;
		}
		this.sizeBomb = sizeBomb;
	}

	public int getSizeBomb()
        {
		return sizeBomb;
	}

	public int getType()
        {
		return type;
	}
	
	public int getHeart()
        {
		return heart;
	}

	public void setHeart(int tym) {
		this.heart = tym;
	}

	@Override
	public boolean move(int c, ArrayList<Bomb> ab, ArrayList<Box> ax)
        {
		if(status==DEAD)
                {
			return false;
		}
		return super.move(c, ab, ax);
	}
        public boolean isImpactBomberVsActor(Actor ac)
        {
		if(status==DEAD)
                {
			return false;
		}
		Rectangle r1 = new Rectangle(x,y,width,height);
		Rectangle r2 = new Rectangle(ac.getX(),ac.getY(),ac.getWidth(),ac.getHeight());
		return r1.intersects(r2);
	}
	
	@Override
	public void changeOrient(int o)
        {
		if(this.status==DEAD){
			return;
		}
		super.changeOrient(o);
		switch (o) {
		
		case RIGHT:
			img = new ImageIcon(getClass().getResource("/Images/bomber_right.png")).getImage();
			break;
		
		case DOWN:
			img = new ImageIcon(getClass().getResource("/Images/bomber_down.png")).getImage();
			break;
                case LEFT:
			img = new ImageIcon(getClass().getResource("/Images/bomber_left.png")).getImage();
			break;
                case UP:
			img = new ImageIcon(getClass().getResource("/Images/bomber_up.png")).getImage();
			break;
		default:
			break;
		}
	}

	
	
}
