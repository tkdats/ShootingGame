import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScoreBoard extends Object{
	private int score=0;
	private double life;
	ScoreBoard(){
	    
	}
	@Override
    public boolean onUpdate(GameInfo gameinfo){
		life = gameinfo.player.hitpoint;
		score = gameinfo.score;
		return true;
    }
	@Override
    public void onDraw(Graphics g){  
		 g.setColor(Color.WHITE);
         g.fillRect(Utility.sizex, 0, Utility.ScoreBoardWidth, Utility.sizey);
         
         Font font1 = new Font("Arial",Font.PLAIN, 32);
         g.setColor(Color.BLUE);
         g.setFont(font1);
         g.drawString("score:"+score,500,50);
         g.drawString("life:"+life,500,200);
         
         
	}

}
