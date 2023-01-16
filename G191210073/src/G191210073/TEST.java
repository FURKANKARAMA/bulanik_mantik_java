package G191210073;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import java.util.Random;


import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class TEST {

	public static void main(String[] args) throws URISyntaxException {
		
		for(int i=0;i<1;i++) {
			try {
				FileWriter dosyaYazıcı = new FileWriter("C:\\Users\\mavii\\OneDrive\\Documents\\yapay_sinir_aglari\\Data.txt");
				BufferedWriter dosyaOutput = new BufferedWriter(dosyaYazıcı);
				Scanner in = new Scanner(System.in);
				for(int j=0;j<4000;j++) {	
					Random c=new Random(); //random 
					 int a=c.nextInt(101);
				System.out.print("Oksijen Miktari");
				double oksijenMiktari=a;
				int sayi1=(int)oksijenMiktari;
				String oksijen =String.valueOf(sayi1);
				dosyaOutput.write(oksijen);
				dosyaOutput.write(" ");
				
				Random e=new Random(); //random 
				 int b=e.nextInt(101);
				 
				System.out.print("Yagis Miktari");
				double havaninYagisDurumu=b;
				int sayi2=(int)havaninYagisDurumu;
				String yagis =String.valueOf(sayi2);
				dosyaOutput.write(yagis );
				dosyaOutput.write(" ");
				
				camAcikligi camAcikligi = new camAcikligi(oksijenMiktari,havaninYagisDurumu);
				
				for(Rule r : camAcikligi.getModel().getFunctionBlock("CamAciklikOraniModel").getFuzzyRuleBlock("kuralblok1").getRules()) {
					if(r.getDegreeOfSupport()>0) {
						System.out.println(r);
					}
				}
				System.out.println(camAcikligi);
				String aciklik =String.valueOf(camAcikligi);
				dosyaOutput.write(aciklik);
				dosyaOutput.newLine();
				}
				
			
				dosyaOutput.close();
				dosyaYazıcı.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
	

	}
}
