import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Utility {
	//screen size
	static int sizex=500;
	static int sizey=500;
	static int ScoreBoardWidth=200;
	public static void drawStringCenter(Graphics g,String text,int x,int y){
		FontMetrics fm = g.getFontMetrics();
		Rectangle rectText = fm.getStringBounds(text, g).getBounds();
		x=x-rectText.width/2;
		y=y-rectText.height/2+fm.getMaxAscent();
		
        g.drawString(text, x, y);
	}
	static boolean onScreen(double x,double y){
		if(x>0 && y>0 && x<sizex && y<sizey){
			return true;
		}else{
			return false;
		}
	}
	static boolean onScreen(Object obj){
		if(obj.x-(obj.width/2)>0 && obj.y-(obj.height/2)>0 && obj.x+(obj.width/2)<sizex && obj.y+(obj.height/2)<sizey){
			return true;
		}else{
			return false;
		}
	}
}
