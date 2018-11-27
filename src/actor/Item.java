package actorgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Item {
        private Image img;
        public static int Item_door=5;
	public static int Item_Bomb=1;
	public static int Item_BombSize=2;
        public static int Item_heart=4;
	public static int Item_Shoe=3;
        private int timeLine;
        private int x, y,type;
        private int width;
        private int height;
       
	public void drawItem(Graphics2D g2)
        {
	g2.drawImage(img,x,y,null);
	}
        
	public Item(int a, int b, int c, String d)
        {
		super();
                this.type = c;
		this.x = a;
		this.y = b;
                this.img = new ImageIcon(getClass().getResource(d)).getImage();
                timeLine=150;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
        public int getY()
        {
	return y;
	}
        public int getX() 
        {
	return x;
	}
        public int getWidth()
        {
	return width;
	}
        public int getType()
        {
	return type;
	}
        public int getHeight() 
        {
	return height;
	}
	public boolean isImpactItemVsBomber(Bomber bb)
        {
	Rectangle r2 = new Rectangle(bb.getX(), bb.getY(), bb.getWidth(), bb.getHeight());
        Rectangle r1 = new Rectangle(x, y, width, height);
	return r1.intersects(r2);
	}
	public void setTimeLine(int tl) 
        {
	this.timeLine = tl;
	}
        public int getTimeLine()
        {
	return timeLine;
	}

	

}
