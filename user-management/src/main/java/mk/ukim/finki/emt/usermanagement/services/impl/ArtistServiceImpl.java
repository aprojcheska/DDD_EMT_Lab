package mk.ukim.finki.emt.usermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.usermanagement.domain.modules.Artist;
import mk.ukim.finki.emt.usermanagement.domain.modules.ArtistId;
import mk.ukim.finki.emt.usermanagement.domain.repository.ArtistRepository;
import mk.ukim.finki.emt.usermanagement.services.ArtistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public Artist findById(ArtistId id) {
        return artistRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }
}
