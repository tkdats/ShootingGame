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
//JFrame ���p��
public class MainClass extends JFrame{
	
    public static void main(String args[]){
    	MainClass frame = new MainClass("game");
        frame.setVisible(true);
    }

    //constructor. �t���[���̐ݒ�֌W���s��
    MainClass(String title){
        setTitle(title);
        //setSize(Utility.sizex+Utility.ScoreBoardWidth,Utility.sizey);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CLOSE�Ńv���O�����I��
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(Utility.sizex+Utility.ScoreBoardWidth, Utility.sizey));
        pack();
        setLocationRelativeTo(null);//������ʕ\���ʒu�𒆉���
        setVisible(true);
        
        Container CP = getContentPane();//getContentPane()��JFrame�N���X�ɒ�`����Ă���
        //CP.setLayout(null);//���C�A�E�g�}�l�[�W�����~

        //�㕔�̔w�i�F���ɐݒ肷��
        JPanel panel = new JPanel();
       // panel.setBackground(Color.ORANGE);
        

        //Main�p�l���̍쐬�A�t���[���ւ̃Z�b�g
        MainPanel MP = new MainPanel();
        CP.add(MP);
        //CP.remove(MP);//�t���[�����O��
        addKeyListener(MP);//KeyListener���t���[���ɃZ�b�g
        //CP.removeKeyListener(MP);//KeyListener���O��
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
        setBackground(Color.blue);//�w�i�F���
        t = new Thread(this);//Thread instance
        t.start();//Thread Start
    }

    //Runnable�ɂ��run() method
    public void run(){
        //�������[�v��Thread���I�����Ȃ��悤�ɂ���
        while(true){
        	gameinfo.setAll();
        	gameinfo.frames++;
        	_startTime = System.currentTimeMillis();
            //��`�̑傫����ύX����
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

    //JComponent�ɂ��paintComponent method
    //JPanel �� JComponent ���p�����Ă���
    public void paintComponent(Graphics g){
        //�Ԃ���`��`�悷��
    	mgr.onDraw(g);
       
        
    }

    /**********************
        KeyEvent
    **********************/
    //Key�������ꂽ�ꍇ
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

    //Key�������ꂽ�ꍇ
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

    //Key�������ꂽ�ꍇ
    public void keyTyped(KeyEvent e){}
}
