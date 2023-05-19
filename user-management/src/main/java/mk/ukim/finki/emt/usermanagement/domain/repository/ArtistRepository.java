package mk.ukim.finki.emt.usermanagement.domain.repository;

import mk.ukim.finki.emt.usermanagement.domain.modules.Artist;
import mk.ukim.finki.emt.usermanagement.domain.modules.ArtistId;
import mk.ukim.finki.emt.usermanagement.domain.modules.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, ArtistId> {
}
