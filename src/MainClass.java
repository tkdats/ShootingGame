import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//takeda
//JFrame を継承
public class MainClass extends JFrame{
	
    public static void main(String args[]){
    	MainClass frame = new MainClass("game");
        frame.setVisible(true);
    }

    //constructor. フレームの設定関係を行う
    MainClass(String title){
        setTitle(title);
        //setSize(Utility.sizex+Utility.ScoreBoardWidth,Utility.sizey);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CLOSEでプログラム終了
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(Utility.sizex+Utility.ScoreBoardWidth, Utility.sizey));
        pack();
        setLocationRelativeTo(null);//初期画面表示位置を中央に
        setVisible(true);
        
        Container CP = getContentPane();//getContentPane()はJFrameクラスに定義されている
        //CP.setLayout(null);//レイアウトマネージャを停止

        //上部の背景色を橙に設定する
        JPanel panel = new JPanel();
       // panel.setBackground(Color.ORANGE);
        

        //Mainパネルの作成、フレームへのセット
        MainPanel MP = new MainPanel();
        CP.add(MP);
        //CP.remove(MP);//フレームを外す
        addKeyListener(MP);//KeyListenerをフレームにセット
        //CP.removeKeyListener(MP);//KeyListenerを外す
    }
}

class MainPanel extends JPanel implements Runnable, KeyListener{
    int x = 100, y = 100;
    boolean state = true;
    Thread t;
    
    GameInfo gameinfo = new GameInfo();
    GameManeger mgr=new GameManeger(gameinfo);
    private long _startTime;
    private double diff=0;
    
    MainPanel(){
        //setLayout(null);
        setBackground(Color.blue);//背景色を青に
        t = new Thread(this);//Thread instance
        t.start();//Thread Start
    }

    //Runnableによるrun() method
    public void run(){
        //無限ループでThreadが終了しないようにする
        while(true){
        	gameinfo.setAll();
        	gameinfo.frames++;
        	_startTime = System.currentTimeMillis();
            //矩形の大きさを変更する
        	mgr.onUpdate(gameinfo);
        	
            repaint();
            while(System.currentTimeMillis()-_startTime<17-(long)diff){
            	try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            diff+=(System.currentTimeMillis()-_startTime)-(double)1000/60;
        }
    }

    //JComponentによるpaintComponent method
    //JPanel は JComponent を継承している
    public void paintComponent(Graphics g){
        //赤い矩形を描画する
    	mgr.onDraw(g);
       
        
    }

    /**********************
        KeyEvent
    **********************/
    //Keyが押された場合
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            	gameinfo.tmp_Pressed[0]=true;
            	break;
            case KeyEvent.VK_RIGHT:
            	gameinfo.tmp_Pressed[1]=true;
                break;
            case KeyEvent.VK_DOWN:
            	gameinfo.tmp_Pressed[2]=true;
            	break;
            case KeyEvent.VK_LEFT:
            	gameinfo.tmp_Pressed[3]=true;
                break;
            case KeyEvent.VK_Z:
            	gameinfo.tmp_Pressed[4]=true;
                break;
        }
    }

    //Keyが離された場合
    public void keyReleased(KeyEvent e){
    	switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
        	gameinfo.tmp_Pressed[0]=false;
        	break;
        case KeyEvent.VK_RIGHT:
        	gameinfo.tmp_Pressed[1]=false;
            break;
        case KeyEvent.VK_DOWN:
        	gameinfo.tmp_Pressed[2]=false;
        	break;
        case KeyEvent.VK_LEFT:
        	gameinfo.tmp_Pressed[3]=false;
            break;
        case KeyEvent.VK_Z:
        	gameinfo.tmp_Pressed[4]=false;
            break;
    }
    }

    //Keyが押された場合
    public void keyTyped(KeyEvent e){}
}
