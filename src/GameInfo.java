
public class GameInfo {
	
	int KeyNum=5;
	int frames=0;
	int score;
	Player player;
	BulletGenerater bulletGenerater=new BulletGenerater();
	public boolean[] keyPressed=new boolean[KeyNum];
	public boolean[] tmp_Pressed=new boolean[KeyNum];
	GameInfo(){
		 for(int i=0;i<KeyNum;i++){
			 tmp_Pressed[i]=false;
		 }
		setAll();
	}
	protected void setAll(){
		 for(int i=0;i<KeyNum;i++){
			 keyPressed[i]=tmp_Pressed[i];
			 //tmp_Pressed[i]=false;
		 }
	}
}
