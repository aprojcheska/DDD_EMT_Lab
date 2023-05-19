package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class DigitalArtId extends DomainObjectId {
    private DigitalArtId() {
        super(DigitalArtId.randomId(DigitalArtId.class).getId());
    }

    public DigitalArtId(String uuid) {
        super(uuid);
    }

}
