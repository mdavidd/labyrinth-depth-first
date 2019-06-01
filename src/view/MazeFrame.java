/*
 * //
 */
package view;

import javax.swing.JFrame;
import controller.Celija;
import controller.GenerateMaze;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import model.Player;

/**
 *
 * @author david
 */
public class MazeFrame extends JFrame {
    int n; // 15 , 25, 35
    public Celija[][] donemaze;

    public MazeFrame(String odabranaRazina) {
        if("lagano".equals(odabranaRazina)){
            this.n = 15;
        }
        if("srednje".equals(odabranaRazina)){
            this.n = 25;       
        }
        if("tesko".equals(odabranaRazina)){
            this.n = 35;           
        }    
        //okvir i panel za igru, novi JFrame.
        this.setSize((n + 1) * 25, (n + 2) * 25); // +1 i +2 zbog title bara da stane cijeli prikaz
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);    
        this.setResizable(false);
        
        GenerateMaze gm = new GenerateMaze(n);
        donemaze = gm.getMaze(); //spremamo generirane celije u array done maze
        DrawMaze draw = new DrawMaze(donemaze); //crtamo labirint ovisno o stanju zidova u celijama
        Player p = new Player(donemaze);
        
        this.add(gm);
        this.add(draw);
        //this.add(p);
        
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                int key = ke.getKeyCode();
                
                //Kretnje igraca
                if(key == KeyEvent.VK_W){
                        p.moveUp();
                }
                if(key == KeyEvent.VK_A){
                        p.moveLeft();
                }
                if(key == KeyEvent.VK_S){
                        p.moveDown();
                }
                if(key == KeyEvent.VK_D){
                        p.moveRight();
                }
                Celija end[][] = p.getCelija();
                if(end[n-1][n-1].isPlayer()){
                        JOptionPane.showMessageDialog(null, "Cestitam! Presli ste level!", "Kraj igre", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new MainMenu();
                }
                
            }               
            
            @Override
            public void keyTyped(KeyEvent ke) {
                //TODO Auto-generated method stub
            }
            @Override
            public void keyReleased(KeyEvent ke) {
                //TODO Auto-generated method stub
            }
        });{ }
        
    }
    
    
}
    
    
