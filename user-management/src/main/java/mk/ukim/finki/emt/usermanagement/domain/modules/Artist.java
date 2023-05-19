package mk.ukim.finki.emt.usermanagement.domain.modules;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
@Getter
public class Artist extends AbstractEntity<ArtistId> {

    private String biography;

    @OneToOne
    @JoinColumn(name = "user_artist")
    private User user;

    public Artist(){
        super(ArtistId.randomId(ArtistId.class));
    }

    public static Artist build(String biography, User user){
        Artist artist = new Artist();
        artist.biography = biography;
        artist.user = user;
        return artist;
    }
}
