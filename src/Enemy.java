import java.awt.Color;
import java.awt.Graphics;

public abstract class Enemy extends Object{
	
    public boolean onUpdate(GameInfo gameinfo){
        return true;
    }
    
    public void onDraw(Graphics g){  
    }

}
