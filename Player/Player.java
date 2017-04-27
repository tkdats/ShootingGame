import java.awt.Color;
import java.awt.Graphics;

public class Player extends Object {
//	������������������
	int state;
	Player(){
		width=20;
		height=20;
		r=10;
		x=Utility.sizex/2;
		y=Utility.sizey/2;
		hitpoint=5;
	}
	
	 @Override
     public boolean onUpdate(GameInfo gameinfo){
           if(gameinfo.keyPressed[0]){//up
        	   if (y > 10){
        		   y-=5;
        	   }
           }
           if(gameinfo.keyPressed[1]){//right
        	   if (x < Utility.sizex - 10){
        		   x+=5;
        	   }
           }
           if(gameinfo.keyPressed[2]){//down
        	   if (y < Utility.sizey - 10){
        		   y+=5;
        	   }
           }
           if(gameinfo.keyPressed[3]){//left
        	   if (x > 10){
        		   x-=5;
        	   }
           }
           if(gameinfo.keyPressed[4]){//z
        	   //���e����������
        	   gameinfo.bulletGenerater.generate(new SampleBullet1(x,y,(double)0,(double)-10));
           }
           
           if (hitpoint <= 0){
        	   exist = false;
           }
            return true;
     }

     @Override
     public void onDraw(Graphics g){
    	 g.setColor(Color.BLUE);
    	 g.drawRect((int)x-(int)(width/2), (int)y-(int)(height/2), (int)width, (int)height);
     }


}
