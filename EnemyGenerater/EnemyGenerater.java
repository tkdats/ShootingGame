import java.util.LinkedList;
import java.util.Random;

public class EnemyGenerater {
	Random rnd=new Random();
	public void generate(GameInfo gameinfo, LinkedList<Enemy> _enemies) {
		//10フレーム1回SampleEnemy1を出す。
		if(gameinfo.frames%10==0){
			_enemies.add(new SampleEnemy1((double)rnd.nextInt(Utility.sizex),1,(double)(rnd.nextInt(10)-5),3));
		}
		if(gameinfo.frames==100){
			_enemies.add(new Boss1(250,25,0,0));
		}
	}
	
}
