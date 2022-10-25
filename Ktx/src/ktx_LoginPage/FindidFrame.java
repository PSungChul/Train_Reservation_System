package ktx_LoginPage;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FindidFrame {
	public FindidFrame() {
		
		Map map = new Map();
		UserInformation ui = new UserInformation();
		
		Frame find_id = new Frame("���̵�ã��");
		find_id.setBounds(400, 400, 500, 200);
		find_id.setLayout(null);
		
		Label name = new Label("�̸� : ");
		name.setBounds(80, 50, 40, 50);//���̵��Է� ũ��	
		Label number = new Label("��ȭ��ȣ : ");
		number.setBounds(250, 50, 60, 50);//���̵��Է� ũ��
		
		TextField tf_name = new TextField(5);
		tf_name.setBounds(130, 60, 70, 30);
		TextField tf_number = new TextField(5);
		tf_number.setBounds(330, 60, 100, 30);
		
		Button btn_find = new Button("���̵�ã��");
		btn_find.setBounds(200, 120, 100, 40);
		
		//���̵� ã�� ��������
		btn_find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserInformation> arr = new ArrayList<UserInformation>();
				arr = map.userList();
				int i;
				for(i = 0; i < arr.size();i++ ) {
					if(arr.get(i).getName().equals(tf_name.getText().trim())) {
						if(arr.get(i).getNumber()==Integer.parseInt(tf_number.getText().trim())) {				
							break;
						}//inner if
					}//outer if
				}//for
				if(i>=arr.size()) {
					JOptionPane.showMessageDialog(find_id, "ȸ�������� �������� �ʽ��ϴ�");
				}else {
					JOptionPane.showMessageDialog(find_id, "���̵�� "+arr.get(i).getId()+"�Դϴ�");
					find_id.dispose();
				}
			}
		});
		
		find_id.add(name);
		find_id.add(number);
		find_id.add(btn_find);
		find_id.add(tf_name);
		find_id.add(tf_number);
		find_id.add(name);
		find_id.add(number);
		find_id.setVisible(true);
		find_id.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				find_id.dispose();
			};	
		});	
	}//������
}
