import java.util.LinkedList;

public class BulletGenerater {
	private LinkedList<Bullet> _bullets;
	BulletGenerater(){}
	void generate(Bullet b){;
		_bullets.add(b);
	}
	void update(GameInfo gameinfo){
		
	}
	public void setBullets(LinkedList<Bullet> _bullets2) {
		_bullets = _bullets2;
	}

}
