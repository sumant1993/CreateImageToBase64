package com;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class ImageClassTest extends JPanel{

    public void paint(Graphics g) {
        Image img = createImageWithText();
        g.drawImage(img, 20,20,this);
    }

    private Image createImageWithText() {
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

       g.drawString("test",200,200);
        return bufferedImage;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new ImageClassTest());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

}
