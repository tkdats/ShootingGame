import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SampleEnemy1 extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	SampleEnemy1(double  _x,double  _y, double  _vx,double  _vy){
		x=_x;
		y=_y;
		vx=_vx;
		vy=_vy;
		width=30;
		height=30;
		r=15;
		hitpoint=5;
	}
    public boolean onUpdate(GameInfo gameinfo){
    	x+=vx;
    	y+=vy;
    	if(gameinfo.frames % 30==0){
    		double t=rnd.nextDouble()*2*Math.PI;
    		gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,2*Math.cos(t),2*Math.sin(t)));
    	}
    	if(!Utility.onScreen(x,y)||hitpoint<0){
    		available=false;
    	}
        return true;
    }
    
    public void onDraw(Graphics g){
   	 	g.setColor(Color.RED);
   	 	g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
    }
}