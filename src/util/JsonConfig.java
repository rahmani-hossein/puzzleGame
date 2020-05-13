package util;

import java.util.ArrayList;

public class JsonConfig {
    private ArrayList<String> imageAddresses;
    private ArrayList<Integer> picsRandomOrder;
    private int missingPiece;
    private int framePerSecond;

    public JsonConfig(){

    }

    public ArrayList<String> getImageAddresses() {
        return imageAddresses;
    }

    public void setImageAddresses(ArrayList<String> imageAddresses) {
        this.imageAddresses = imageAddresses;
    }

    public ArrayList<Integer> getPicsRandomOrder() {
        return picsRandomOrder;
    }

    public void setPicsRandomOrder(ArrayList<Integer> picsRandomOrder) {
        this.picsRandomOrder = picsRandomOrder;
    }

    public int getMissingPiece() {
        return missingPiece;
    }

    public void setMissingPiece(int missingPiece) {
        this.missingPiece = missingPiece;
    }

    public int getFramePerSecond() {
        return framePerSecond;
    }

    public void setFramePerSecond(int framePerSecond) {
        this.framePerSecond = framePerSecond;
    }
}
