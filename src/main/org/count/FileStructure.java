package main.org.count;

import java.util.HashMap;
import java.util.Map;

public class FileStructure {
	/**
	 * 当前文件路径名称
	 */
	private String currentName;
	/**
	 * 当前目录下规则文件的数量
	 */
	private int currDirRuleFileNums = 0;
	/**
	 * 当前目录下规则的数量
	 */
	private int currDirRuleNums = 0;
	/**
	 * 子文件
	 */
	private Map<String ,FileStructure> subFile=new HashMap<String ,FileStructure>();
 	public int getCurrDirRuleFileNums() {
		return currDirRuleFileNums;
	}
	public int getCurrDirRuleNums() {
		return currDirRuleNums;
	}
	public Map<String, FileStructure> getSubFile() {
		return subFile;
	}
	public void setCurrDirRuleFileNums(int currDirRuleFileNums) {
		this.currDirRuleFileNums = currDirRuleFileNums;
	}
	public void setCurrDirRuleNums(int currDirRuleNums) {
		this.currDirRuleNums = currDirRuleNums;
	}
	public void setSubFile(Map<String, FileStructure> subFile) {
		this.subFile = subFile;
	}
	public String getCurrentName() {
		return currentName;
	}
	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}
	
	public FileStructure() {
	}
	public FileStructure(String currentName, int currDirRuleFileNums,
			int currDirRuleNums) {
		this.currentName = currentName;
		this.currDirRuleFileNums = currDirRuleFileNums;
		this.currDirRuleNums = currDirRuleNums;
	}
	public FileStructure(String currentName, int currDirRuleFileNums,
			int currDirRuleNums, Map<String, FileStructure> subFile) {
		this.currentName = currentName;
		this.currDirRuleFileNums = currDirRuleFileNums;
		this.currDirRuleNums = currDirRuleNums;
		this.subFile = subFile;
	}
	
	public void print(FileStructure fileStructure){
		int totalRuleNums=0;
		for(Map.Entry<String, FileStructure> entry:this.getSubFile().entrySet()){
			String filePath=entry.getKey();
			FileStructure fileStructure2=entry.getValue();
			System.out.println(filePath+"规则数量是："+fileStructure2.getCurrDirRuleNums());
			totalRuleNums=totalRuleNums+fileStructure2.getCurrDirRuleNums();
		}
		
	}
	
}
