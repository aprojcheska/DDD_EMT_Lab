package mk.ukim.finki.emt.productcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.services.DigitalArtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/art")
@AllArgsConstructor
public class DigitalArtResource {

    private final DigitalArtService digitalArtService;

    @GetMapping
    public List<DigitalArt> getAll(){
        return digitalArtService.getAll();
    }
}
