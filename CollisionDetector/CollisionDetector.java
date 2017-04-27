import java.util.LinkedList;

public class CollisionDetector {

	private boolean isHit(Object obj1,Object obj2){
		double dx=obj1.x-obj2.x;
		double dy=obj1.y-obj2.y;
		//S£<ΌaΜaΘηΥΛ
		if(Math.sqrt(dx*dx+dy*dy)<obj1.r+obj2.r){
			return true;
		}
		return false;
	}
	
	//main©ηΔΞκι
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
    			if(isHit(player,_bullets.get(i))){
    				_bullets.get(i).exist=false;
    				player.hitpoint-=1;
    			}
    		}
    	}
		return false;
	}

}
