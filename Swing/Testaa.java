import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;//������ѡ���Ƥ��
 
public class Testaa extends JFrame {
    public Testaa() {
//         //����д��������ܵ��±߿���javaĬ�ϵı߿�
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
        // ������۵Ĵ���д����Ϳ��Ա�֤�߿�Ҳ����ѡ�õ�Ƥ���� 
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            //��Ĵ���UIManager.setLookAndFeel(....);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Testaa();
    }
}