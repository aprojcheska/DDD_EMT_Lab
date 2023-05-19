package mk.ukim.finki.emt.usermanagement.domain.modules;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

@Getter
public class UserId extends DomainObjectId {

    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(@NonNull String uuid){
        super(uuid);
    }

    public static UserId of(String uuid){
        UserId u = new UserId(uuid);
        return u;
    }
}
