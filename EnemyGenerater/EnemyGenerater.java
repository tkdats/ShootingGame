import java.util.LinkedList;
import java.util.Random;

public class EnemyGenerater {
	Random rnd=new Random();
	int bossCount=1;
	boolean BossFlag=false;
	public void generate(GameInfo gameinfo, LinkedList<Enemy> _enemies) {
		//10フレーム1回SampleEnemy1を出す。
		if(gameinfo.score>5000*bossCount && !BossFlag){
			_enemies.add(new Boss1(250,25,0,0));
			bossCount++;
			// BossFlag=true;
		}
		if(gameinfo.frames%200==0){
			_enemies.add(new WeakEnemy1((double)rnd.nextInt(Utility.sizex),(double)(rnd.nextInt(150)),(double)(rnd.nextInt(10)-5),3));
		}
		if(gameinfo.frames%200==0){
			_enemies.add(new WeakEnemy2((double)rnd.nextInt(Utility.sizex),(double)(rnd.nextInt(150)),(double)(rnd.nextInt(10)-5),3));
		}
	}

}
