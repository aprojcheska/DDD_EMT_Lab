package mk.ukim.finki.emt.productcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.domain.repository.DigitalArtRepository;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Artist;
import mk.ukim.finki.emt.productcatalog.xport.client.ArtistClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final DigitalArtRepository artRepository;


    @Autowired
    private ArtistClient artistClient;

    @PostConstruct
    public void initData() {
        List<Artist> artistList = artistClient.findAll();
        Artist a1 = artistList.get(0);
        Artist a2 = artistList.get(1);

        DigitalArt art1 = DigitalArt.build("FDA", "First digital art", Money.valueOf(Currency.MKD,500), a1.getId(), a1.getUser().getUsername());
        DigitalArt art2 = DigitalArt.build("SDA", "Second digital art", Money.valueOf(Currency.MKD,1200), a2.getId(), a2.getUser().getUsername());
        DigitalArt art3 = DigitalArt.build("TDA", "Third digital art", Money.valueOf(Currency.MKD,1500), a2.getId(), a2.getUser().getUsername());
        DigitalArt art4 = DigitalArt.build("FDA", "Fourth digital art", Money.valueOf(Currency.MKD,800), a1.getId(), a1.getUser().getUsername());

        if (artRepository.findAll().isEmpty()) {
            artRepository.saveAll(Arrays.asList(art1, art2, art3, art4));
        }

    }

}
