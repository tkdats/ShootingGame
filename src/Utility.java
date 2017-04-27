
public class Utility {
	//screen size
	static int sizex=500;
	static int sizey=500;
	static int ScoreBoardWidth=200;
	static boolean onScreen(double x,double y){
		if(x>0 && y>0 && x<sizex && y<sizey){
			return true;
		}else{
			return false;
		}
	}
	static boolean onScreen(Object obj){
		if(obj.x+(obj.width/2)>0 && obj.y+(obj.height/2)>0 && obj.x-(obj.width/2)<sizex && obj.y-(obj.height/2)<sizey){
			return true;
		}else{
			return false;
		}
	}
}
