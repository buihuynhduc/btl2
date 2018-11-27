package actorgame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class BombBang {
    private int size;
private int x,y;
private int timeLine;
private Image img_left;
private Image img_down;
private Image img_up;
private Image img_right;

public BombBang(int a,int b,int c, ArrayList<Box> box)
{               this.x=a;
		img_right = new ImageIcon(getClass().getResource("/Images/bombbang_right_1.png")).getImage();
		img_left = new ImageIcon(getClass().getResource("/Images/bombbang_left_1.png")).getImage();
		img_down = new ImageIcon(getClass().getResource("/Images/bombbang_down_1.png")).getImage();
		img_up = new ImageIcon(getClass().getResource("/Images/bombbang_up_1.png")).getImage();
                this.size=c;
                this.y=b;
		this.timeLine =150;
                for(int i=1;i<size;i++)
                {
			int left=0,right=0,up=0 ,dow=0 ;
			for(int j=0;j<box.size();j++){
                            if(isImpactBox(x,y-(i*45),45,(i+1)*45,box.get(j)))
                                {
				up=1;
				}
				
                            if(isImpactBox(x,y,(i+1)*45,45,box.get(j)))
                                {
				right=1;
				}
                            if(isImpactBox(x,y,45,(i+1)*45,box.get(j)))
                                {
				dow=1;
				}
                                if(isImpactBox(x-(i)*45,y,(i+1)*45,45,box.get(j)))
                                { 
				left=1;
				}
				
			}
			if(left==0)
                        {
			setImage(Bomber.LEFT,i+1);
			}
                        if(dow==0)
                        {
			setImage(Bomber.DOWN,i+1);
			}
                        if(up==0)
                        {
			setImage(Bomber.UP,i+1);
			}
			if(right==0)
                        {
			setImage(Bomber.RIGHT,i+1);
			}
			
			
		}
		
	}
	
	public void drawBongBang(Graphics2D g)
        {
		g.drawImage(img_left, x+45-img_left.getWidth(null), y,null);
		g.drawImage(img_right, x, y,null);
		g.drawImage(img_up, x, y+45-img_up.getHeight(null),null);
		g.drawImage(img_down, x, y,null);
	}
	
	
	
	public boolean isImpactBombBangVsActor(Actor ac)
        {
                Rectangle r3 = new Rectangle(x+5, y+45-img_up.getHeight(null)+5, img_up.getWidth(null)-5, img_up.getHeight(null)-10);
		Rectangle r4 = new Rectangle(x+5, y, img_down.getWidth(null)-10, img_down.getHeight(null)-5);
		Rectangle r1 = new Rectangle(x+45-img_left.getWidth(null)+5, y+5, img_left.getWidth(null)-5, img_left.getHeight(null)-10);
		Rectangle r2 = new Rectangle(x, y+5, img_right.getWidth(null)-5, img_right.getHeight(null)-10);
                Rectangle r5 = new Rectangle(ac.getX(),ac.getY(),ac.getWidth(),ac.getHeight());
		if(r1.intersects(r5) || r2.intersects(r5) || r3.intersects(r5) || r4.intersects(r5))
                {
		return true;
		}
		return false;
	}
        private boolean isImpactBox(int a,int b,int w, int h, Box box)
        {
            Rectangle r2 = new Rectangle(box.getX(), box.getY(), box.getWidth(), box.getHeight());
		Rectangle r1 = new Rectangle(a, b,w,h);
		
		return r1.intersects(r2);
	}
	
	public boolean isImpactBombBangvsBomb(Bomb b)
        {
                Rectangle r3 = new Rectangle(x, y+45-img_up.getHeight(null), img_up.getWidth(null), img_up.getHeight(null));
		Rectangle r4 = new Rectangle(x, y, img_down.getWidth(null), img_down.getHeight(null));
		Rectangle r1 = new Rectangle(x+45-img_left.getWidth(null), y, img_left.getWidth(null), img_left.getHeight(null));
		Rectangle r2 = new Rectangle(x, y, img_right.getWidth(null), img_right.getHeight(null));
                Rectangle r5 = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		if(r1.intersects(r5) || r2.intersects(r5) || r3.intersects(r5) || r4.intersects(r5))
                {
		return true;
		}
		return false;
	}
        public boolean isImpactBombBangvsItem(Item it)
        {
		Rectangle r1 = new Rectangle(x+45-img_left.getWidth(null), y, img_left.getWidth(null), img_left.getHeight(null));
		Rectangle r2 = new Rectangle(x, y, img_right.getWidth(null), img_right.getHeight(null));
		Rectangle r3 = new Rectangle(x, y+45-img_up.getHeight(null), img_up.getWidth(null), img_up.getHeight(null));
		Rectangle r4 = new Rectangle(x, y, img_down.getWidth(null), img_down.getHeight(null));
		Rectangle r5 = new Rectangle(it.getX(), it.getY(), it.getWidth(), it.getHeight());
		if(r1.intersects(r5) || r2.intersects(r5) || r3.intersects(r5) || r4.intersects(r5))
                {
			if(it.getTimeLine()>0)
                        {
			it.setTimeLine(it.getTimeLine()-1);
			return false;
			}
                        else
                        {
		return true;
			}
		}
		return false;
	}
	
	public boolean isImpactBombBangvsBox(Box b)
        {
		if(b.getType()==Box.DISALLROW_BANG)
                {
		return false;
		}
                Rectangle r3 = new Rectangle(x, y+45-img_up.getHeight(null), img_up.getWidth(null), img_up.getHeight(null));
		Rectangle r4 = new Rectangle(x, y, img_down.getWidth(null), img_down.getHeight(null));
		Rectangle r1 = new Rectangle(x+45-img_left.getWidth(null), y, img_left.getWidth(null), img_left.getHeight(null));
		Rectangle r2 = new Rectangle(x, y, img_right.getWidth(null), img_right.getHeight(null));
		Rectangle r5 = new Rectangle(b.getX(),b.getY(),b.getWidth(),b.getHeight());
		if(r1.intersects(r5) || r2.intersects(r5) || r3.intersects(r5) || r4.intersects(r5))
                {
		return true;
		}
		return false;
	}
	
	
	
	public void setImage(int o,int sz)
        {
		switch (o)
                {
                    case Bomber.RIGHT:
			if(sz==2)
                        {
				img_right = new ImageIcon(getClass().getResource("/Images/bombbang_right_2.png")).getImage();
			}
			break;
		case Bomber.LEFT:
			if(sz==2)
                        {
				img_left = new ImageIcon(getClass().getResource("/Images/bombbang_left_2.png")).getImage();
			}
			break;
		case Bomber.DOWN:
			if(sz==2)
                        {
				img_down = new ImageIcon(getClass().getResource("/Images/bombbang_down_2.png")).getImage();
			}
			break;
                        case Bomber.UP:
			if(sz==2)
                        {
				img_up = new ImageIcon(getClass().getResource("/Images/bombbang_up_2.png")).getImage();
			}
			break;

		default:
			break;
		}
	}
        public int getTimeLine()
        {
		return timeLine;
	}
	
	
	public void deadlineBomb()
        {
		if(timeLine>0){
			timeLine--;
		}
	}

	
	
}
