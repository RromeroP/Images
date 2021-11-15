/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 *
 * @author dam
 */
public class Gray {

    BufferedImage img;
    byte[] buffer;

    public Gray(BufferedImage img) {
        this.img = img;
        this.buffer = ((DataBufferByte) this.img.getRaster().getDataBuffer()).getData();
    }

    public void makeGray() {
        
        //Si quisieramos podriamos cambiar el brillo de la imagen
        int brigthness = 0;
        
        final int pixelLength = 3;
        for (int pixel = 0; pixel < this.buffer.length - pixelLength; pixel += pixelLength) {

            int b = this.buffer[pixel + 0] & 0xff; // blue
            int g = this.buffer[pixel + 1] & 0xff; // green
            int r = this.buffer[pixel + 2] & 0xff; // red

            int avg = (b + g + r) / 3;

            //Al cambiar el brillo hay que evitar numeros menores que 0
            //o mayores que 255, para esos usamos el normalize
            avg = normalize(avg + brigthness);
            
            this.buffer[pixel + 0] = (byte) avg; // blue
            this.buffer[pixel + 1] = (byte) avg; // green
            this.buffer[pixel + 2] = (byte) avg; // red

        }
    }

    private static int normalize(int total) {

        if (total < 0) {
            total = 0;
        } else if (total > 255) {
            total = 255;
        }

        return total;
    }
}
