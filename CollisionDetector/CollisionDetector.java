import java.util.LinkedList;

public class CollisionDetector {
	private int time;
	private int hittime;//直前に攻撃を受けた時間（無敵時間用

	private boolean isHit(Object obj1,Object obj2){
		double dx=obj1.x-obj2.x;
		double dy=obj1.y-obj2.y;
		//中心距離<半径の和なら衝突
		if(Math.sqrt(dx*dx+dy*dy)<obj1.r+obj2.r){
			return true;
		}
		return false;
	}
	
	//mainから呼ばれる
	public boolean check(Player player, LinkedList<Bullet> _bullets, LinkedList<Enemy> _enemies) {
		for(int i=0; i<_bullets.size(); i++){
    		if(_bullets.get(i).isMikata){
    			for(int j=0; j<_enemies.size(); j++){
    				if(isHit(_enemies.get(j),_bullets.get(i))){
        				_bullets.get(i).exist=false;
        				_enemies.get(j).hitpoint-=1;
        			}
    			}
    		}else{
    			if((isHit(player,_bullets.get(i)))&&(time-hittime>30)){
    				_bullets.get(i).exist=false;
    				player.hitpoint-=1;
    				Sound.play("playerdamaged.wav");
    				hittime=time;
    			}
    		}
    	}
		
		for(int i=0; i<_enemies.size(); i++){
			if((isHit(player,_enemies.get(i)))&&(time-hittime>30)){
				player.hitpoint-=1;
				Sound.play("playerdamaged.wav");
				hittime=time;
			}
			
		}
		time++;
		return false;
	}

}
