/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author student
 */
public class LoadImage implements Runnable {
    private String imageURL;
    private String imageDest;
    
    LoadImage() {}
    
    LoadImage(String url, String to) {
        this.imageURL = url;
        this.imageDest = to;
    }

    @Override
    public void run() {
        
        try {
            this.beforeExecute();
            TimeUnit.SECONDS.sleep(20);
            this.getImage(imageURL, imageDest);
            
            this.afterExecute();
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void getImage(String from, String to) throws MalformedURLException, IOException {
        BufferedImage bi;
        File pictureFile = new  File(to);
        
            URL url = new URL(from);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            InputStream inputStream = connection.getInputStream();
            
            bi = ImageIO.read(inputStream);
            ImageIO.write(bi, "jpg", pictureFile);
            
            
        
        
        
    }
    
    
    private void beforeExecute() {
        System.out.println("Load image "+ this.imageURL+ " started.");
    }
    
    private void afterExecute() {
        System.out.println("Load image "+ this.imageURL+ " finish.");
    }
    
    private void errorExecute() {
        System.out.println("We have trubles. ");
    }
    
}
