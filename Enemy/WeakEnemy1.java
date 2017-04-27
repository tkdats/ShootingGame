import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
//周りに一斉に発射する雑魚キャラ
public class WeakEnemy1 extends Enemy{
	private double vx;
	private double vy;
	Random rnd= new Random();
	//初期化
	WeakEnemy1(double  _x,double  _y, double  _vx,double  _vy){
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
    	//位置に速度を足す
    	if(gameinfo.frames %10==0){
    		if(rnd.nextDouble()>0.5)x+=rnd.nextDouble()*vx;
    		else x-=rnd.nextDouble()*vx;
    		if(rnd.nextDouble()>0.2)y+=rnd.nextDouble()*vy;
    		else y-=rnd.nextDouble()*vy;
    	}
   		
    	//周りに発射する
    	if(gameinfo.frames % 100==0){
    		double t=rnd.nextDouble()*2*Math.PI;
    		for(int i=0;i<12;i++){
    			gameinfo.bulletGenerater.generate(new SampleBullet2(x,y,2*Math.cos(t+30*i),2*Math.sin(t+30*i)));
    		}
    	}
    	
    	//画面外またはHP<0で消滅
    	if(!Utility.onScreen(x,y)||hitpoint<0){
    		exist=false;
    		gameinfo.score+=500;
    	}
        return true;
    }
    
    public void onDraw(Graphics g){
   	 	g.setColor(Color.YELLOW);
   	 	g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
    }
}