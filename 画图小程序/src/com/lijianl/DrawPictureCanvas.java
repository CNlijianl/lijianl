package com.lijianl;

import java.awt.*;

public class DrawPictureCanvas extends Canvas {

    private Image image = null;


    public void setImage(Image image){
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
