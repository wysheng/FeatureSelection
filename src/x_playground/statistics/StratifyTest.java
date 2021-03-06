package x_playground.statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

import reader.CSVReader;
import wrapper.crossvalidation.KFoldCrossValidation;
import wrapper.crossvalidation.KFoldCrossValidationConfig;
import dataStructures.FeatureData;

public class StratifyTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws DataFormatException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, DataFormatException {
		// TODO Auto-generated method stub
		CSVReader read = new CSVReader(" , ");
		KFoldCrossValidation fold = new KFoldCrossValidation(new KFoldCrossValidationConfig());
		
		FeatureData data = read.read(new FileReader(new File("resources/Amino_Acids.csv")));
		
		@SuppressWarnings("deprecation")
		FeatureData test = fold.stratifySamples(data);
		
		System.out.println(data.toString());
		System.out.println(test.toString());
		
		System.out.println(data.getClasses().length);
	}

}
