package HW4Que6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class SaurabhGujare_ImageData {

    private double[] intensity;

    public SaurabhGujare_ImageData() {

    }

    public double[] Image_intensity(BufferedImage image) {

        ArrayList<Double> arrayList = new ArrayList<>();
        int width = image.getWidth();
        int height = image.getHeight();
        //System.out.println("width, height: " + width + ", " + height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                //System.out.println("x,y: " + j + ", " + i);
                int imagePixelColor = image.getRGB(j, i);
                //System.out.println(imagePixelColor);
                int alpha = (imagePixelColor >> 24) & 0xff;
                int red = (imagePixelColor >> 16) & 0xff;
                int green = (imagePixelColor >> 8) & 0xff;
                int blue = (imagePixelColor) & 0xff;
                double intensity = 0.2989 * red + 0.5870 * green * 0.1140 * blue;
                arrayList.add(intensity);
                //System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
                //System.out.println("Intensity: " + intensity[i]);
                //System.out.println("");
            }
        }
        double[] intensityArray = new double[arrayList.size()];
        for(int i=0;i<arrayList.size();i++)
            intensityArray[i] = arrayList.get(i);

        return intensityArray;
    }

    public double[] getIntensity()
    {
        try{
            BufferedImage bufferImage = ImageIO.read(new File("/Users/saurabhgujare/IdeaProjects/ProgrammingStructuresAndAlgo/Homework4/src/HW4Que6/Boston.jpeg"));
            //System.out.println(Image_intensity(bufferImage).length);
            this.intensity = Image_intensity(bufferImage);
        }catch (Exception e){
            System.out.println("Error in fetching image "+e);
            System.exit(0);
        }
        return intensity;
    }
}
