package ktx_LoginPage;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	
	static HashMap<Integer, UserInformation> map = new HashMap<Integer, UserInformation>();
	UserInformation ui = new UserInformation();	
	
	public ArrayList<UserInformation> userList(){
		//���� ��� ������ ��̸���Ʈ�� �ֱ�
		return new ArrayList<UserInformation>(map.values());
	}
	
}
