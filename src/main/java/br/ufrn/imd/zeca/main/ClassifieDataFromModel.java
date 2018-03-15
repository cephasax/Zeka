package br.ufrn.imd.zeca.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import br.ufrn.imd.zeca.file.FileManager;
import br.ufrn.imd.zeca.file.FileOutputWriter;
import weka.classifiers.Classifier;
import weka.core.Instances;

public class ClassifieDataFromModel {

	private static String fileChooserUrl;
	private static FileManager fileManager;
	private static ArrayList<File> dataBases;
	private static Classifier cls;
	
	public static void main(String[] args) throws Exception {
		fileChooserUrl = new String("C:\\Users\\cephas\\Documents\\Workspace\\iaWork\\Zeka\\resources");
		fileManager = new FileManager(fileChooserUrl);
		String prediction = new String();
		
		//choose and load the ML model
		chooseAndLoadModel();
		
		//choose Database to apply model
		chooseDataBases();
		
		//do prediction for each dataBase on array based on model
		for(int i = 0; i < dataBases.size();i++) {
			FileOutputWriter fow = new FileOutputWriter(dataBases.get(i).getName());
			Instances instances = buildInstancesFromDataBase(dataBases.get(i));
			
			//classify each instance from database
			for(int j = 0; j <instances.size(); j++) {
				
				double value = cls.classifyInstance(instances.get(j));
				
				//get the name of the class value
				prediction = new String(instances.classAttribute().value((int)value));
				
				fow.addContentline((Integer.toString(j) + ": " + prediction + "\n"));				
			}
			fow.writeAndSaveFile();
		}
	}
	
	/*
	 * Method to choose the Machine Learning model already saved under .model
	 */
	public static void chooseAndLoadModel() throws Exception {
		//choose and load model
		cls = (Classifier) weka.core.SerializationHelper.read(fileManager.getnameFromFile("Choose the .model file"));
	}
	
	/*
	 * make sure that the databases have the EXACT same 
	 * format as the database used to build the model
	 */
	public static void chooseDataBases() {
		dataBases = new ArrayList<File>();
		dataBases = fileManager.openOneOrMany("Choose the arff file(s)");
	}
	
	public static Instances buildInstancesFromDataBase(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Instances data = new Instances(reader);
		data.setClassIndex(data.numAttributes() - 1);
		reader.close();
		
		return data;
	}

	
}
