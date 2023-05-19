package mk.ukim.finki.emt.productcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Artist;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class DigitalArtForm {

    private String productName;
    private Money price;
}
