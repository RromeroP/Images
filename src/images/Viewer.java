/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class Viewer extends Canvas {

    private final Canvas canvas;
    int rate;
    boolean paused = false;
    boolean stoped = false;
    BufferedImage img;
    BufferedImage img_bw;

    public Viewer(Dimension size, BufferedImage img, BufferedImage img_bw) {
        this.canvas = new Canvas();

        this.img = img;
        this.img_bw = img_bw;

        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);

    }

    public Canvas getCanvas() {
        return this;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    @Override
    public void paint(Graphics g) {
        //Aqui poner lo que iria dentro de un bucle para dibujarse
        g.drawImage(img, 0, 0, null);
        g.drawImage(img_bw, img.getWidth() , 0, null);
    }

    public void run() {
        //Aqui se crea el bucle poniendo repaint como ejecutar paint()
        while (stoped == false) {
            this.repaint();
            try {
                sleep(rate);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
