package mk.ukim.finki.emt.productcatalog.services;

import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArtId;
import mk.ukim.finki.emt.productcatalog.services.form.DigitalArtForm;

import java.util.List;

public interface DigitalArtService {

    DigitalArt findById(DigitalArtId id);
//    DigitalArt createProduct(DigitalArtForm form);
    DigitalArt orderItemCreated(DigitalArtId productId, int quantity);
    DigitalArt orderItemRemoved(DigitalArtId productId, int quantity);
    List<DigitalArt> getAll();

}
