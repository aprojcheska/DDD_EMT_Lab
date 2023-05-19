package mk.ukim.finki.emt.productcatalog.domain.repository;

import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArtId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DigitalArtRepository extends JpaRepository<DigitalArt, DigitalArtId> {
}
