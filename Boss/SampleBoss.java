import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//Boss
public class SampleBoss extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	//������
	SampleBoss(double  _x,double  _y, double  _vx,double  _vy){
		x=_x;
		y=_y;
		vx=_vx;
		vy=_vy;
		width=50;
		height=50;
		r=25;
		hitpoint=100;
	}
    public boolean onUpdate(GameInfo gameinfo){
    	//�ʒu�ɑ��x�𑫂�
    	x+=vx;
    	y+=vy;
    	
    	//30�t���[����1��e�𔭎˂���
    	if(gameinfo.frames % 10==0){
    		double t=rnd.nextDouble()*2*Math.PI;
    		gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,2*Math.cos(t),2*Math.sin(t)));
    	}
    	
    	//��ʊO�܂���HP<0�ŏ���
    	if(!Utility.onScreen(x,y)||hitpoint<0){
    		exist=false;
    	}
        return true;
    }
    
    public void onDraw(Graphics g){
   	 	g.setColor(Color.GREEN);
   	 	g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
    }
}