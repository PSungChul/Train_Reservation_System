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

	//2.회원가입을 누르면 나오는 창
	public SignupFrame() {
		
		Map map = new Map();
		UserInformation ui = new UserInformation();
		
		Frame f_signup = new Frame("회원가입");
		f_signup.setBounds(350, 150, 500, 500);
		f_signup.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 20);
		
		Button btn_idCheck = new Button("중복확인");
		btn_idCheck.setBounds(370, 100, 100, 40);
		btn_idCheck.setFont(font);
		btn_idCheck.setEnabled(false);
		
		Button btn_signup = new Button("회원가입");	
		btn_signup.setBounds(200, 400, 100, 50);
		btn_signup.setFont(font);
		
		Label id = new Label("아이디 : ");
		id.setFont(font);
		id.setBounds(90, 90, 100, 50);
		Label pw = new Label("패스워드 :");
		pw.setFont(font);
		pw.setBounds(70, 145, 100, 50);
		Label name = new Label("이름 :");
		name.setFont(font);
		name.setBounds(110, 195, 100, 50);
		Label birth = new Label("생년월일 :");
		birth.setFont(font);
		birth.setBounds(70, 245, 100, 50);
		Label number = new Label("전화번호 :");
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
		
		//중복체크 안뜨게하기
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
		
		//중복체크실행하기
		//!!!!!!!!!!!!!!!중복체크를 거치지않으면 회원가입을 할수없게 할순없나요
		btn_idCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1번인덱스에 아이디가 123인 사람
				//0번인덱스에 아이디가 234인 사람있음
				ArrayList<UserInformation> arr = new ArrayList<UserInformation>();
				arr = map.userList();
				boolean b = true;
				for(int i = 0; i < map.userList().size();i++) {
					if(arr.get(i).getId().equals(tf_id.getText().trim())) {
						JOptionPane.showMessageDialog(f_signup, "중복");
						//유저리스트 0번인덱스엔 처음회원가입한 사람의 정보가있음
						//0부터 i까지 불러오면 사람들의 정보
						//배열에 모든 인덱스의 값과 비교
						b = false;
						break;
					}//if
				}//for
				if(b) {
					JOptionPane.showMessageDialog(f_signup, "중복아님");
					//for문
				}//if
			}
		});
		
		//회원가입버튼 누르면 값 저장하게 하기
		//칸 다 안채우고 회원가입누르면 메세지띄우기
		//!!!!!!!!!!!!!!!!!!!혹시 생년월일에 문자만 들어오게할수있나?????
		btn_signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_id.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "아이디를 입력해주세요");
				}else if(tf_pw.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "비밀번호를 입력해주세요");
				}else if(tf_name.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "이름을 입력해주세요");
				}else if(tf_birth.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "생년월일(990101)을 입력해주세요");
				}else if(tf_number.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(f_signup, "전화번호를 입력해주세요");
				}else {
					ui.setId(tf_id.getText());
					ui.setPw(tf_pw.getText());
					ui.setName(tf_name.getText());
					//정수로받기
					ui.setBirth(Integer.parseInt(tf_birth.getText()));
					ui.setNumber(Integer.parseInt(tf_number.getText()));
					//맵으로 전화번호를 열쇠삼아 UserInformation클래스의 객체에있는 값을 value로
					//정규식?(번호랑 생일에 문자열넣으면 오류뜨니까 숫자만 넣게할순없을까??????????????????????)
					map.map.put(ui.getNumber(), ui);
					JOptionPane.showMessageDialog(f_signup, "회원가입완료");
					f_signup.dispose();
				}
			}
		});

		//창닫기
		f_signup.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				f_signup.dispose();
			};	
		});	
	}//생성자
}
