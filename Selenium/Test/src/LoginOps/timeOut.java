package LoginOps;

import org.testng.annotations.Test;

public class timeOut extends setUp {
	functions fn;
	String failXpath = "//*[@id=\"userSettings:loginOpts1\"]/tbody/tr[2]/td[2]/span";
	String id = "userSettings:sessionTimeout";
	@Test
	public void BlankValue() {
		fn = new functions(drv);
		fn.login("hnga\n", "hihihaha123");
		fn.lgOps();
		fn.value(id, "");
		fn.failCheck(failXpath, "Please fill in this field.");
	}
	@Test
	public void OutValue() {
		fn = new functions(drv);
		fn.login("hnga\n", "hihihaha123");
		fn.lgOps();
		fn.value(id, "-12");
		fn.failCheck(failXpath,
				"Specified value is not between the expected values of 5 and 60.");
	}
	@Test
	public void SpecialCharValue() {
		fn = new functions(drv);
		fn.login("hnga\n", "hihihaha123");
		fn.lgOps();
		fn.value(id, "$%^&");
		fn.failCheck(failXpath,
				"Value is not of the correct type. Specify a numeric value.");
	}
	@Test
	public void LetterValue() {
		fn = new functions(drv);
		fn.login("hnga\n", "hihihaha123");
		fn.lgOps();
		fn.value(id, "hnga");
		fn.failCheck(failXpath,
				"Value is not of the correct type. Specify a numeric value.");
	}
	@Test
	public void PassValue() {
		fn = new functions(drv);
		fn.login("hnga\n", "hihihaha123");
		fn.lgOps();
		fn.value(id, "5");
		fn.passCheck("The information that you entered has been saved.");
		
	}
}
