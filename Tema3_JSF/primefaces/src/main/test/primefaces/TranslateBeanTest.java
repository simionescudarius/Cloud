package primefaces;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tema3.prime.beans.TranslateBean;

public class TranslateBeanTest {

	private TranslateBean bean;
	
	@Before
	public void setUp() throws Exception {
		bean = new TranslateBean();
	}

	@Test
	public void test() {
		bean.getTranslateModel().setTextToBeTranslated("mere");
		bean.translateText( "ro", "en");
		String translatedText = bean.getTranslateModel().getTranslatedText();
		assertEquals("apples", translatedText);
	}

}
