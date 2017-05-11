import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//Boss
public class Boss1 extends Enemy{
	private double vx;
	private double vy;
	private static int count=1;
	
	//初期化
	Boss1(double  _x,double  _y, double  _vx,double  _vy){
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
    	Random rnd= new Random();
    	Random v_rnd= new Random();
    	//100フレーム毎に画面内に収まるならランダムに動く、そうでなければ動かない
    	if(gameinfo.frames % ((100/count)+1)==0){
    		double temp_x=x;
        	double temp_y=y;
        	x+=(-1+v_rnd.nextDouble()*2)*200;
        	y+=(v_rnd.nextDouble())*5;
    	
    	if(!Utility.onScreen(this)){
    	x=temp_x;
    	y=temp_y;
    	}
    	}
    	//5フレームに1回弾を発射する
    	if(gameinfo.frames % ((20/count)+1)==0){
    		double t=rnd.nextDouble()*2*Math.PI;
    		gameinfo.bulletGenerater.generate(new BossBullet(x,y,2*Math.cos(t),2*Math.sin(t)));
    	}
    	
    	//画面外またはHP<0で消滅
    	if(!Utility.onScreen(x,y)||hitpoint<0){
    		exist=false;
    		gameinfo.score+=2000;
    		count++;
    		// gameinfo.clear=true;
    	}
        return true;
    }
    
    public void onDraw(Graphics g){
   	 	g.setColor(Color.GREEN);
   	 	g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
    }
}