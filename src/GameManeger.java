import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class GameManeger {
	enum GameState {
		TITLE, MAIN, GAMEOVER,
	}

	private GameState gameState;
	private LinkedList<Bullet> _bullets = new LinkedList<Bullet>();
	private LinkedList<Enemy> _enemies = new LinkedList<Enemy>();
	private LinkedList<Object> _objectList = new LinkedList<Object>();

	Player player = new Player();
	ScoreBoard scoreboard = new ScoreBoard();
	EnemyGenerater enemyGenerater = new EnemyGenerater();
	CollisionDetector collisionDetector = new CollisionDetector();

	GameManeger(GameInfo gameinfo) {
		gameinfo.clear = false;
		gameinfo.gameOver = false;
		changeState(GameState.TITLE, gameinfo);
	}

	private void GameInit(GameInfo gameinfo) {
		_objectList.add(new FpsController());
		_objectList.add(player);
		_objectList.add(scoreboard);
		gameinfo.bulletGenerater.setBullets(_bullets);
		gameinfo.player = player;
	}

	private void removeAll() {
		_bullets.clear();
		_enemies.clear();
		_objectList.clear();

	}

	private static void objectRemover(LinkedList<Object> _list) {
		for (int i = 0; i < _list.size(); i++) {
			if (!_list.get(i).exist) {
				_list.remove(i);
				i--;
			}
		}
	}

	private static void enemyRemover(LinkedList<Enemy> _list) {
		for (int i = 0; i < _list.size(); i++) {
			if (!_list.get(i).exist) {
				_list.remove(i);
				i--;
			}
		}
	}

	private static void bulletRemover(LinkedList<Bullet> _list) {
		for (int i = 0; i < _list.size(); i++) {
			if (!_list.get(i).exist) {
				_list.remove(i);
				i--;
			}
		}
	}

	private void changeState(GameState to, GameInfo gameinfo) {
		removeAll();
		gameState = to;
		switch (gameState) {
		case TITLE:
			break;
		case MAIN:
			GameInit(gameinfo);
			break;
		case GAMEOVER:
			break;
		}
	}

	private void titleUpdate(GameInfo gameinfo) {
		if (gameinfo.keyPressed[4]) {
			changeState(GameState.MAIN, gameinfo);
		}
	}

	private void mainUpdate(GameInfo gameinfo) {
		enemyGenerater.generate(gameinfo, _enemies);
		for (int i = 0; i < _bullets.size(); i++) {
			if (!_bullets.get(i).listed) {
				_bullets.get(i).listed = true;
				_objectList.add(_bullets.get(i));
			}
		}
		for (int i = 0; i < _enemies.size(); i++) {
			if (!_enemies.get(i).listed) {
				_enemies.get(i).listed = true;
				_objectList.add(_enemies.get(i));
			}
		}
		for (int i = 0; i < _objectList.size(); i++) {
			_objectList.get(i).onUpdate(gameinfo);
		}
		collisionDetector.check(player, _bullets, _enemies);
		bulletRemover(_bullets);
		enemyRemover(_enemies);
		objectRemover(_objectList);
		if(!player.exist){
			changeState(GameState.GAMEOVER,gameinfo);
		}
	}

	public boolean onUpdate(GameInfo gameinfo) {
		switch (gameState) {
		case TITLE:
			titleUpdate(gameinfo);
			break;
		case MAIN:
			mainUpdate(gameinfo);
			break;
		case GAMEOVER:
			break;
		}
		return true;
	}

	public void onDraw(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Utility.sizex + Utility.ScoreBoardWidth, Utility.sizey);
		//////////////////////////////////////////tmp
		if (gameState == GameState.TITLE) {
			g.setColor(Color.RED);
			g.drawString("Press z to start", (Utility.sizex + Utility.ScoreBoardWidth) / 2, Utility.sizey / 3);
		}
		
		if (gameState == GameState.GAMEOVER) {
			g.setColor(Color.RED);
			g.drawString("GameOver", (Utility.sizex + Utility.ScoreBoardWidth) / 2, Utility.sizey / 3);
		}
		/////////////////////////////////////////////////////
		for (int i = 0; i < _objectList.size(); i++) {
			_objectList.get(i).onDraw(g);// •`‰æ
		}
	}

}