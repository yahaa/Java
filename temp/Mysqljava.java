import java.sql.* ;
public class Mysqljava{
    public static void main(String[] arg){
        try{
            Class.forName("com.mysql.jdbc.Driver") ;
            System.out.println("�ɹ�����MySQL��������");
            String u ="jdbc:mysql://115.29.146.79:3306/study";
            Connection conn = DriverManager.getConnection(u,"yahaa","Asd147258") ;
            System.out.println("success...") ;
            Statement sta=conn.createStatement();
           conn.close();
        }catch(Exception e){
            System.out.println("failure!!!") ;
        }
    }
}