package yapay_sinir_aglari;

import java.io.FileNotFoundException;

public class Program2 {

	public static void main(String[] args) throws FileNotFoundException {
		YSA ysa = new YSA(1000,0.00001,0.2);
		ysa.egit();
		System.out.println("0 1 =>"+ysa.test(0, 1));

	}

}
