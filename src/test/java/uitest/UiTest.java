package uitest;


import edu.nerobeev.product.page.MainPage;
import org.testng.annotations.Test;



public class UiTest extends AbsBaseUiTest {

		@Test
		public void testMainPage(){
			MainPage.open();

		}
}
