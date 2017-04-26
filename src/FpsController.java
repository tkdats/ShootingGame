import java.awt.Color;
import java.awt.Graphics;

public class FpsController extends Object {

        private long _startTime = 0;            //����J�n����
        private int  _cnt = 0;                  //�J�E���^

        private float _fps;                     //fps
        private final static int N = 60;        //���ς����T���v����
        //private final static int FONT_SIZE = 20;//�t�H���g�T�C�Y
        
        public FpsController(){
                
        }
        
        @Override
        public boolean onUpdate(GameInfo gameinfo){
                if( _cnt == 0 ){ //1�t���[���ڂȂ玞�����L��
                        _startTime = System.currentTimeMillis();
                }
                if( _cnt == N ){ //60�t���[���ڂȂ畽�ς��v�Z����
                        long t = System.currentTimeMillis();
                        _fps = 1000.f/((t-_startTime)/(float)N);
                        _cnt = 0;
                        _startTime = t;
                }
                _cnt++;
                return true;
        }

        @Override
        public void onDraw(Graphics g){
        	 g.setColor(Color.WHITE);
                g.drawString("fps="+String.format("%.1f", _fps),5,30);
        }

}