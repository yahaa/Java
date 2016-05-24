import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;//这是我选择的皮肤
 
public class Testaa extends JFrame {
    public Testaa() {
//         //代码写在这里可能导致边框还是java默认的边框
//         try {
//             BeautyEyeLNFHelper.launchBeautyEyeLNF();
//         } catch (Exception e) {
//                 e.printStackTrace();
//         }
        this.add(new JPanel());
        this.add(new JButton("FDSAS"), BorderLayout.NORTH);
        this.setBounds(0, 0, 500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
        // 设置外观的代码写在这就可以保证边框也是你选用的皮肤包 
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            //你的代码UIManager.setLookAndFeel(....);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Testaa();
    }
}