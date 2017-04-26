
public class Utility {
	//screen size
	static int sizex=500;
	static int sizey=500;
	static boolean onScreen(double x,double y){
		if(x>0 && y>0 && x<sizex && y<sizey){
			return true;
		}else{
			return false;
		}
	}
}
