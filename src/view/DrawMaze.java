/*
 * //
 */
package view;

import controller.Celija;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class DrawMaze extends JPanel {
    int vpolja = 25;
    private Celija[][] maze;
    public int offset = 10; // offset od ruba ekrana

    public DrawMaze(Celija[][] donemaze) {
        this.maze = donemaze;
    }
    
        // poziv bojanja
    @Override
    public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
    drawOkvir(g);
    
    }
    
        // iritira kroz celije i postavlja zidove
    public void drawOkvir(Graphics g) {
        Graphics2D d2d = (Graphics2D)g;
        revalidate();
        repaint();
        for (int i = 0; i < this.duzina(); i++) {
            for (int j = 0; j < this.duzina(); j++) {
		if (maze[i][j].isLeft()) {
                    d2d.drawLine(i * vpolja + offset, j * vpolja + offset, i * vpolja + offset, (j + 1) * vpolja + offset);
		}
		if (maze[i][j].isRight()) {
                    d2d.drawLine((i + 1) * vpolja + offset, j * vpolja + offset, (i + 1) * vpolja + offset, (j + 1) * vpolja + offset);
		}
		if (maze[i][j].isBottom()) {
                    d2d.drawLine(i * vpolja + offset, (j + 1) * vpolja + offset, (i + 1) * vpolja + offset, (j + 1) * vpolja + offset);
		}
		if (maze[i][j].isTop()) {
                    d2d.drawLine(i * vpolja + offset, j * vpolja + offset, (i + 1) * vpolja + offset, j * vpolja + offset);
		}
                if (maze[i][j].isPlayer()) {
                    d2d.fillRect(i *vpolja+offset+4, j*vpolja+offset+4, 20, 20);
		}
            }
        }
    }
    
    public int duzina() { //zato sto je size() unutar JPanel-a
        return this.maze[0].length;
    }
    
}
