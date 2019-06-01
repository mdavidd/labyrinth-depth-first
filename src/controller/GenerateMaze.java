/*
 * //
 */
package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.JPanel;
import model.MojStack;

/**
 *
 * @author david
 */
public class GenerateMaze extends JPanel {
    /*
     * Klasa GenerateMaze generira labirint tako sto postavlja iterira kroz sve celije i postavlja
     * odgovarajuća stanja i brise zidove
     */
    private Celija[][] maze;
    
    public GenerateMaze(int n){ //kontruktor kreira onoliko celija k       
    maze = new Celija[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
		maze[i][j] = new Celija(i,j); 
        
        generiraj();
    }
    
    
    public void generiraj(){
    MojStack<Celija> stack = new MojStack<Celija>(); // stack za vracanje unazad kad nema slobodne celije za otici

        // pocetak generiranja (gornji desni kut)
        int x = duzina() - 1;
        int y = 0;
        Celija trenutna = maze[x][y];
        trenutna.mark(); // biljezi trenutnu kao zauzetu
        stack.add(trenutna); // i tu obiljezenu dodaje na stack svih posjecenih
        Celija next;

        // dok ima celija...
        while (!stack.isEmpty()) {
                // ...uzmi random slijedecu celiju (random implementiran niže)
                Celija cell = randomCell(trenutna);
                // ako je randomCell vratio celiju...
                if (cell != null) {
                        // uzmi X i Y kooridnate iduce celije
                        int tempx = cell.getX();
                        int tempy = cell.getY();
                        next = maze[tempx][tempy];

                        // na trenutnoj brisemo zidove u smijeru iduce izabrane pomocu randomCell
                        if (x < tempx) {
                                next.removeWall(Celija.Walls.LEFT);
                                trenutna.removeWall(Celija.Walls.RIGHT);
                        } else if (y < tempy) {
                                next.removeWall(Celija.Walls.TOP);
                                trenutna.removeWall(Celija.Walls.BOTTOM);
                        } else if (x > tempx) {
                                next.removeWall(Celija.Walls.RIGHT);
                                trenutna.removeWall(Celija.Walls.LEFT);
                        } else if (y > tempy) {
                                next.removeWall(Celija.Walls.BOTTOM);
                                trenutna.removeWall(Celija.Walls.TOP);
                        }

                        // i iducu celiju dodati na stack
                        stack.add(next);
                        next.mark(); // obiljeziti i slijedecu kao podsjecenu
                        // zakljucno se pomaknuti na slijedecu tako sto ona postaje trenutna
                        x = tempx;
                        y = tempy;
                        trenutna = maze[x][y];
                } else {
                        // ako nema moguces poteza uzmi iduci potez sa stacka
                        next = stack.pop();
                        x = next.getX();
                        y = next.getY();
                        trenutna = maze[x][y];
                }
        }
        // Postavljanje kraja na donju desnu
        maze[duzina() - 1][duzina() - 1].removeWall(Celija.Walls.RIGHT);
    }

    public Celija randomCell(Celija c) {
    int x = c.getX();
    int y = c.getY();
    ArrayList<Celija> mogucaOpcija = new ArrayList<Celija>();

        // provjerava celiju prema desno ( x + 1 )
        if (x + 1 != duzina() && !maze[x + 1][y].isVisited()) {
                mogucaOpcija.add(maze[x + 1][y]);
        }

        // provjerava celiju prema lijevo ( x - 1)
        if (x - 1 != -1 && !maze[x - 1][y].isVisited()) {
                mogucaOpcija.add(maze[x - 1][y]);
        }

        // provjerava celiju prema dole ( y - 1 )
        if (y + 1 != duzina() && !maze[x][y + 1].isVisited()) {
                mogucaOpcija.add(maze[x][y + 1]);
        }

        // provjerava celiju prema gore ( y + 1 )
        if (y - 1 != -1 && !maze[x][y - 1].isVisited()) {
                mogucaOpcija.add(maze[x][y - 1]);
        }

        Celija cell = null;
        // i na kraju izabire random celiju od mogucih opcija i vraca ju ako postoji
        if (!mogucaOpcija.isEmpty()) {
                Random randomizer = new Random();
                cell = mogucaOpcija.get(randomizer.nextInt(mogucaOpcija.size()));
        }

        return cell;
    }
    
    
    public int duzina() { //zato sto je size() unutar JPanel-a
        return this.maze[0].length; //maze[0]znaci duzina prema desno koliko je velik
    }
    
    public Celija[][] getMaze(){
        return maze;
    }

    
}
