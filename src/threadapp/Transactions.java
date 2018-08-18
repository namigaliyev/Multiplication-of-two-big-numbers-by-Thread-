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
public class Transactions {
        BigInteger FirstNumber=new BigInteger("1112261462142561491875171631243265456145691236414651541634521346351414561414651"
                + "98563245697219567123765942319456129756124659142194561297562134659127659142197623619451267516"
                + "8879811795164231323214361461456149561957651713641451459156414659172314631641445614326134651564"
                + "981897176123423124614561698491846514651465146514621436216234657989179195675142312342314619796167514661436123432136246514566514651"
                + "81719879176512342312461465195849816713242313246145614951899751624231324316451456145614");
        
        
        BigInteger SeriResult=BigInteger.ZERO;
        BigInteger ParalelResult=BigInteger.ZERO;
        
        double SeriTime=0;
        double ParalelTime=0;
        
        BigInteger SecondNumber = new BigInteger("2346136414561987197162342312646519841522176514619455145616421456146145614564"
                + "881897198765146321243214651495619848914136415641564651456456141894981456214263146516461465"
                + "787197917651423132423125645614561541597951945614132643213242312461465145146519716123646"
                + "8491546166167619491461641649198576231421356456149514231234149515421645196841641"
                + "91545914561423123423164651756591719845614621236426145665145695195416713246164616");
        
        //Ikinci Sayini carpim icin ters ceviriyoruz |reverse()| methodu ile
        String ReverseSecondNumberValue =new StringBuffer(SecondNumber.toString()).reverse().toString();
        
        int uzunluk=ReverseSecondNumberValue.length();
        
        
        //////////////////////////////
        //SERI
        
        public void SeriMultiplication()
        {
            BigInteger []result=new BigInteger[uzunluk];
            ExecutorService havuz=Executors.newFixedThreadPool(1);
            long start=System.nanoTime();
            for(int satir=0;satir<ReverseSecondNumberValue.length();satir++)
            {
                havuz.execute(new Multiplication(satir,FirstNumber,ReverseSecondNumberValue,result));
            
            }
        
            havuz.shutdown();
    
            while(!havuz.isTerminated()){}
            long final_l=System.nanoTime();
            SeriTime=(final_l-start)/1000000.0;
            for(int f=0;f<ReverseSecondNumberValue.length();f++)
            {
                SeriResult=SeriResult.add(result[f]);
            }
        
        }
        
        /////////////////////////////////
        //PARALEL
        
        public void ParalelMultiplication(int thread)
        {
            BigInteger []result=new BigInteger[uzunluk];
            ExecutorService havuz=Executors.newFixedThreadPool(thread);
            long start=System.nanoTime();
            for(int satir=0;satir<ReverseSecondNumberValue.length();satir++)
            {
                havuz.execute(new Multiplication(satir,FirstNumber,ReverseSecondNumberValue,result));
            
            }
        
            havuz.shutdown();
    
            while(!havuz.isTerminated()){}
        
            long final_l=System.nanoTime();
            ParalelTime=(final_l-start)/1000000.0;
            for(int k=0;k<uzunluk;k++)
            {
                ParalelResult=ParalelResult.add(result[k]);
            }
        
        }
        
        

        public void Print(String yol) throws IOException
        {
            String sas=ParalelResult.toString();

            System.out.println("Seri Calculation Time "+String.format("%.2f",SeriTime)+" milisaniye");

            System.out.println("Paralel Calculation Time "+String.format("%.2f",ParalelTime)+" milisaniye");
            System.out.println("Result saved to File");
            //System.out.println(sas);
        


            File file = new File(yol);
            if (!file.exists()) {
                file.createNewFile();
            }
        

            FileWriter fileWriter = new FileWriter(file, false);
            try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {
                bWriter.write(sas);
            }
        }

}
