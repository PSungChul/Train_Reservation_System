package ktx_LoginPage;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FindFrame {
	public FindFrame() {
		
		Frame find = new Frame("찾기");
		find.setBounds(500, 450, 300, 150);
		find.setLayout(null);
		
		Button btn_findid = new Button("아이디찾기");
		btn_findid.setBounds(30, 60, 90, 50);
		Button btn_findpw = new Button("비밀번호찾기");
		btn_findpw.setBounds(180, 60, 90, 50);
		
		btn_findid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindidFrame();
			}
		});
		
		btn_findpw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindpwFrame();
			}
		});

		find.add(btn_findid);
		find.add(btn_findpw);
		find.setVisible(true);
		
		find.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				find.dispose();
			};	
		});	
	}
}
