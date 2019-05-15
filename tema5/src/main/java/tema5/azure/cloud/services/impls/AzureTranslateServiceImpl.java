package tema5.azure.cloud.services.impls;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import tema5.azure.cloud.services.AzureTranslateService;

@Service
public class AzureTranslateServiceImpl implements AzureTranslateService {

	private String subscriptionKey = "e37901e8114a40d9a5147d3160a33ce1";
	private String url = "https://api.cognitive.microsofttranslator.com/dictionary/lookup?api-version=3.0&from=LANG1&to=LANG2";
	private OkHttpClient client = new OkHttpClient();

	public AzureTranslateServiceImpl() {

	}

	@Override
	public String translateText(String text, String sourceLanguage, String targetLanguage) {
		prepareUrlForCall(sourceLanguage, targetLanguage);
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "[{\n\t\"Text\": \"".concat(text).concat("\"\n}]"));
		Request request = new Request.Builder().url(url).post(body)
				.addHeader("Ocp-Apim-Subscription-Key", subscriptionKey).addHeader("Content-type", "application/json")
				.build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private void prepareUrlForCall(String sourceLang, String targetLang) {
		url = url.replace("LANG1", sourceLang).replace("LANG2", targetLang);
	}

}
