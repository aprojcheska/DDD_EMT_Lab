package mk.ukim.finki.emt.usermanagement.services;

import mk.ukim.finki.emt.usermanagement.domain.modules.Artist;
import mk.ukim.finki.emt.usermanagement.domain.modules.ArtistId;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.domain.modules.UserId;

import java.util.List;

public interface ArtistService {
    Artist findById(ArtistId id);
    List<Artist> findAll();
}
