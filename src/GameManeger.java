import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class GameManeger {
		
        private LinkedList<Bullet> _bullets = new LinkedList<Bullet>(); 
        private LinkedList<Enemy> _enemies = new LinkedList<Enemy>(); 
        private LinkedList<Object> _objectList = new LinkedList<Object>(); 
        
       
        Player player=new Player();
        EnemyGenerater enemyGenerater=new EnemyGenerater();
        CollisionDetector collisionDetector = new CollisionDetector();
        GameManeger(GameInfo gameinfo){
        		_objectList.add( new FpsController() );
                _objectList.add(player);
                gameinfo.bulletGenerater.setBullets(_bullets);
                gameinfo.player=player;
        }
        private static void objectRemover(LinkedList<Object> _list){
        	for(int i=0; i<_list.size(); i++){
                if(!_list.get(i).available){ 
                	_list.remove(i);              
                        i--;
                }
      	 	}
        }
        private static void enemyRemover(LinkedList<Enemy> _list){
        	for(int i=0; i<_list.size(); i++){
                if(!_list.get(i).available){ 
                	_list.remove(i);              
                        i--;
                }
      	 	}
        }
        private static void bulletRemover(LinkedList<Bullet> _list){
        	for(int i=0; i<_list.size(); i++){
                if(!_list.get(i).available){ 
                	_list.remove(i);              
                        i--;
                }
      	 	}
        }
       
        public boolean onUpdate(GameInfo gameinfo) {     
        	enemyGenerater.generate(gameinfo,_enemies);
        	for(int i=0; i<_bullets.size(); i++){
        		if(!_bullets.get(i).listed){
        			_bullets.get(i).listed=true;
        			_objectList.add(_bullets.get(i));
        		}
        	}
        	for(int i=0; i<_enemies.size(); i++){
        		if(!_enemies.get(i).listed){
        			_enemies.get(i).listed=true;
        			_objectList.add(_enemies.get(i));
        		}
        	}
      	 	for(int i=0; i<_objectList.size(); i++){
                _objectList.get(i).onUpdate(gameinfo);
      	 	}
      	 	collisionDetector.check(player,_bullets,_enemies);
      		bulletRemover(_bullets);
      		enemyRemover(_enemies);
      		objectRemover(_objectList);
      	 	return true;
        }

        public void onDraw(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 500, 500);
                for(int i=0; i<_objectList.size(); i++){
                	_objectList.get(i).onDraw(g);//•`‰æ
                }
        }

}