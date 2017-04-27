import java.util.LinkedList;
import java.util.Random;

public class EnemyGenerater {
	Random rnd=new Random();
	public void generate(GameInfo gameinfo, LinkedList<Enemy> _enemies) {
		if(gameinfo.frames%10==0){
			_enemies.add(new SampleEnemy1((double)rnd.nextInt(Utility.sizex),1,(double)(rnd.nextInt(10)-5),3));
		}
	}
	
}
