package ktx_LoginPage;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.ldap.HasControls;
import javax.swing.JOptionPane;

public class SignupFrame {

	//2.ȸ�������� ������ ������ â
	public SignupFrame() {
		
		Map map = new Map();
		UserInformation ui = new UserInformation();
		
		Frame f_signup = new Frame("ȸ������");
		f_signup.setBounds(350, 150, 500, 500);
		f_signup.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 20);
		
		Button btn_idCheck = new Button("�ߺ�Ȯ��");
		btn_idCheck.setBounds(370, 100, 100, 40);
		btn_idCheck.setFont(font);
		btn_idCheck.setEnabled(false);
		
		Button btn_signup = new Button("ȸ������");	
		btn_signup.setBounds(200, 400, 100, 50);
		btn_signup.setFont(font);
		
		Label id = new Label("���̵� : ");
		id.setFont(font);
		id.setBounds(90, 90, 100, 50);
		Label pw = new Label("�н����� :");
		pw.setFont(font);
		pw.setBounds(70, 145, 100, 50);
		Label name = new Label("�̸� :");
		name.setFont(font);
		name.setBounds(110, 195, 100, 50);
		Label birth = new Label("������� :");
		birth.setFont(font);
		birth.setBounds(70, 245, 100, 50);
		Label number = new Label("��ȭ��ȣ :");
		number.setFont(font);
		number.setBounds(70, 295, 100, 50);
		
		TextField tf_id = new TextField(5);
		tf_id.setFont(font);
		tf_id.setBounds(200, 100, 150, 40);
		TextField tf_pw = new TextField(5);
		tf_pw.setFont(font);
		tf_pw.setBounds(200, 150, 150, 40);
		TextField tf_name = new TextField(5);
		tf_name.setFont(font);
		tf_name.setBounds(200, 200, 150, 40);
		TextField tf_birth = new TextField(5);
		tf_birth.setFont(font);
		tf_birth.setBounds(200, 250, 150, 40);
		TextField tf_number = new TextField(5);
		tf_number.setFont(font);
		tf_number.setBounds(200, 300, 150, 40);	
	
		f_signup.add(btn_idCheck);
		f_signup.add(btn_signup);
		f_signup.add(tf_id);
		f_signup.add(tf_pw);
		f_signup.add(tf_name);
		f_signup.add(tf_birth);
		f_signup.add(tf_number);
		f_signup.add(id);
		f_signup.add(pw);
		f_signup.add(name);
		f_signup.add(birth);
		f_signup.add(number);
		f_signup.setVisible(true);
		
		//�ߺ�üũ �ȶ߰��ϱ�
		tf_id.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				if(tf_id.getText().trim().contentEquals("")) {
					btn_idCheck.setEnabled(false);
				}else {
					btn_idCheck.setEnabled(true);
				}	
			}
		});	
		
		//�ߺ�üũ�����ϱ�
		//!!!!!!!!!!!!!!!�ߺ�üũ�� ��ġ�������� ȸ�������� �Ҽ����� �Ҽ�������
		btn_idCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1���ε����� ���̵� 123�� ���
				//0���ε����� ���̵� 234�� �������
				ArrayList<UserInformation> arr = new ArrayList<UserInformation>();
				arr = map.userList();
				boolean b = true;
				for(int i = 0; i < map.userList().size();i++) {
					if(arr.get(i).getId().equals(tf_id.getText().trim())) {
						JOptionPane.showMessageDialog(f_signup, "�ߺ�");
						//��������Ʈ 0���ε����� ó��ȸ�������� ����� ����������
						//0���� i���� �ҷ����� ������� ����
						//�迭�� ��� �ε����� ���� ��
						b = false;
						break;
					}//if
				}//for
				if(b) {
					JOptionPane.showMessageDialog(f_signup, "�ߺ��ƴ�");
					//for��
				}//if
			}
		});
		
		//ȸ�����Թ�ư ������ �� �����ϰ� �ϱ�
		//ĭ �� ��ä��� ȸ�����Դ����� �޼�������
		//!!!!!!!!!!!!!!!!!!!Ȥ�� ������Ͽ� ���ڸ� �������Ҽ��ֳ�?????
		btn_signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "���̵� �Է����ּ���");
				}else if(tf_pw.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "��й�ȣ�� �Է����ּ���");
				}else if(tf_name.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "�̸��� �Է����ּ���");
				}else if(tf_birth.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "�������(990101)�� �Է����ּ���");
				}else if(tf_number.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "��ȭ��ȣ�� �Է����ּ���");
				}else {
					ui.setId(tf_id.getText());
					ui.setPw(tf_pw.getText());
					ui.setName(tf_name.getText());
					//�����ιޱ�
					ui.setBirth(Integer.parseInt(tf_birth.getText()));
					ui.setNumber(Integer.parseInt(tf_number.getText()));
					//������ ��ȭ��ȣ�� ������ UserInformationŬ������ ��ü���ִ� ���� value��
					//���Խ�?(��ȣ�� ���Ͽ� ���ڿ������� �����ߴϱ� ���ڸ� �ְ��Ҽ�������??????????????????????)
					map.map.put(ui.getNumber(), ui);
					JOptionPane.showMessageDialog(f_signup, "ȸ�����ԿϷ�");
					f_signup.dispose();
				}
			}
		});

		//â�ݱ�
		f_signup.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				f_signup.dispose();
			};	
		});	
	}//������
}
