package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class SmoothFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class SmoothFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {

//        int red = constrain(Color.red(inPixel) + ADJUSTMENT);
//        int green = constrain(Color.green(inPixel) + ADJUSTMENT);
//        int blue = constrain(Color.blue(inPixel) + ADJUSTMENT);
//        int outPixel = Color.argb(Color.alpha(inPixel), red, green, blue);

        int current[] = {p0, p1, p2, p3, p4, p5, p6, p7, p8};
        int outPixelR = 0, outPixelG = 0, outPixelB = 0;

        int[] currentR = new int[current.length];
        int[] currentG = new int[current.length];
        int[] currentB = new int[current.length];


        //separate RGB
        for (int i = 0; i < current.length; i++) {
            currentR[i] = constrain(Color.red(current[i]));
            currentG[i] = constrain(Color.green(current[i]));
            currentB[i] = constrain(Color.blue(current[i]));
        }

        //sum
        for (int i = 0; i <  current.length; i++) {

            outPixelR += currentR[i];
            outPixelG += currentG[i];
            outPixelB += currentB[i];

        }

        //divide for average
        outPixelG /= 9;
        outPixelR /= 9;
        outPixelB /= 9;




        int outPixel = Color.argb(Color.alpha(p4), outPixelR, outPixelG, outPixelB);


        return outPixel;
    }


}
