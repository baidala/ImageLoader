/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadimage;

import java.util.Scanner;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String url = "http://cityfinder.esy.es/img/1.jpg";
        LoadImage li = null;
        Thread thread = null;
        
        
        for ( int i = 1 ; i < 7; i++ ) {
            li = new LoadImage(String.format("http://cityfinder.esy.es/img/%d.jpg", i), String.format("d:\\workspace\\%d.jpg", i));
            thread = new Thread(li);
            thread.start();
        }
        
        
        
        
        
        
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        
        
        
        
        
        
    }
    
}
