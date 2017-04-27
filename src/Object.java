import java.awt.Graphics;

public abstract class Object {
		public double x;
		public double y;
		public double r;
		public double width;
		public double height;
		public double hitpoint;
		public double hp;//˜M‚Á‚½
		public boolean isMikata;
		public boolean listed=false;
		public boolean exist=true;
		public String GraphicHandle;
        public boolean onUpdate(GameInfo gameinfo){
                return true;
        }
        
        public void onDraw(Graphics g){           
        }

}