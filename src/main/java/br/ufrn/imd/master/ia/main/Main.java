package br.ufrn.imd.master.ia.main;

import java.io.File;
import java.util.ArrayList;

import br.ufrn.imd.master.ia.domain.ResultFromMethod;
import br.ufrn.imd.master.ia.fileManipulation.FileManager;
import br.ufrn.imd.master.ia.fileManipulation.FileOutputWriter;
import br.ufrn.imd.master.ia.resultExtractors.ResultCrossValidation;
import br.ufrn.imd.master.ia.resultExtractors.ResultExtractor;
import br.ufrn.imd.master.ia.resultExtractors.ResultTrainingSet;

public class Main {

	public static File[] files;
	public static FileManager fileManager = new FileManager("C:\\Users\\cephas\\Google Drive\\Pessoal\\Mestrado\\Dissertacao\\dados\\experimento_perfil\\bases\\modificadas\\final_exp\\step3 - classific\\xuxu\\");
	public static ResultExtractor resultExtractor;
	
	
	public static ArrayList<ResultFromMethod> results = new ArrayList<ResultFromMethod>();
	
	
	public static void main(String[] args) throws Exception {

		files = fileManager.selecionarArquivos();

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
		
		FileOutputWriter fileOutputWriter= new FileOutputWriter();
		fileOutputWriter.writeFile(results);
	}
}
