package ticket;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import choose_seat_charge.ChooseSeatMain;
import variable.Variable;


public class TrainMain  {
	public static void main(String[] args) {
		Variable va = new Variable();
		//������ ����
		Frame f = new Frame("������ ����");
		f.setSize(650, 880);
		f.setLocation(700, 100);
		f.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 30);
		
		// �����
		Label startLb = new Label("���  : ");
		startLb.setBounds(50,150,100,75);
		startLb.setFont(font);
		f.add(startLb);
		String start[] = {"���￪", "������", "������", "�λ꿪"};
		JComboBox<String> startCombo = new JComboBox<String>(start);
		startCombo.setBounds(150,175,150,30);
		f.add(startCombo);
		
		// ������
		Label arriveLb = new Label("���� : ");
		arriveLb.setBounds(350,150,100,75);
		arriveLb.setFont(font);
		f.add(arriveLb);
		String arrive[] = {"���￪", "������", "������", "�λ꿪"};
		JComboBox<String> arriveCombo = new JComboBox<String>(arrive);
		arriveCombo.setBounds(450,175,150,30);
		f.add(arriveCombo);
		
		// ��¥
		Label dateLb = new Label("�����");
		dateLb.setBounds(275,250,100,75);
		dateLb.setFont(font);
		f.add(dateLb);
		String date[] = {"2022�� 9�� 19�� (��)", "2022�� 9�� 20�� (ȭ)","2022�� 9�� 21�� (��)","2022�� 9�� 22�� (��)","2022�� 9�� 23�� (��)"};
		JComboBox<String> dateCombo = new JComboBox<String>(date);
		dateCombo.setBounds(150,350,150,30);
		f.add(dateCombo);
		String time[] = {"09:00", "12:00","15:00","18:00","21:00"};
		JComboBox<String> timeCombo = new JComboBox<String>(time);
		timeCombo.setBounds(350,350,150,30);
		f.add(timeCombo);
		
		// ���� �� �¼���
		Label humanLb = new Label("�°� ���� �� �¼���");
		humanLb.setBounds(190,400,300,75);
		humanLb.setFont(font);
		f.add(humanLb);
		Label adultLb = new Label("� : ");
		adultLb.setBounds(150,500,150,30);
		f.add(adultLb);
		Label childLb = new Label("û�ҳ� : ");
		childLb.setBounds(150,550,150,30);
		f.add(childLb);
		JComboBox<Integer> numCombo1 = new JComboBox<Integer>();
		numCombo1.setBounds(350,500,150,30);
		f.add(numCombo1);
		numCombo1.addItem(0);
		numCombo1.addItem(1);
		numCombo1.addItem(2);
		numCombo1.addItem(3);
		numCombo1.addItem(4);
		numCombo1.setSelectedIndex(1);
		JComboBox<Integer> numCombo2 = new JComboBox<Integer>();
		numCombo2.setBounds(350,550,150,30);
		f.add(numCombo2);
		numCombo2.addItem(0);
		numCombo2.addItem(1);
		numCombo2.addItem(2);
		numCombo2.addItem(3);
		numCombo2.addItem(4);
		numCombo2.setSelectedIndex(1);
		
		// ��ȸ ��ư
		Button btn_inquiry = new Button("���� ��ȸ�ϱ�");
		btn_inquiry.setBounds(275, 700, 100, 50);
		f.add(btn_inquiry);
		
		// ��ȸ �Ϸ��
		btn_inquiry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startCombo.getSelectedItem().equals(arriveCombo.getSelectedItem())) {
					JOptionPane.showMessageDialog(null, "���� ������ ���� �� �� �����ϴ�");
				} else {
					JOptionPane.showMessageDialog(null, "��߿� : " + startCombo.getSelectedItem() 
					+ "\n������ : " + arriveCombo.getSelectedItem() 
					+ "\n�Ͻ� : " + dateCombo.getSelectedItem() + timeCombo.getSelectedItem() 
					+ "\n�ο� : � : " + numCombo1.getSelectedItem() + "�� û�ҳ� : " + numCombo2.getSelectedItem() + "��");
					va.setStation1(startCombo.getSelectedItem().toString());
					va.setStation2(arriveCombo.getSelectedItem().toString());
					va.setDay(dateCombo.getSelectedItem().toString());
					va.setTime(timeCombo.getSelectedItem().toString());
					va.setAdult(Integer.parseInt(numCombo1.getSelectedItem().toString()));
					va.setChild(Integer.parseInt(numCombo2.getSelectedItem().toString()));
					ChooseSeatMain.main(args);
				f.dispose();
				}
			}
		});
		
		f.setVisible(true);
		
		//���� �����
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.dispose();
			}
		});
	} // main
}