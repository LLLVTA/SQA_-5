/**
 * NextListener class
 *
 * @author LVTA
 * @date 2023/4/20
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextListener implements ActionListener{
    /**
     *
     *isLeapYear主要用于判断平闰年
     *
     */
    public int isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String brnstr = e.getActionCommand();
        if(brnstr == "NextDate"){
            String ly = NextDate.YearInput.getText();
            String lm = NextDate.MonthInput.getText();
            String ld = NextDate.DayInput.getText();

            //检查是否为空
            boolean flag = true;
            if(ly.length() <= 0) {
                flag = false;
            } else if(lm.length() <= 0) {
                flag = false;
            } else if(ld.length() <= 0) {
                flag = false;
            }

            //检查非法字符
            for(int i = 0; i < ly.length(); i++){
                if(i == 0 && ly.charAt(0) == '-') {
                    continue;
                }
                if(ly.charAt(i) < '0' || ly.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }
            for(int i = 0; i < lm.length(); i++){
                if(i == 0 && lm.charAt(0) == '-') {
                    continue;
                }
                if(lm.charAt(i) < '0' || lm.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }

            for(int i = 0; i < ld.length(); i++){
                if(i == 0 && ld.charAt(0) == '-') {
                    continue;
                }
                if(ld.charAt(i) < '0' || ld.charAt(i) > '9'){
                    flag = false;
                    break;
                }
            }

            if(flag == false) {
                JOptionPane.showMessageDialog(null,"参数输入非法");
            } else{
                //判断类型
                int ily = Integer.parseInt(ly);
                int ilm = Integer.parseInt(lm);
                int ild = Integer.parseInt(ld);
                System.out.println(ily + " " + ilm + " " + ild);
                if(ily < 1 || ilm < 1 || ild < 1) {
                    JOptionPane.showMessageDialog(null, "参数输入超限");
                } else{
                    int [][] date = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
                    int c1 = ily, c2 = ilm, c3 = ild;
                    int ru = isLeapYear(c1);
                    if(c3 > date[ru][c2]) {
                        NextDate.xoutput.setText("不可能");
                    } else{
                        c3++;
                        if(c3 > date[ru][c2]){
                            c3 = 1;
                            c2++;
                        }
                        if(c2 > 12){
                            c2 = 1;
                            c1++;
                        }
                        NextDate.xoutput.setText(c1 + "/" + c2 + "/" + c3);
                    }
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}
