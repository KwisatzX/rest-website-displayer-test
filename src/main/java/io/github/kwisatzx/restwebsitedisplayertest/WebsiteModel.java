package io.github.kwisatzx.restwebsitedisplayertest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class WebsiteModel {
    private final RestTemplate restTemplate;

    public WebsiteModel() {
        this.restTemplate = new RestTemplateBuilder().build();
    }

    public String getWebsiteHtml(String url) {
        String returnString = "Error: Website url is incorrect or couldn't be found.<br />";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.hasBody()) {
                returnString = response.getBody();
            }
        } catch (RestClientException e) {
            returnString += e.getMessage();
        }
        return returnString;
    }

    public String replaceLinks(String websiteHtml) {
        //TODO: regex
        return "";
    }

    //TODO: replace images
}
