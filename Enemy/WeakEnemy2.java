import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//���ɃX���C�h���Ȃ���O�ɂ������˂���G���L����
public class WeakEnemy2 extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	//������
	WeakEnemy2(double  _x,double  _y, double  _vx,double  _vy){
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
    	//���ɃX���C�h
    	if(x>=400 && vx>0)vx=-vx;
    	else if(x<=100 && vx<0)vx=-vx;
    	x+=vx;
    	
    	//50�t���[����1��e�𔭎˂���
    	if(gameinfo.frames % 50==0){
    		gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,0,2));
    	}
    	
    	//��ʊO�܂���HP<0�ŏ���
    	if(!Utility.onScreen(x,y)||hitpoint<0){
    		exist=false;
    	}
        return true;
    }
    
    public void onDraw(Graphics g){
   	 	g.setColor(Color.ORANGE);
   	 	g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
    }
}
