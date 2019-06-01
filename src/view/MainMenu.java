/*
 * //
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author david
 */
public class MainMenu {
    /*
    Kreiranje stavki izbornika
    */
    JFrame Menu = new JFrame("Labirint Seminar");
    JButton Start = new JButton("Play");
    JButton Exit = new JButton("Exit");
    ImageIcon slika = new ImageIcon("C:/javaproj/labirint_projekt/src/view/MazeFrame.png"); //slika
    JLabel imageLabel = new JLabel(slika);
    JLabel Razina = new JLabel("choose difficulty;");
    String[] razine = {"lagano","srednje","tesko"};
    JComboBox Lvls = new JComboBox(razine);
    //definiranje velicine za sam frame i za tipke
    int WIDTH = 490;
    int HEIGHT = 530;
    int menuWidth = 100;
    int menuHeight = 30;
    
    
    /*
    postavljanje vrijednosti na stavke izbornika i njihov prikaz
    */
    public MainMenu(){
        //frame
        Menu.setResizable(false);
        Menu.setVisible(true);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //start tipka
        Start.setSize(menuWidth, menuHeight);
        Start.setLocation(10, 460);
        Menu.add(Start);
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new MazeFrame(Lvls.getSelectedItem().toString());
                Menu.setVisible(false);
            }
        });
        
        //razina label
        Razina.setSize(menuWidth,menuHeight);
        Razina.setVisible(true);
        Razina.setLocation(120, 460); //10+100 i jos 10 razmak
        Menu.add(Razina);
        
        //izbornik razina (combobox)
        Lvls.setSize(menuWidth+35, menuHeight);
        Lvls.setVisible(true);
        Lvls.setLocation(230,460);
        Menu.add(Lvls);
        
        //exit tipka
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(375,460);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        //slika
        imageLabel.setBounds((WIDTH-383)/2, 25, 385, 380);
        imageLabel.setVisible(true);
        Menu.add(imageLabel);
        
    }
    
}
