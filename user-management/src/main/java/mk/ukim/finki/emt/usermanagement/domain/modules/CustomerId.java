package mk.ukim.finki.emt.usermanagement.domain.modules;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class CustomerId extends DomainObjectId {
    private CustomerId() {
        super(ArtistId.randomId(CustomerId.class).getId());
    }

    public CustomerId(@NonNull String uuid){
        super(uuid);
    }

    public static CustomerId of(String uuid){
        CustomerId c = new CustomerId(uuid);
        return c;
    }
}
