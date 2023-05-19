package mk.ukim.finki.emt.productcatalog.xport.client;

import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Artist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class ArtistClient {

    private final RestTemplate restTemplate;

    private final String serverUrl;

    public ArtistClient(@Value("${app.user-management.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Artist> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/artists").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Artist>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
