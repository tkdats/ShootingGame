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
		isMikata=true;
	}
	@Override
    public boolean onUpdate(GameInfo gameinfo){
		//�ʒu�ɑ��x�𑫂�
    	x+=vx;
    	y+=vy;
    	//��ʊO�ŏ���
    	if(!Utility.onScreen(x,y)){
    		exist=false;
    	}
            return true;
    }
	@Override
    public void onDraw(Graphics g){ 
    	g.setColor(Color.BLUE);
	    g.drawOval((int)(x-(r/2)), (int)(y-(r/2)), (int)r, (int)r);	
    }
}
