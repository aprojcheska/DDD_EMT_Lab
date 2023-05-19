package mk.ukim.finki.emt.productcatalog.domain.models;

import org.springframework.lang.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class DigitalArtId extends DomainObjectId {

    private DigitalArtId() {
        super(DigitalArtId.randomId(DigitalArtId.class).getId());
    }

    public DigitalArtId(@NonNull String uuid){
        super(uuid);
    }

    public static DigitalArtId of(String uuid){
        DigitalArtId p = new DigitalArtId(uuid);
        return p;
    }
}
