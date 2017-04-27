import java.awt.Color;
import java.awt.Graphics;

public class ScoreBoard extends Object{
	ScoreBoard(){
		
	}
	@Override
    public boolean onUpdate(GameInfo gameinfo){
        return true;
    }
	@Override
    public void onDraw(Graphics g){  
		 g.setColor(Color.WHITE);
         g.fillRect(Utility.sizex, 0, Utility.ScoreBoardWidth, Utility.sizey);
    }

}
