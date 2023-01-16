package G191210073;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class camAcikligi {
	private FIS fis;
	private double oksijenMiktari;
	private double havaninYagisDurumu;
	
	public camAcikligi(double oksijenMiktari,double havaninYagisDurumu) throws URISyntaxException {
		this.oksijenMiktari=oksijenMiktari;
		this.havaninYagisDurumu=havaninYagisDurumu;
		
		
		File dosya = new File(getClass().getResource("CamAciklikOraniModel.fcl").toURI());
		fis=FIS.load(dosya.getPath());
		fis.setVariable("oksijenMiktari", oksijenMiktari);
		fis.setVariable("havaninYagisDurumu", havaninYagisDurumu);
		fis.evaluate();
	}
	public FIS getModel() { 
		return fis;
	}
	@Override
	public String toString() {
		String cikti;
		cikti=Math.round(fis.getVariable("pencereAcikligi").getValue())+"";
		return cikti;
	};
	
}
