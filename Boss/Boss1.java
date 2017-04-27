import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//Boss
public class Boss1 extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	Random v_rnd= new Random();
	//初期化
	Boss1(double  _x,double  _y, double  _vx,double  _vy){
		x=_x;
		y=_y;
		vx=_vx;
		vy=_vy;
		width=50;
		height=50;
		r=10;
		hitpoint=300;
	}
    public boolean onUpdate(GameInfo gameinfo){
    	//画面内に収まるならランダムに動く、そうでなければ動かない
    	if(gameinfo.frames % 100==0){
    	double new_x=x+(-1+v_rnd.nextDouble()*2)*200;
    	double new_y=y+(-1+v_rnd.nextDouble()*2)*5;
    	if(Utility.onScreen(new_x,new_y)){
    	x=new_x;
    	y=new_y;
    	}
    	}
    	//5フレームに1回弾を発射する
    	if(gameinfo.frames % 5==0){
    		double t=rnd.nextDouble()*2*Math.PI;
    		gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,2*Math.cos(t),2*Math.sin(t)));
    	}
    	
    	//画面外またはHP<0で消滅
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