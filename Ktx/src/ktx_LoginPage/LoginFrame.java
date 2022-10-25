package ktx_LoginPage;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ticket.TrainMain;

public class LoginFrame {

	public static void main(String[] args) {
		//1.��ó�� �����ϸ� ������â
		UserInformation ui = new UserInformation();
		Map map = new Map();
		
		Frame site = new Frame("�ڷ���");
		site.setBounds(300, 200, 700, 600);
		site.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 20);
		Font t_font = new Font("", Font.BOLD, 40);
		
		Label title = new Label("       Let's Korail ");
		title.setBounds(0, 70, 700, 100);//����ũ��
		title.setBackground(Color.BLUE);
		title.setFont(t_font);
		Label id = new Label("���̵� : ");
		id.setBounds(140, 250, 100, 50);//���̵��Է� ũ��
		id.setFont(font);
		Label pw = new Label("�н����� :");
		pw.setBounds(120, 350, 100, 50);//��й�ȣ�Է� ũ��
		pw.setFont(font);
		
		Button btn_signup = new Button("ȸ������");
		btn_signup.setBounds(130, 450, 150, 70);//ȸ������ ��ưũ��
		Button btn_search = new Button("���̵�/��й�ȣ ã��");
		btn_search.setBounds(420, 450, 150, 70);//���̵�ã�� ��ưũ��
		Button btn_login = new Button("�α���");
		btn_login.setBounds(450, 260, 130, 130);
		
		TextField tf_id = new TextField(10);
		tf_id.setBounds(240, 260, 170, 30);//���̵� �Է¶�ũ��
		tf_id.setFont(font);
		TextField tf_pw = new TextField(10);
		tf_pw.setBounds(240, 360, 170, 30);//��й�ȣ �Է¶�ũ��
		tf_pw.setFont(font);

		//ȸ������ �������� â����
		btn_signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SignupFrame();
			}
		});
		
		//���̵�ã�� �������� â����
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindFrame();
			}
		});
		
		//�α����� ��������
		//1)���������ʴ� ���̵��Դϴ�? 
		//2)��й�ȣ�� �ٸ��ϴ�?
		//3�α��μ���
		//4)���� ������ �� �Է������ʾ����� �޼����� �����ִ°�?
		btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserInformation> arr = new ArrayList<UserInformation>();
				arr = map.userList();
				boolean idCheck = false;
				boolean pwCheck = false;
				for(int i = 0; i < arr.size();i++) {
					if(arr.get(i).getId().equals(tf_id.getText().trim())) {
						idCheck = true;
						if(arr.get(i).getPw().equals(tf_pw.getText().trim())) {
							pwCheck = true;
						}//if
					}//if
					
				}//for
				if(idCheck) {
					if(pwCheck) {
						JOptionPane.showMessageDialog(site, "�α��οϷ�");
						//�Ϸ�Ǹ� ĭ����
						tf_id.setText("");
						tf_pw.setText("");
						//����ٰ� ����������
						TrainMain.main(args);
						site.dispose();
					}else {
						JOptionPane.showMessageDialog(site, "��й�ȣ�� �ٸ��ϴ�");
						tf_id.setText("");
						tf_pw.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(site, "���������ʴ� ���̵��Դϴ�");
					tf_id.setText("");
					tf_pw.setText("");
					
				}
			}
		});
		
		//�˾�â�� ������ �˾�â�� ���������� �ٸ��ൿ�� �Ҽ������ϴ°Ǿ�����
		//------------------------------------------------------------------	
		site.add(tf_pw);
		site.add(tf_id);
		site.add(id);
		site.add(pw);
		site.add(title);
		site.add(btn_signup);
		site.add(btn_search);
		site.add(btn_login);
		site.setVisible(true);
		site.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
			 System.exit(0);
			};	
		});		
	}//main
}
