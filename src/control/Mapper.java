package control;


import intefaces.Execution;

public class Mapper {

    private Controller controller;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // be khater static bodan majbor shodam missingPiece ro bara hameh tarif konam
    //singelton mapper
    private static Mapper instance = new Mapper();

    public static Mapper getInstance() {
        return instance;
    }

    private Mapper() {

    }

    public  void executeRequest(Request request) {
        request.execute();
    }


    private static void swapLeft() {
        System.out.println("your command swapLeft");
        int missingPieceIndex = Controller.getInstance().getBoard().getMissingPiece();
        if (missingPieceIndex % 3 == 0) {
            return;
        }
        Controller.getInstance().getBoardManager().swapPieces(missingPieceIndex, missingPieceIndex - 1);
        Controller.getInstance().getBoard().setMissingPiece(missingPieceIndex - 1);
    }

    private static void swapUp() {
        System.out.println("your command swapUp");
        int missingPieceIndex = Controller.getInstance().getBoard().getMissingPiece();
        if (missingPieceIndex <= 2) {
            return;
        }
        Controller.getInstance().getBoardManager().swapPieces(missingPieceIndex, missingPieceIndex - 3);
        Controller.getInstance().getBoard().setMissingPiece(missingPieceIndex - 3);

    }

    private static void swapDown() {
        System.out.println("your command swapDown");
        int missingPieceIndex = Controller.getInstance().getBoard().getMissingPiece();
        if (missingPieceIndex >= 6) {
            return;
        }
        Controller.getInstance().getBoardManager().swapPieces(missingPieceIndex, missingPieceIndex + 3);
        Controller.getInstance().getBoard().setMissingPiece(missingPieceIndex + 3);


    }

    private static void swapRight() {
        System.out.println("your command swapRight");
        int missingPieceIndex = Controller.getInstance().getBoard().getMissingPiece();
        if (missingPieceIndex % 3 == 2) {
            return;
        }
        Controller.getInstance().getBoardManager().swapPieces(missingPieceIndex, missingPieceIndex + 1);
        Controller.getInstance().getBoard().setMissingPiece(missingPieceIndex + 1);
    }

    public enum Request implements Execution {
        SWAP_LEFT {
            @Override
            public void execute() {
                swapLeft();
            }
        },
        SWAP_RIGHT {
            @Override
            public void execute() {
                swapRight();
            }
        },
        SWAP_UP {
            @Override
            public void execute() {
                swapUp();
            }
        },
        SWAP_DOWN {
            @Override
            public void execute() {
                swapDown();
            }
        }


    }


}
