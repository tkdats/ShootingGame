import java.awt.Color;
import java.awt.Graphics;

public class BossBullet extends Bullet{
	
	private double vx;
	private double vy;
	
	BossBullet(double _x,double _y,double _vx,double _vy){
		vx=_vx;
		vy=_vy;
		x=_x;
		y=_y;
		width=5;
		height=5;
		r=5;
		isMikata=false;
	}
	@Override
    public boolean onUpdate(GameInfo gameinfo){
		//位置に速度を足す
    	x+=vx;
    	y+=vy;
    	//画面外で消滅
    	if(!Utility.onScreen(x,y)){
    		exist=false;
    	}
            return true;
    }
	@Override
    public void onDraw(Graphics g){ 
    	g.setColor(Color.GREEN);
	    g.drawOval((int)(x-r), (int)(y-r), (int)(2*r), (int)(2*r));	
    }
}
