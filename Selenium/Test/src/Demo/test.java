package Demo;

import org.testng.annotations.Test;

public class test extends BaseClass {

	Login lgP;
	Logout lgO;
	@Test
	public void loginByAdmin() {
		lgP = new Login(drv);
		lgP.login("hnga\n", "hihihi.12");
		lgO = new Logout(drv);
		lgO.logout();
	}
	@Test
	public void LoginFail() {
		lgP = new Login(drv);
		lgP.login("h\n", "");
		lgO = new Logout(drv);
		lgO.logout();
	}
}
