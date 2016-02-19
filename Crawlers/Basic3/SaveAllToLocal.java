package Basic3;
import java.util.*;
import Basic2.FileReaderWriter;
import Basic2.Spider;
import Basic2.Zhihu;
import java.io.*;
public class SaveAllToLocal {
	
	public static void getAll(String fileName){
			String content=getWebCode(fileName);
			ArrayList<Zhihu>list=Spider.getZhihu(content);
			for(Zhihu zhihu:list){
				FileReaderWriter.writeIntoFile(zhihu.writeString(), "ans___3.txt");
			}
	}
	
	private static LinkedList<String> traverseFolder1(String path){
		LinkedList<String>result=new LinkedList<>();
        File file = new File(path);
        if (file.exists()){
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files){
                if (file2.isDirectory()){
                    list.add(file2);
                } 
                else{
                	String address=file2.getAbsolutePath();
                	address=address.replaceAll("/", "//");
                    result.add(address);
                }
            }
            File temp_file;
            while (!list.isEmpty()){
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files){
                    if (file2.isDirectory()){
                        list.add(file2);
                    } 
                    else{
                    	String address=file2.getAbsolutePath();
                    	address=address.replaceAll("/", "//");
                        result.add(address);
                    }
                }
            }
        }
        return result;

    }
	
	
	static String getWebCode(String fileName){
		String result=null;
		try{
			Scanner input=new Scanner(new FileReader(fileName));
			while(input.hasNext()){
				result+=input.nextLine();
			}
		}
		catch(Exception e){
			System.out.println("文件不存在");
		}
		return result;
	}

}
