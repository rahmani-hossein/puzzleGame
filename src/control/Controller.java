package control;

import logic.BoardManager;
import logic.Solver;
import model.Board;

import userInterface.MyFrame;
import userInterface.MyPanel;
import util.JsonLoader;

import javax.swing.*;

public class Controller {
    private static Controller controller;
    private Board board;
    private BoardManager boardManager;
    private Solver solver=new Solver();
    private MyPanel myPanel ;
    private MyFrame myFrame;
    private String gameState = "#";
    private boolean gameFinished=false;


    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
            return controller;
        }
        return controller;
    }

    private Controller() {
        board = new Board();
        boardManager = new BoardManager(board);
       myPanel=MyPanel.getInstance();
        myFrame= MyFrame.getInstance(myPanel);

        if(!(solver.solvable(board.getMissingPiece(), JsonLoader.getInstance().getJsonConfig().getPicsRandomOrder()))){
            JOptionPane.showMessageDialog(myFrame,"this puzzle can not be solved, please try again ","not solvable",JOptionPane.WARNING_MESSAGE);
            gameFinished=true;
        }
    }
    public void run(){
        while (true){
           gameLoad();
            if (gameFinished){
                break;
            }
            if (gameState.equals("finished")){
                JOptionPane.showMessageDialog(myFrame,"you just finished your game, CONGRATULATION","congratulation",JOptionPane.INFORMATION_MESSAGE);
                gameFinished=true;
            }
        }
    }
    private void gameLoad() {
        try {
            Thread.sleep(1000/JsonLoader.getInstance().getJsonConfig().getFramePerSecond());
        } catch (InterruptedException e) {
            System.out.println("some thing went wrong in the middle of loading :/");
            e.printStackTrace();
        }
        myPanel.repaint();
        myPanel.revalidate();
        myFrame.repaint();
        myFrame.revalidate();
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Controller.controller = controller;
    }

    public BoardManager getBoardManager() {
        return boardManager;
    }

    public void setBoardManager(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public MyPanel getMyPanel() {
        return myPanel;
    }

    public void setMyPanel(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

}
