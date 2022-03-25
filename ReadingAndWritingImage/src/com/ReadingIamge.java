package com;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import java.util.Base64;

import javax.imageio.ImageIO;



import java.awt.image.BufferedImage;

public class ReadingIamge {
	 static BufferedImage image=null;
	    public ReadingIamge() throws IOException {
	       creteimge();
	    }

	    private void creteimge() throws IOException {

	        writeImage();
	    }

	    private void writeImage() throws IOException {
	        File readimage = new File("C:\\Users\\ASUS\\Desktop\\NewFolder\\testimage1.jpg");
	       // image=new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);
	        image= ImageIO.read(readimage);
	        ByteArrayOutputStream baos=new ByteArrayOutputStream();
	        ImageIO.write(image, "jpg", baos );
	        byte[] imageInByte=baos.toByteArray();
	        String encoded = Base64.getEncoder().encodeToString(imageInByte);
	        System.out.println(encoded);
	       // String str=new String(imageInByte, StandardCharsets.UTF_8);
	     //   System.out.println(str);
	        baos.flush();
	    }

	    public static void main(String[] args) throws IOException {
	    	ReadingIamge app=new ReadingIamge();
	    }

}
