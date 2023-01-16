package yapay_sinir_aglari;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.visrec.ml.data.DataSet;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.TransferFunctionType;

import yapay_sinir_aglari.YSA;


public class YSA {
	private static final File dosya=new File(YSA.class.getResource("Data.txt").getPath());
	
	BackPropagation bp;
	int maxEpoch;
	double minHata;
	
	public YSA(int epoch,double hata, double ogrenmeKatsayisi) {
		this.maxEpoch=epoch;
		this.minHata=hata;
		bp=new BackPropagation();
		bp.setLearningRate(ogrenmeKatsayisi);
		bp.setMaxIterations(epoch);
		bp.setMaxError(minHata);
	}
	
	
	
	public org.neuroph.core.data.DataSet egitimVeriSeti() throws FileNotFoundException {
		Scanner in=new Scanner(dosya);
		org.neuroph.core.data.DataSet egitimDs = new org.neuroph.core.data.DataSet(2, 1);
		while(in.hasNextDouble()) {
			DataSetRow satir= 
					new DataSetRow(new double[] {in.nextDouble(),in.nextDouble()},new double[]
							{in.nextDouble()});
			egitimDs.add(satir);
		}
		return egitimDs;
	}
	
	public void egit() throws FileNotFoundException
	{
		NeuralNetwork<BackPropagation> sinirselAg = 
				new MultiLayerPerceptron(TransferFunctionType.SIGMOID,2,5,1);
		sinirselAg.setLearningRule(bp);
		sinirselAg.learn(egitimVeriSeti());
		sinirselAg.save("ogrenenAg.nnet");
		System.out.println("Eğitim tamamlandı");
	}
	
	
	public double test(double x,double y) {
		NeuralNetwork<BackPropagation> sinirselAg = NeuralNetwork.createFromFile("ogrenenAg.nnet");
		sinirselAg.setInput(x,y);
		sinirselAg.calculate();
		return sinirselAg.getOutput()[0];
		
	}
	
	
}
