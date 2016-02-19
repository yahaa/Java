package Basic2;
import java.io.*;
public class FileReaderWriter {
	
	public static boolean writeIntoFile(String content, String filePath) { 
		boolean isSuccess=true;
        FileWriter fileWriter = null;  
        try {  
            fileWriter = new FileWriter(filePath,true);  
            fileWriter.write(content);  
            fileWriter.flush();  
        } 
        catch (IOException e) {  
            isSuccess = false;  
            e.printStackTrace();  
        } 
        finally {  
            try {  
               if (fileWriter != null)  
                   fileWriter.close();  
            } 
            catch (IOException e) {  
               e.printStackTrace();  
            }  
        }  
        return isSuccess;  
    }  
}
