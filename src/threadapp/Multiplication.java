/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadapp;
import static java.lang.Thread.sleep;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author Namig
 */
public class Multiplication implements Runnable{
    private BigInteger FirstNumber;
    private String ReverseSecondNumberValue;
    private int satir;
    private int d=0;
    BigInteger []result;
    
    
    
    public Multiplication(int satir,BigInteger FirstNumber,String ReverseSecondNumberValue,BigInteger []result)
    {
        this.FirstNumber=FirstNumber;
        this.ReverseSecondNumberValue=ReverseSecondNumberValue;
        this.satir=satir;
        this.result=result;
    }

    @Override
    public void run() {

        d=Integer.parseInt(String.valueOf(ReverseSecondNumberValue.charAt(satir)));
        result[satir]=FirstNumber.multiply(BigInteger.valueOf(d));    
        
    }
    
}
