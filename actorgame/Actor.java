package actorgame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import com.bhuy.bomb.gui.GUI;

public class Actor {
    	public static final int BOMBER = 1;
	public static final int MONSTER = 2;
        protected int orient;
        protected int width;
        protected int x,y,type,runBomb;
        protected int speed;
        protected  int height;
        protected Image img;
        public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int LEFT = 1;
	public static final int DOWN = 4;
	public static final int ALIVE= 1;
	public static final int DEAD = 0;
        public static final int BOSS = 3;
	public static final int BOMB = 4;
	
	
	public boolean move(int count, ArrayList<Bomb> arrBomb, ArrayList<Box> arrBox){
            int temp=0;
		if(count%speed!=temp)
                {
			return true;
		}
		switch (orient) 
                {
                    case DOWN:
			if(y>=(GUI.HEIGHTJF-25-height))
                        {//vuot qua
			return false;
			}
			y=y+1;
			for(int i=0;i<arrBomb.size();i++)
                        {
				if(arrBomb.get(i).isImpactBombvsActor(this)==1){
					y=y-1;
					return false;
				}
			}
			for(int i=0;i<arrBox.size();i++)
                        {
				int lm= arrBox.get(i).isImpactBoxvsActor(this);
				if(lm!=0)
                                {
					if(lm>=-20&&lm<=20)
                                        {
						if(lm<=0)
                                                {
							x=x-1;
						}
                                                else
                                                {
						x=x=1;
						}
					}
					y=y-1;
					return false;
				}
			}
			break;

	
		case RIGHT:
			if(x>(675-width))//di quá về bên phải
                        {
			return false;
			}
			x=x+1;
			for(int i=0;i<arrBomb.size();i++)
                        {
				if(arrBomb.get(i).isImpactBombvsActor(this)==temp+1)
                                {
				x=x-1;
				return false;
				}
			}
			for(int i=0;i<arrBox.size();i++)
                        {
				int lm = arrBox.get(i).isImpactBoxvsActor(this);
				if(lm!=temp)
                                {
					if(lm>=-20 && lm<=20)
                                        {
						if(lm<=0)
                                                {
							y=y-1;
						}
                                                else
                                                {
							y=y+1;
						}
					}
					x=x-1;
					return false;
				}
			}
			break;
		case UP:
			if(y<=0)//vuot qua
                        {
				return false;
			}
			y=y-1;
			for(int i=0;i<arrBomb.size();i++)
                        {
				if(arrBomb.get(i).isImpactBombvsActor(this)==temp+1)
                                {
				y=y+1;
				return false;
				}
			}
			for(int i=0;i<arrBox.size();i++)
                        {
				int lm = arrBox.get(i).isImpactBoxvsActor(this);
				if(lm!=0){
					if(lm>=-20 && lm<=20){
						if(lm<=0)
                                                {
							x=x-1;
						}
                                                else
                                                {
							x=x+1;
						}
					}
					y=y+1;
					return false;
				}
			}
			break;
                        	case LEFT:
			if(x<=temp)
                        
                        {
				return false;
			}
			x=x-1;
			for(int i=0;i<arrBomb.size();i++)
                        {
				if(arrBomb.get(i).isImpactBombvsActor(this)==temp+1)
                                {
					x=x+1;
					return false;
				}
			}
			for(int i=0;i<arrBox.size();i++){
				int lm = arrBox.get(i).isImpactBoxvsActor(this);
				if(lm!=0){
					if(lm>=-20&&lm<=20){
						if(lm<=0)
                                                {
							y=y-1;
						}
                                                else
                                                {
							y=y+1;
						}
					}
					x=x+1;
					return false;
				}
			}
			break;
		
		default:
		break;
		}
		return true;
	}
        public void drawActor(Graphics2D g)
        {
		switch (type)
                {
		case MONSTER:
			g.drawImage(img,x,y-23,null);
			break;
		case BOMB:
			g.drawImage(img,x,y,null);
			break;
                case BOMBER:
			g.drawImage(img,x,y-20,null);
			break;
                        default:
			break;
		}
	}
        public void setSpeed(int speed)
        {
		if(speed<3){
			return;
		}
		this.speed = speed;
	}

	public void changeOrient(int o)
        {
		this.orient = o;
	}

	public int getHeight()
        {
		return height;
	}


	public int getY()
        {
		return y;
	}

	public int getWidth()
        {
		return width;
	}
        public int getX()
        {
		return x;
	}

	
	public int getOrient() 
        {
		return orient;
	}

	public void setRunBomb(int runBomb)
        {
		this.runBomb = runBomb;
	}

	public int getRunBomb()
        {
		return runBomb;
	}
        public int getType() 
        {
		return type;
	}

	public int getSpeed()
        {
		return speed;
	}

	

	
	
	
}
