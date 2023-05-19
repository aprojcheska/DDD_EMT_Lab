package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.ArtistId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;


@Entity
@Table(name = "arts")
@Getter
public class DigitalArt extends AbstractEntity<DigitalArtId> {

    private String productName;
    private String description;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    @AttributeOverride(name = "id", column = @Column(name = "artist_id", nullable = false))
    private ArtistId artistId;

    private String artistUsername;


    public DigitalArt(){
        super(DigitalArtId.randomId(DigitalArtId.class));
    }


    public static DigitalArt build(String productName, String description, Money price, ArtistId artistId, String artistUsername) {
        DigitalArt p = new DigitalArt();
        p.price = price;
        p.productName = productName;
        p.description = description;
        p.artistId = artistId;
        p.artistUsername = artistUsername;
        return p;
    }

}
