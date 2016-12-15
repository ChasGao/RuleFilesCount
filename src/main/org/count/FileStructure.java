package main.org.count;

import java.util.HashMap;
import java.util.Map;

public class FileStructure {
	/**
	 * 当前文件路径名称
	 */
	private String currentName;
	
	/**
	 * 是否是文件
	 */
	private boolean isFile = false;
	/**
	 * 是否是目录
	 */
	private boolean isDirectory = false;
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
	public boolean isFile() {
		return isFile;
	}
	public boolean isDirectory() {
		return isDirectory;
	}
	public int getCurrDirRuleFileNums() {
		return currDirRuleFileNums;
	}
	public int getCurrDirRuleNums() {
		return currDirRuleNums;
	}
	public Map<String, FileStructure> getSubFile() {
		return subFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
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
	
	
	
}
