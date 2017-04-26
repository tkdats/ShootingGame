import java.awt.Color;
import java.awt.Graphics;

public class SampleBullet1 extends Bullet{
	
	private double vx;
	private double vy;
	
	SampleBullet1(double _x,double _y,double _vx,double _vy){
		vx=_vx;
		vy=_vy;
		x=_x;
		y=_y;
		width=5;
		height=5;
		r=5;
		friendly=true;
	}
	@Override
    public boolean onUpdate(GameInfo gameinfo){
    	x+=vx;
    	y+=vy;
    	if(!Utility.onScreen(x,y)){
    		available=false;
    	}
            return true;
    }
	@Override
    public void onDraw(Graphics g){ 
    	g.setColor(Color.BLUE);
	    g.drawOval((int)(x-(r/2)), (int)(y-(r/2)), (int)r, (int)r);	
    }
}
