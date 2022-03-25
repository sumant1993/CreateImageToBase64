package com;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class App {

    static BufferedImage image=null;
    public App() throws IOException {
       creteimge();
    }

    private void creteimge() throws IOException {

        convertimagetobase64();
        convertbase64toimage(convertimagetobase64());
    }

    private void convertbase64toimage(String s) throws IOException {
        File file=new File("output.png");
        byte[] image = Base64.getDecoder().decode(s);
        ByteArrayInputStream bis = new ByteArrayInputStream(image);
        BufferedImage bImage = ImageIO.read(bis);
        ImageIO.write(bImage, "png", file);
        System.out.println(file.getAbsolutePath());
    }

    private String convertimagetobase64() throws IOException {
        File readimage = new File("C:\\Users\\ASUS\\Desktop\\NewFolder\\testimage1.jpg");
       // image=new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
        image= ImageIO.read(readimage);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos );

        byte[] imageInByte=baos.toByteArray();

        String encoded = Base64.getEncoder().encodeToString(imageInByte);



        baos.flush();

        return encoded;
    }

    public static void main(String[] args) throws IOException {
    App app=new App();
    }
}
