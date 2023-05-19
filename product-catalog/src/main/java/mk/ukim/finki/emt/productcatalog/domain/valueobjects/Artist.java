package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;

@Getter
public class Artist implements ValueObject {
    private final ArtistId id;
    private final String biography;

    private final User user;

    public Artist(){
        this.id = ArtistId.randomId(ArtistId.class);
        this.user = this.getUser();
        this.biography = "";
    }


    @JsonCreator
    public Artist(@JsonProperty("artist_id") ArtistId id,
                  @JsonProperty("artist_username") User user,
                  @JsonProperty("artist_bio") String biography) {
        this.id = id;
        this.user = user;
        this.biography = biography;
    }

}
