package main.org.count;

import java.io.File;
import java.util.HashMap;

public class RuleCount {

	public static void main(String [] args){
		File file=new File("D:/!workspaceMyeclipse2015/RuleEditor");
		HashMap<String, FileStructure> result=new HashMap<String, FileStructure>();
		count(file, result);
	}
	
	public static void count(File filePath, HashMap<String, FileStructure> fileStructureMap ){
		if(!filePath.exists()){
			System.out.println("被统计的file是不存在");
			return;
		}
		
		FileStructure fileStructure=new FileStructure();
		
		
	}
	
	
}
