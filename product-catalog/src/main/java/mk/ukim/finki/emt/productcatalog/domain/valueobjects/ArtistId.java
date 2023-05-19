package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ArtistId extends DomainObjectId {

    private ArtistId() {
        super(ArtistId.randomId(ArtistId.class).getId());
    }

    public ArtistId(String uuid) {
        super(uuid);
    }
}
