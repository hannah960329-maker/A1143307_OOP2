import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ch17_1{
    static JFrame frm=new JFrame("骰子模擬器");
    static JLabel lab=new JLabel("-", JLabel.CENTER);
    static JPanel pne=new JPanel();
    static JButton btn=new JButton("擲骰子");
    static int count =0;
    static int sum = 0;
    static JLabel statusLab = new JLabel("已擲 0 次，總和 0，平均 0.00", JLabel.CENTER);
    public static void main(String arg[]){
        frm.setSize(400,320);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        lab.setFont(new Font("SansSerif", Font.BOLD, 60));
        frm.setLayout(new BorderLayout());
        frm.add(statusLab, BorderLayout.NORTH); 
        frm.add(lab, BorderLayout.CENTER);      
        pne.add(btn);
        frm.add(pne, BorderLayout.SOUTH);       
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dice = (int)(Math.random() * 6) + 1;
                count++;
                sum += dice;
                double avg = (double) sum / count;
                statusLab.setText(String.format("已擲 %d 次，總和 %d，平均 %.2f", count, sum, avg));
                lab.setText(String.valueOf(dice));
                if (dice == 6) {
                    lab.setForeground(Color.GREEN);
                } else if (dice == 1) {
                    lab.setForeground(Color.RED);
                } else {
                    lab.setForeground(Color.BLACK);
                }
            }
        });
        frm.setVisible(true);
    }
}