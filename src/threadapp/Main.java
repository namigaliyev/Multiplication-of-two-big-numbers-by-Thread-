/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadapp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Namig
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, IOException, IOException {
        // TODO code application logic here
        
       Transactions is=new Transactions();
       is.SeriMultiplication();
       is.ParalelMultiplication(4);
       is.Print("Result-Number.txt");
    }
    
}
