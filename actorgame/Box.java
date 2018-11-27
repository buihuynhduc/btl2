package actorgame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Box {
    public static int DISALLROW_BANG = 1;
	public static int ALLROW_BANG = 0;
        private int width,height;
        private int type;
	private int x,y;
        private Image img;
	public Box(int a,int b,int type,String image)
        {
		super();
                this.type = type;
		this.img = new ImageIcon(getClass().getResource(image)).getImage();
                this.x = a;
		this.y = b;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public void drawBox(Graphics2D gd)
        {
		gd.drawImage(img,x,y,null);
		
	}
	
	public int getType()
        {
		return type;
	}
	
	
	public int isImpactBoxvsActor(Actor ac)
        {       Rectangle r1 = new Rectangle(x, y, width, height);
		Rectangle r2 = new Rectangle(ac.getX(), ac.getY(), ac.getWidth(), ac.getHeight());
		Rectangle r3 = new Rectangle();
		if(ac.getType()==Actor.BOSS)
                {
			return 0;
		}
		
		if(r1.intersects(r2))
                {
			r1.intersect(r1, r2, r3);
			if(r3.getHeight()!=1 && (ac.getOrient()==Actor.UP || ac.getOrient()==Actor.DOWN))
                        {if(ac.getY()==r3.getY())
                                {
				return (int)r3.getHeight();
				}
                                else
                                {
				return (int)-r3.getHeight();
				}
				
			}
                        else
                        {
				
                            if(ac.getX()==r3.getX())
                                {
				return (int)r3.getWidth();
				}
                                else
                                {
				return (int)-r3.getWidth();
				}
			}
		}
		return 0;
	}
        public int getWidth()
        {
	return width;
	}
        public int getHeight()
        {
	return height;
	}
        public int getY()
        {
	return y;
	}
        public int getX()
        {
	return x;
	}


	

}
