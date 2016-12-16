package main.org.count;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RuleCount {

	public static void main(String[] args) {
		File file = new File("D:/!workspaceMyeclipse2015/RuleEditor");
		HashMap<String, FileStructure> result = new HashMap<String, FileStructure>();
		// count(file, result);
		int i = countDecisionTableRuleNums("D:/MyEclipse2015Workspaces/RuleEditor/doc/车辆用途.dta");
		System.out.println("==="+i);
	}

	/**
	 * @param filePath
	 *            被统计的文件
	 * @param fileStructureMap
	 *            结果
	 */
	public static void count(File filePath,
			HashMap<String, FileStructure> fileStructureMap) {
		if (!filePath.exists()) {
			System.out.println("被统计的file是不存在");
			return;
		}

		// 单个文件
		if (filePath.isFile()) {
			if (filePath.getName().endsWith(Constance.BRL)) {
				FileStructure brlFileStructure = new FileStructure(filePath.getPath(), 1, 1);
				fileStructureMap.put(filePath.getPath(), brlFileStructure);
			} else if (filePath.getName().endsWith(Constance.DECISIONTABLE)) {
				int ruleNums=countDecisionTableRuleNums(filePath.getPath());
				FileStructure dtaFileStructure=new FileStructure(filePath.getPath(), 1, ruleNums);
				fileStructureMap.put(filePath.getPath(), dtaFileStructure);
			}else {
				//完成后删除这个 打印信息。
				System.out.println(filePath.getPath()+"这个文件不是.brl/.dta文件");
			}
		}
		
		//文件夹
		File[] subFiles = filePath.listFiles();
		for(File subFile:subFiles){
			if(subFile.isFile()){
				if (filePath.getName().endsWith(Constance.BRL)) {
					FileStructure brlFileStructure = new FileStructure(filePath.getPath(), 1, 1);
					fileStructureMap.put(filePath.getPath(), brlFileStructure);
				} else if (filePath.getName().endsWith(Constance.DECISIONTABLE)) {
					int ruleNums=countDecisionTableRuleNums(filePath.getPath());
					FileStructure dtaFileStructure=new FileStructure(filePath.getPath(), 1, ruleNums);
					fileStructureMap.put(filePath.getPath(), dtaFileStructure);
				}else {
					//完成后删除这个 打印信息。
					System.out.println(filePath.getPath()+"这个文件不是.brl/.dta文件");
				}
			}else if (subFile.isDirectory()) {
				
				count(subFile, fileStructureMap);
				
			}
			
		}
		
		
	}
/**
 * 统计一个决策表的规则数量。<br>
 * 决策表的操作列如果是空白的话，这行规则就忽略不计。因为没有意义！
 * @param path 决策表在文件夹中的名称，如，车辆用途.dta
 * @return
 */
	public static int countDecisionTableRuleNums(String path) {
		int count=0;
		// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document document = null;
		try {
			// step 2:获得具体的dom解析器
			db = dbf.newDocumentBuilder();
			// step3: 解析一个xml文档，获得Document对象（根结点）
			document = db.parse(new File(path));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 *  <ActionSet>
            <Action DefId="A0">
              <Expression>
                <Param><![CDATA[党政机关]]></Param>
              </Expression>
            </Action>
          </ActionSet>
          *空白的操作列没有<Param>元素，
          *操作列空白的规则没有意义，忽略不计
		 */
		NodeList actionSetElemens = document.getElementsByTagName("ActionSet");
		for (int i = 0; i < actionSetElemens.getLength(); i++) {
			Element actionSetElemen = (Element) actionSetElemens.item(i);
			NodeList paramElements=	actionSetElemen.getElementsByTagName("Param");
				if(paramElements.getLength()>0){
					String content =paramElements.item(0).getFirstChild().getTextContent();
					System.out.println(content);
					count=count+1;
					System.out.println("---"+count);
				}
		}
		return count;
	}

}
