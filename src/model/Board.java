package model;

import logic.Location;
import util.JsonLoader;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    private int missingPiece = 0;

    public ArrayList<PuzzlePiece> getPuzzlePieces() {
        return puzzlePieces;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public Board() {
       createBoard();
        //panel.setPuzzlePieces(puzzlePieces);
    }
    private void createBoard(){
        missingPiece = JsonLoader.getInstance().getJsonConfig().getMissingPiece();
        ArrayList<Integer> piecesRandomOrder = JsonLoader.getInstance().getJsonConfig().getPicsRandomOrder();
        ArrayList<String> imageAddresses = JsonLoader.getInstance().getJsonConfig().getImageAddresses();

        // panel.setMissingPiece(7);
        for (int i = 0; i < 9; i++) {
            if (missingPiece != i) {
                puzzlePieces.add(new PuzzlePiece( imageAddresses.get(i),piecesRandomOrder.get(i) + 1 + ".png", new Location((i%3),(i/3))));
            } else {
                puzzlePieces.add(new PuzzlePiece( imageAddresses.get(i),"missing.jpg", new Location((i%3),(i/3))));
            }
        }
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }
}
