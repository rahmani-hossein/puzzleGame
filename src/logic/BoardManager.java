package logic;

import control.Controller;
import model.Board;
import model.PuzzlePiece;

public class BoardManager {
   private Board board;
   private static BoardManager boardManager;


  public BoardManager(){
       board=new Board();
   }
   public BoardManager(Board board){
      this.board=board;
   }



    public void swapPieces(int i, int j) {
        PuzzlePiece copy = board.getPuzzlePieces().get(i).getClone();
       board.getPuzzlePieces().get(i).setImage(board.getPuzzlePieces().get(j).getImage());
        board.getPuzzlePieces().get(i).setPieceNumber(board.getPuzzlePieces().get(j).getPieceNumber());
        board.getPuzzlePieces().get(j).setImage(copy.getImage());
        board.getPuzzlePieces().get(j).setPieceNumber(copy.getPieceNumber());


        if (gameFinished()) {
           Controller.getInstance().setGameState("finished");
        }
    }

    private boolean gameFinished() {
        for (int i = 0; i < 9; i++) {
            int pieceIdentifier = board.getPuzzlePieces().get(i).getPieceNumber();
            if (pieceIdentifier == 8) {
                continue;
            }

            if (pieceIdentifier != i) {
                return false;
            }
        }
        return true;
    }
}
