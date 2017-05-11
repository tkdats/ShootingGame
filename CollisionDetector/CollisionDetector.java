import java.util.LinkedList;

public class CollisionDetector {
	private int time;
	private int hittime;//���O�ɍU�����󂯂����ԁi���G���ԗp

	private boolean isHit(Object obj1,Object obj2){
		double dx=obj1.x-obj2.x;
		double dy=obj1.y-obj2.y;
		//���S����<���a�̘a�Ȃ�Փ�
		if(Math.sqrt(dx*dx+dy*dy)<obj1.r+obj2.r){
			return true;
		}
		return false;
	}
	
	//main����Ă΂��
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
