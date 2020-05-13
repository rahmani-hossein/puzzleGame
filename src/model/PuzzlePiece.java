package model;

import logic.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PuzzlePiece {
    private Image img;
     private Location location;
    private int pieceNumber;

    private PuzzlePiece(String fileName, String imageName) {
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!imageName.equals("missing.jpg")) {
            pieceNumber = Integer.parseInt(imageName.substring(0, 1)) - 1;
        } else {
            pieceNumber = 8;
        }
    }



   public PuzzlePiece(String fileName,String imageName,Location location) {
       this(fileName, imageName);
       this.location=location;
    }

    private PuzzlePiece(Image img, Location location, int pieceIdentifier) {
        this.img = img;
        this.location = location;
        this.pieceNumber = pieceIdentifier;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

//    public PuzzlePiece(String ImagePath, Location location) {
//        this(ImagePath);
//        this.location = location;
//    }




    public Image getImage() {
        return img;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public PuzzlePiece getClone() {
        PuzzlePiece clone = new PuzzlePiece(img, location, pieceNumber);

        return clone;
    }
}
