package actorgame;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Bomb extends Actor{
protected int size, timeline;
public Bomb(int x,int y,int orient,int speed,int size,int timeline)
{int temp=45;
		x=(x/temp)*temp;
		y=(y/temp)*temp;
		this.x=x;
		this.y=y;
		this.orient = orient;
		this.speed = 0;
		this.size=size;
		this.timeline = timeline;
		this.type =Actor.BOMB;
		img= new ImageIcon(getClass().getResource("/Images/bomb.png")).getImage();
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
}
public Bomb(int x,int y,int size,int timeline)
{              int temp=45;
    x=(x/temp)*temp;//làm tròn
		y=(y/temp)*temp;//làm tròn
		this.x=x;
		this.y=y;
		this.timeline = timeline;
                this.size=size;
		this.orient=0;
		this.type =Actor.BOMB;
		img= new ImageIcon(getClass().getResource("/Images/bomb.png")).getImage();
		this.width= img.getWidth(null);
		this.height= img.getHeight(null);
}
public int isImpactBombvsActor(Actor actor)
{int a=0;
int  b=1;
int c=2;
		if(actor.getRunBomb()==Bomber.ALLOW_RUN)
                {
		return a;
		}
		Rectangle rechai= new Rectangle(x, y, 45, 45);
		Rectangle recba = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
		if(rechai.intersects(recba))
                {
                if(actor.getType()==Bomber.BOSS)
                {
		return c;
		}
		return b;
		};
		return a;
}
	
	public void deadlineBomb()
        {
	this.timeline--;
        }
        	public void setTimeline(int timeline)
        {
		this.timeline = timeline;
	}
                public boolean isImpact(int xNewBomb, int yNewBomb)
        {
		Rectangle rec1 = new Rectangle(x, y, 45, 45);
		Rectangle rec2 = new Rectangle(xNewBomb, yNewBomb, 45, 45);
		return rec1.intersects(rec2);
	}
        public int getSize()
        {
		return size;
	}
        public boolean setRun(Bomber bomber)
        {
		Rectangle rec2 = new Rectangle(x, y, 45, 45);
		Rectangle rec3 = new Rectangle(bomber.getX(), bomber.getY(), bomber.getWidth(), bomber.getHeight());
		return rec2.intersects(rec3);
	}
	public int getTimeline()
        {
	return timeline;
	}

	
	
	
	



	
	
	
	
}
