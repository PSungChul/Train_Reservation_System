package choose_seat_charge;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import ticket.TrainMain;
import variable.Variable;

public class Charge{
	public Charge() {
		//������
	}//Charge
	public Charge(Variable va) {
		//--------------------------------------------------
		//������ ����
		Frame f = new Frame();
		f.setSize(500, 800);
		f.setLocation(700, 100);
		f.setLayout(null);
		f.setTitle("���� ����");
		//--------------------------------------------------
		//��Ʈ ����
		Font font = new Font("", Font.BOLD, 30);
		//--------------------------------------------------
		//������ �ۼ�
		Label course = new Label("�뼱 : " + va.getStation1() + " ~ " + va.getStation2());
		course.setBounds(10, 50, 500, 50);
		course.setFont(font);
		
		Label day_time = new Label("��¥ : " + va.getDay() + " " + va.getTime());
		day_time.setBounds(10, 150, 500, 50);
		day_time.setFont(font);
		
		Label people = new Label("� : " + va.getAdult() + "�� " + "���� : " + va.getChild() + "��");
		people.setBounds(10, 250, 500, 50);
		people.setFont(font);
		
		Label seat_name = new Label("���� : " + va.getSeat_name().trim());
		seat_name.setBounds(10, 350, 500, 50);
		seat_name.setFont(font);
		
		Label charge = new Label("���� : " + (va.getAdult_price() * va.getAdult() + va.getChild_price() * va.getChild()) + "��");
		charge.setBounds(10, 450, 500, 50);
		charge.setFont(font);
		
		//--------------------------------------------------
		//������ư
		Button btn_pay = new Button("����");
		btn_pay.setBounds(350, 700, 100, 50);
		//������ư Ŭ���� �̺�Ʈ
		btn_pay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "������ " + (va.getAdult_price() * va.getAdult() + va.getChild_price() * va.getChild()) + "�� �Դϴ�\n�����Ͻðڽ��ϱ�?");
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
				f.dispose();
			}
		});
		//--------------------------------------------------
		//�߰�
		f.add(btn_pay);
		f.add(course);
		f.add(day_time);
		f.add(people);
		f.add(seat_name);
		f.add(charge);
		//--------------------------------------------------
		f.setVisible(true);
		//--------------------------------------------------
		//���� �����
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				f.dispose();
				
			}
		});
		//--------------------------------------------------
	}//Charge
}
