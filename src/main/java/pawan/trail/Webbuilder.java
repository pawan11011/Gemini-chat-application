package pawan.trail;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class Webbuilder extends WebClientAutoConfiguration{
	@Value("${WEB_URL}")
	private String webUrl;
	
	@Value("${WEB_KEY}")
	private String webKey;
	
	public String getAnswer(String Question) {
		Map<String,Object> response =  Map.of("contents",new Object[] {
		Map.of("parts",new Object[] { Map.of("text",Question)})});
		
		return WebClient.builder().build().post().uri(webUrl +"?key="+ webKey).header("Content-Type", "application/json")
				.bodyValue(response).retrieve().bodyToMono(String.class).block();
	}

	
	
}
