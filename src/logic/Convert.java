/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author kedwin
 */
public class Convert {
    
    
    String[] list = {"USD","COP","DOP","ARS","JPY","MXN"};
    
    public Convert(){
            
    }
    
    public String[] getList(){
        return this.list;
    }
    public double conversor(double coin, String desde, String asta)
    {
        double toUSD = 0.0;
        toUSD = everyToUSD(coin, desde);
        if(asta == "USD")
        {
            return toUSD; 
        }
        return USDtoEvery(toUSD, asta);
    }
    
    
    private double everyToUSD(double coin, String code){
        
        switch (code) {
            case "DOP" -> {
                return coin / 56.75;
            } 
            case "JPY" -> {
                return coin / 144.80;
            }
            case "ARS" -> {
                return coin / 287.23;
            }
            case "MXN" -> {
                return coin / 17.04;
            }
            case "COP" -> {
                return coin / 3950.32;
            }
            case "USD" -> {
                return coin;
            }
            default -> throw new ArithmeticException("cagaste");
        }
    }
   
    private double USDtoEvery(double coin, String code){
        
        switch (code) {
            case "DOP" -> {
                return coin * 56.75;
            } 
            case "JPY" -> {
                return coin * 144.80;
            }
            case "ARS" -> {
                return coin * 287.23;
            }
            case "MXN" -> {
                return coin * 17.04;
            }
            case "COP" -> {
                return coin * 3950.32;
            }
            default -> throw new ArithmeticException("cagaste");
        }
    }

    
    
    
    
    
    
    
}
