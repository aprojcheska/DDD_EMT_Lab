package mk.ukim.finki.emt.usermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.modules.Artist;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.services.ArtistService;
import mk.ukim.finki.emt.usermanagement.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/artists")
@AllArgsConstructor
public class ArtistResource {

    private final ArtistService artistService;

    @GetMapping
    public List<Artist>  findAll(){
        return artistService.findAll();
    }
}
