/*
 * //
 */
package model;

import controller.Celija;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Player extends JPanel{
    int x = 0, y = 0;
    Celija[][] start;
    int KrajLevela;

    public Player(Celija[][] donemaze) {  // ??
        start = donemaze;
        start[x][y].setPlayer();
        this.KrajLevela = donemaze.length;
    }
    
    public void moveLeft(){
        /*if(x-- < 0){return;}
        if(start[x-1][y].right){return;}*/
        if(!start[x][y].left){
            start[x][y].removePlayer();
            this.x--;
            start[x][y].setPlayer();
        }
        
    }
    public void moveRight(){
        /*if(x++ > duzina()-1){return;}
        if(start[x+1][y].left){return;}*/
        if(!start[x][y].right){
            start[x][y].removePlayer();
            this.x++;
            start[x][y].setPlayer();
        }
    }
    public void moveUp(){
        /*if(y-- < 0){return;}
        if(start[x][y-1].bottom){return;}*/
        if(!start[x][y].top){
            start[x][y].removePlayer();
            this.y--;
            start[x][y].setPlayer();
        }
    }
    public void moveDown(){
        /*if(y++ > duzina()-1){return;}
        if(start[x][y+1].top){return;}*/
        if(!start[x][y].bottom){
            start[x][y].removePlayer();
            this.y++;
            start[x][y].setPlayer();
        }
    }
    
    public Celija[][] getCelija(){
        return this.start;
    }
    
    
    

}
