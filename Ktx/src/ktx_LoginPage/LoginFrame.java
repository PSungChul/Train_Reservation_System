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
		//1.맨처음 시작하면 나오는창
		UserInformation ui = new UserInformation();
		Map map = new Map();
		
		Frame site = new Frame("코레일");
		site.setBounds(300, 200, 700, 600);
		site.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 20);
		Font t_font = new Font("", Font.BOLD, 40);
		
		Label title = new Label("       Let's Korail ");
		title.setBounds(0, 70, 700, 100);//제목크기
		title.setBackground(Color.BLUE);
		title.setFont(t_font);
		Label id = new Label("아이디 : ");
		id.setBounds(140, 250, 100, 50);//아이디입력 크기
		id.setFont(font);
		Label pw = new Label("패스워드 :");
		pw.setBounds(120, 350, 100, 50);//비밀번호입력 크기
		pw.setFont(font);
		
		Button btn_signup = new Button("회원가입");
		btn_signup.setBounds(130, 450, 150, 70);//회원가입 버튼크기
		Button btn_search = new Button("아이디/비밀번호 찾기");
		btn_search.setBounds(420, 450, 150, 70);//아이디찾기 버튼크기
		Button btn_login = new Button("로그인");
		btn_login.setBounds(450, 260, 130, 130);
		
		TextField tf_id = new TextField(10);
		tf_id.setBounds(240, 260, 170, 30);//아이디 입력란크기
		tf_id.setFont(font);
		TextField tf_pw = new TextField(10);
		tf_pw.setBounds(240, 360, 170, 30);//비밀번호 입력란크기
		tf_pw.setFont(font);

		//회원가입 눌렀을때 창띄우기
		btn_signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SignupFrame();
			}
		});
		
		//아이디찾기 눌렀을때 창띄우기
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindFrame();
			}
		});
		
		//로그인을 눌렀을때
		//1)존재하지않는 아이디입니다? 
		//2)비밀번호가 다릅니다?
		//3로그인성공
		//4)만약 정보를 다 입력하지않았으면 메세지를 보내주는거?
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
						JOptionPane.showMessageDialog(site, "로그인완료");
						//완료되면 칸비우기
						tf_id.setText("");
						tf_pw.setText("");
						//여기다가 다음페이지
						TrainMain.main(args);
						site.dispose();
					}else {
						JOptionPane.showMessageDialog(site, "비밀번호가 다릅니다");
						tf_id.setText("");
						tf_pw.setText("");
					}
				}else {
					JOptionPane.showMessageDialog(site, "존재하지않는 아이디입니다");
					tf_id.setText("");
					tf_pw.setText("");
					
				}
			}
		});
		
		//팝업창이 떳을떄 팝업창을 끄지않으면 다른행동을 할수없게하는건없을까
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
