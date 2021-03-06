package br.ufrn.imd.zeca.main;

import java.io.File;
import java.util.ArrayList;

import br.ufrn.imd.zeca.accuracyExtractor.domain.ResultCrossValidation;
import br.ufrn.imd.zeca.accuracyExtractor.domain.ResultExtractor;
import br.ufrn.imd.zeca.accuracyExtractor.domain.ResultFromMethod;
import br.ufrn.imd.zeca.accuracyExtractor.domain.ResultTrainingSet;
import br.ufrn.imd.zeca.file.FileManager;
import br.ufrn.imd.zeca.file.FileOutputWriterCatchAccuracy;

public class CatchAccuracies {

	public static ArrayList<File> files;
	public static FileManager fileManager = new FileManager("C:\\Users\\cephas\\Google Drive\\Pessoal\\Mestrado\\Dissertacao\\dados\\experimento_perfil\\bases\\modificadas\\final_exp\\step3 - classific\\xuxu\\");
	public static ResultExtractor resultExtractor;
	
	
	public static ArrayList<ResultFromMethod> results = new ArrayList<ResultFromMethod>();
	
	
	public static void main(String[] args) throws Exception {

		files = fileManager.openOneOrMany("Choose files with accuracy from classification methods");

		for (File file : files) {
			if((file.getName().contains("Cross") || (file.getName().contains("cross")))) {
				resultExtractor = new ResultCrossValidation();
			}
			else {
				resultExtractor = new ResultTrainingSet();
			}
			results.addAll(resultExtractor.extractResult(file));
			resultExtractor = null;
			System.out.println(file.getName());
		}
		
		FileOutputWriterCatchAccuracy fowca= new FileOutputWriterCatchAccuracy("Catch Accuracies result");
		fowca.writeFile(results);
	}
}
