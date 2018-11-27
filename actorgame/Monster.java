package actorgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Monster extends Actor{
	private int heart; 
        public void drawBoss(Graphics2D g)
        {int f=0;
            Image imgHeartBoss = new ImageIcon(getClass().getResource("/Images/heart_boss.png")).getImage();
        for(int i=0;i<(heart-1)/250+1 ;i++)
                {
		g.drawImage(imgHeartBoss, x+18+f, y-52, null);
		f=f+10;
		}
		if(type==Actor.BOSS)
                {int c=38;
                int q=13;
                int o=54;
                int z=26;
                int p=12;
                g.setColor(Color.WHITE);
		g.drawImage(img, x, y-c, null);
		g.drawRect(x+q, y-o,width-z,p);
		}
        }
	public Monster(int a,int b,int t,int h,int s,int tym,String im)
        {this.type= t;
        this.orient=h;
	this.x= a;
	this.y= b;
	
	this.heart=tym;
	
        this.runBomb = Bomber.DISALLOW_RUN;
        this.speed = s;
	this.img = new ImageIcon(getClass().getResource(im)).getImage();
	width = img.getWidth(null);
        	if(type!=Actor.MONSTER)
        {
            height = img.getHeight(null)-38;
	
	}
        else
        {
        
            height = img.getHeight(null)-23;
	
	}
        }
        public void changeOrient(int orient)
        {
		super.changeOrient(orient);
		if(type!=Actor.MONSTER)
                {
                switch (orient) {
                case RIGHT:
	    img = new ImageIcon(getClass().getResource("/Images/boss_right.png")).getImage();
		break;
			case LEFT:
            img = new ImageIcon(getClass().getResource("/Images/boss_left.png")).getImage();
				break;
			case DOWN:
            img = new ImageIcon(getClass().getResource("/Images/boss_down.png")).getImage();
				break;
			case UP:
            img = new ImageIcon(getClass().getResource("/Images/boss_up.png")).getImage();
				break;
			default:
				break;
			}
		}
                else
                {
                switch (orient)
                        {
                        case DOWN:
		img = new ImageIcon(getClass().getResource("/Images/monster_down.png")).getImage();
				break;
			case LEFT:
		img = new ImageIcon(getClass().getResource("/Images/monster_left.png")).getImage();
				break;
                        case UP:
		img = new ImageIcon(getClass().getResource("/Images/monster_up.png")).getImage();
				break;       
			case RIGHT:
		img = new ImageIcon(getClass().getResource("/Images/monster_right.png")).getImage();
				break;
			default:
				break;
			}
			
		}
	}
	public void setHeart(int heart)
        {
	this.heart = heart;
	}
        public int getHeart() 
        {
	return heart;
	}
	
	
	
}
