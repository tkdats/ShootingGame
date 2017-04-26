import java.awt.Color;
import java.awt.Graphics;

public class FpsController extends Object {

        private long _startTime = 0;            //測定開始時刻
        private int  _cnt = 0;                  //カウンタ

        private float _fps;                     //fps
        private final static int N = 60;        //平均を取るサンプル数
        //private final static int FONT_SIZE = 20;//フォントサイズ
        
        public FpsController(){
                
        }
        
        @Override
        public boolean onUpdate(GameInfo gameinfo){
                if( _cnt == 0 ){ //1フレーム目なら時刻を記憶
                        _startTime = System.currentTimeMillis();
                }
                if( _cnt == N ){ //60フレーム目なら平均を計算する
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