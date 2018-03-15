package br.ufrn.imd.zeca.accuracyExtractor.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface ResultExtractor {

	public ArrayList<ResultFromMethod> extractResult(File file) throws FileNotFoundException, IOException;
	
}
