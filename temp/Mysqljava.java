import java.sql.* ;
public class Mysqljava{
    public static void main(String[] arg){
        try{
            Class.forName("com.mysql.jdbc.Driver") ;
            String url ="jdbc:mysql://localhost/Crawler" ;
            Connection conn = DriverManager.getConnection(url,"yuanc","Asd147258") ;
            System.out.println("success...") ;
            Statement sta=conn.createStatement();
//            ResultSet re=sta.executeQuery("select * Student where pass=123456");
//           while(re.next()){
//        	   System.out.println(re.getString(1)+"\t"+re.getString(2));
//           }
           conn.close();
        }catch(Exception e){
            System.out.println("failure!!!") ;
        }
    }
}