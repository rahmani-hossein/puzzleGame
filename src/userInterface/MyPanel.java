package userInterface;

import control.Controller;
import model.PuzzlePiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {

    private static MyPanel panelInstance;

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }

    private ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    private int screenWidth, screenHeight;


    private MyPanel() {
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int maxSize = Math.max(screenWidth, screenHeight) / 3;
        setSize(maxSize, maxSize);
        setLocation(screenWidth / 2 - maxSize / 2, screenHeight / 2 - maxSize / 2);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Controller.getInstance().getBoard().getPuzzlePieces().size(); i++) {
            g.drawImage(Controller.getInstance().getBoard().getPuzzlePieces().get(i).getImage(),Controller.getInstance().getBoard().getPuzzlePieces().get(i).getLocation().getX()*(getHeight()/3),Controller.getInstance().getBoard().getPuzzlePieces().get(i).getLocation().getY()*(getWidth()/3),(int) getSize().getWidth() / 3, (int) getSize().getHeight() / 3,null);
        }
    }




    public ArrayList<PuzzlePiece> getPuzzlePieces() {
        return puzzlePieces;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }






}

