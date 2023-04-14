import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriListener implements ActionListener {

    public void actionPerformed(ActionEvent e){
        String brnstr = e.getActionCommand();
        if(brnstr == "判断形状"){
            String la = Triangle.Ainput.getText();
            String lb = Triangle.Binput.getText();
            String lc = Triangle.Cinput.getText();

            //检查输入是否为空
            boolean flag = true;
            if(la.length() <= 0)  flag = false;
            else if(lb.length() <= 0)  flag = false;
            else if(lc.length() <= 0)  flag = false;

            //检查字符串的非法字符
            for(int i = 0; i < la.length(); i++){
                if(i == 0 && la.charAt(0) == '-')  continue;
                if(la.charAt(i) < '0' || la.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }

            for(int i = 0; i < lb.length(); i++){
                if(i == 0 && lb.charAt(0) == '-')  continue;
                if(lb.charAt(i) < '0' || lb.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }

            for(int i = 0; i < lc.length(); i++){
                if(i == 0 && lc.charAt(0) == '-')  continue;
                if(lc.charAt(i) < '0' || lc.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }

            if(flag == false)  JOptionPane.showMessageDialog(null,"参数输入非法");
            else{
                //判断三角形类型
                int ila = Integer.parseInt(la);
                int ilb = Integer.parseInt(lb);
                int ilc = Integer.parseInt(lc);
                System.out.println(ila + " " + ilb + " " + ilc);

                //判断输入参数是否在范围内
                if(ila > 200 || ila < 1 || ilb > 200 || ilb < 1 || ilc > 200 || ilc < 1)  JOptionPane.showMessageDialog(null, "参数输入超限");
                else{
                    if(ila + ilb <= ilc || ila +ilc <= ilb || ilb + ilc <= ila){
                        Triangle.xoutput.setText("不能构成三角形");
                    }
                    else{
                        if(ila == ilb && ila == ilc)  Triangle.xoutput.setText("等边三角形");
                        else if(ila == ilb || ila == ilc || ilb == ilc)  Triangle.xoutput.setText("等腰三角形");
                        else Triangle.xoutput.setText("一般三角形");
                    }
                }
            }
        }
        else{
            //一键清空
            Triangle.Ainput.setText("");
            Triangle.Binput.setText("");
            Triangle.Cinput.setText("");
            Triangle.xoutput.setText("");
        }
    }
}
