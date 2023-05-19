package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class DigitalArt implements ValueObject {

    private final DigitalArtId id;
    private final String name;
    private final Money price;


    public DigitalArt() {
        this.id = DigitalArtId.randomId(DigitalArtId.class);
        this.name= "";
        this.price = Money.valueOf(Currency.MKD, 0);
    }

    @JsonCreator
    public DigitalArt(@JsonProperty("id") DigitalArtId id,
                      @JsonProperty("productName") String name,
                      @JsonProperty("price") Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


}
