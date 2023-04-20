/**
 * Triangle class
 *
 * @author LVTA
 * @date 2023/4/20
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triangle{
    /**
     *
     * 三个输入框
     *
     */
    static JTextField Ainput = new JTextField();
    static JTextField Binput = new JTextField();
    static JTextField Cinput = new JTextField();
    static JLabel xoutput = new JLabel();

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.initUI();
    }

    public void initUI() {
        //设置框体
        JFrame frame = new JFrame();
        frame.setTitle("判断三角形");
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //设置布局
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        frame.setLayout(flowLayout);

        //提示框
        JLabel labelt = new JLabel("请输入三个1-200的整数:");
        labelt.setPreferredSize(new Dimension(330,30));
        frame.add(labelt);

        //A框和输入框
        JLabel labela = new JLabel("A:");
        frame.add(labela);

        Dimension dim1 = new Dimension(300, 30);
        Ainput.setPreferredSize(dim1);
        frame.add(Ainput);

        //B框和输入框
        JLabel labelb = new JLabel("B:");
        frame.add(labelb);

        Binput.setPreferredSize(dim1);
        frame.add(Binput);

        //C框和输入框
        JLabel labelc = new JLabel("C:");
        frame.add(labelc);

        Cinput.setPreferredSize(dim1);
        frame.add(Cinput);

        //形状框和输出框
        JLabel labelx = new JLabel("形状:");
        frame.add(labelx);

        Dimension dim2 = new Dimension(285,30);
        xoutput.setPreferredSize(dim2);
        frame.add(xoutput);

        //判断形状按钮
        JButton button = new JButton();
        button.setText("判断形状");
        button.setSize(100,30);
        frame.add(button);

        //重新输入按钮
        JButton button1 = new JButton();
        button1.setText("重新输入");
        button1.setSize(100,30);
        frame.add(button1);

        //设置可视
        frame.setVisible(true);
        System.out.println(Ainput.getText());
        //判断形状监听器
        TriListener triListener = new TriListener();
        button.addActionListener(triListener);

        //重新输入监听器
        TriListener triListener1 = new TriListener();
        button1.addActionListener(triListener1);

    }
}
