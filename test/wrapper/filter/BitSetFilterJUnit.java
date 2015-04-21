package wrapper.filter;

import static org.junit.Assert.assertArrayEquals;

import java.util.BitSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataStructures.FeatureData;

public class BitSetFilterJUnit {
	
	BitSet bitSet = new BitSet();
	
	FeatureData featureData;
	static String[] features = {"Feature1", "Feature2", "Feature3"};
	static String[] samples = {"1", "2", "3", "Hans Wurst", "5"};
	static boolean[] classes = {true, true, false, true, false};
	static double[][] values = {{ 1.0,  2.0,   3.0},
								{-1.0, -2.0,  -3.0},
								{-0.5, -2.3,   4.0},
								{-0.0,  0.0,   0},
								{ 0.45, 0.342, 0.09}};
	FeatureData testFeatureData;
	static String[] testFeatures = {"Feature1", "Feature3"};
	static String[] testSamples = {"1", "2", "3", "Hans Wurst", "5"};
	static boolean[] testClasses = {true, true, false, true, false};
	static double[][] testValues = {{ 1.0, 3.0},
								{-1.0, -3.0},
								{-0.5, 4.0},
								{-0.0, 0},
								{ 0.45, 0.09}};

	FeatureData resFeatureData;
	FilterBase bitSetFilter;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bitSet.set(0);
		bitSet.set(2);
		featureData = new FeatureData(features, samples, classes, values);
		testFeatureData = new FeatureData(testFeatures, testSamples, testClasses, testValues);
		bitSetFilter = new BitSetFilter(featureData);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectSubset() {
		resFeatureData = bitSetFilter.selectSubset(bitSet);
		assertArrayEquals(testFeatureData.getFeatures(), resFeatureData.getFeatures());
		assertArrayEquals(testFeatureData.getSamples(), resFeatureData.getSamples());
		assertArrayEquals(testFeatureData.getValues(), resFeatureData.getValues());
		
	}

}
