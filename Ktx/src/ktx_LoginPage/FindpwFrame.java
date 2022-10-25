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

public class FindpwFrame {
	public FindpwFrame() {
		
		Map map = new Map();
		UserInformation ui = new UserInformation();
		
		Frame find_pw = new Frame("비밀번호찾기");
		find_pw.setBounds(450, 350, 400, 300);
		find_pw.setLayout(null);
		
		Label id = new Label("아이디 : ");
		id.setBounds(60, 80, 100, 50);//아이디입력 크기
		Label name = new Label("이름 : ");
		name.setBounds(70, 130, 100, 50);//아이디입력 크기
		Label number = new Label("전화번호 : ");
		number.setBounds(45, 180, 100, 50);//아이디입력 크기
		
		TextField tf_id = new TextField(5);
		tf_id.setBounds(140, 90, 100, 30);
		TextField tf_name = new TextField(5);
		tf_name.setBounds(140, 140, 100, 30);
		TextField tf_number = new TextField(5);
		tf_number.setBounds(140, 190, 100, 30);
		
		Button btn_find = new Button("비밀번호 찾기");
		btn_find.setBounds(280, 110, 90, 90);
		
		//비밀번호 찾기 버튼 눌렀을때
		btn_find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserInformation> arr = new ArrayList<UserInformation>();
				arr = map.userList();
				int i;
				for(i = 0; i < arr.size();i++ ) {
					if(arr.get(i).getId().equals(tf_id.getText().trim())) {
						if(arr.get(i).getName().equals(tf_name.getText().trim())) {
							if(arr.get(i).getNumber()==Integer.parseInt(tf_number.getText().trim())) {
								break;
							}//inner if
						}//middle if
					}//outer if
				}//for
				if(i>=arr.size()) {
					JOptionPane.showMessageDialog(find_pw, "회원정보가 존재하지 않습니다");
				}else {
					JOptionPane.showMessageDialog(find_pw, "비밀번호는 "+arr.get(i).getPw()+"입니다");
					find_pw.dispose();
				}
			}
	});
		find_pw.add(number);
		find_pw.add(id);
		find_pw.add(name);
		find_pw.add(tf_id);
		find_pw.add(tf_name);
		find_pw.add(tf_number);
		find_pw.add(btn_find);
		find_pw.add(id);
		find_pw.add(name);
		find_pw.add(number);
		find_pw.setVisible(true);
		
		find_pw.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				find_pw.dispose();
			};	
		});	
}
}
