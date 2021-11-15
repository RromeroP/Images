/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author dam
 */
public class Images {

    /**
     * @param args the command line arguments
     */
    private static JFrame frame;
    private static final String TITLE = "My Fire";
    private static Dimension SIZE;

    //Para pruebas
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(new File("src\\img\\bg.png"));
        BufferedImage img_bw = ImageIO.read(new File("src\\img\\bg.png"));

        SIZE = new Dimension(img.getWidth() * 2, img.getHeight());

        // TODO code application logic here
        frame = new JFrame(TITLE);

        frame.setPreferredSize(SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Gray new_img = new Gray(img_bw);
        new_img.makeGray();
        
        Viewer viewer = new Viewer(SIZE, img, img_bw);
        viewer.setRate(50);

        frame.add(viewer.getCanvas());

        frame.pack();
        frame.setVisible(true);

    }

}
