package userInterface;

import control.Mapper;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    public MyKeyListener(){

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {


        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            Mapper.getInstance().executeRequest(Mapper.Request.SWAP_RIGHT);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            Mapper.getInstance().executeRequest(Mapper.Request.SWAP_LEFT);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            Mapper.getInstance().executeRequest(Mapper.Request.SWAP_UP);
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            Mapper.getInstance().executeRequest(Mapper.Request.SWAP_DOWN);
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

