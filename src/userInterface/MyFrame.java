package userInterface;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
   private static MyFrame myFrame=new MyFrame(MyPanel.getInstance());

   public static MyFrame getInstance(MyPanel myPanel){
       return myFrame;
   }

   private MyFrame(MyPanel panel){
//        setSize(panel.getSize());
//        setLocation(panel.getLocation());
//        add(panel);
        setSize(panel.getSize());
        setLocation(panel.getLocation());
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new MyKeyListener());
        setVisible(true);

    }
}
