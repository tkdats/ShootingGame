import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//横にスライドしながら前にだけ発射する雑魚キャラ
public class WeakEnemy2 extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	//初期化
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
    	//横にスライド
    	if(x>=400 && vx>0)vx=-vx;
    	else if(x<=100 && vx<0)vx=-vx;
    	x+=vx;
    	
    	//50フレームに1回弾を発射する
    	if(gameinfo.frames % 50==0){
    		gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,0,2));
    	}
    	
    	//画面外またはHP<0で消滅
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
