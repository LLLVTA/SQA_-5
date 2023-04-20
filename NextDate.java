/**
 * NextDate class
 *
 * @author LVTA
 * @date 2023/4/20
 */
import javax.swing.*;
import java.awt.*;


public class NextDate{
    static JTextField YearInput = new JTextField();
    static JTextField MonthInput = new JTextField();
    static JTextField DayInput = new JTextField();
    static JLabel xoutput = new JLabel();

    public static void main(String[] args) {
        NextDate nextDate = new NextDate();
        nextDate.initUI();
    }

    public void initUI() {
        //设置框体
        JFrame frame = new JFrame();
        frame.setTitle("NextDate");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //设置布局
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        frame.setLayout(flowLayout);

        //年框和输入框
        JLabel labely = new JLabel("year:");
        frame.add(labely);

        Dimension dim1 = new Dimension(300, 30);
        YearInput.setPreferredSize(dim1);
        frame.add(YearInput);

        //月框和输入框
        JLabel labelm = new JLabel("month:");
        frame.add(labelm);

        MonthInput.setPreferredSize(dim1);
        frame.add(MonthInput);

        //日框和输入框
        JLabel labeld = new JLabel("day:");
        frame.add(labeld);

        DayInput.setPreferredSize(dim1);
        frame.add(DayInput);

        //形状框和输出框
        JLabel labelx = new JLabel("NextDate:");
        frame.add(labelx);

        Dimension dim2 = new Dimension(285,30);
        xoutput.setPreferredSize(dim2);
        frame.add(xoutput);

        //判断形状按钮
        JButton button = new JButton();
        button.setText("NextDate");
        button.setSize(100,30);
        frame.add(button);

        //重新输入按钮
        JButton button1 = new JButton();
        button1.setText("Close");
        button1.setSize(100,30);
        frame.add(button1);

        //设置可视
        frame.setVisible(true);

        //NextDate监听器
        NextListener nextListener = new NextListener();
        button.addActionListener(nextListener);

        //Close监听器
        NextListener closeListener = new NextListener();
        button1.addActionListener(closeListener);
    }

}
