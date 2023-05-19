package mk.ukim.finki.emt.productcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArtId;
import mk.ukim.finki.emt.productcatalog.domain.repository.DigitalArtRepository;
import mk.ukim.finki.emt.productcatalog.services.DigitalArtService;
import mk.ukim.finki.emt.productcatalog.services.form.DigitalArtForm;
import mk.ukim.finki.emt.productcatalog.xport.client.ArtistClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DigitalArtServiceImpl implements DigitalArtService {

    private final DigitalArtRepository digitalArtRepository;

    private final ArtistClient artistClient;

    @Override
    public DigitalArt findById(DigitalArtId id) {
        return digitalArtRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

//    @Override
//    public DigitalArt createProduct(DigitalArtForm form) {
//        DigitalArt p = DigitalArt.build(form.getProductName(), form.getPrice());
//        digitalArtRepository.save(p);
//        return p;
//    }

    @Override
    public DigitalArt orderItemCreated(DigitalArtId productId, int quantity) {
        System.out.println("Pocetok");
        DigitalArt p = digitalArtRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        digitalArtRepository.saveAndFlush(p);
        System.out.println("Nesto");
        return p;
    }

    @Override
    public DigitalArt orderItemRemoved(DigitalArtId productId, int quantity) {
        DigitalArt p = digitalArtRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        digitalArtRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<DigitalArt> getAll() {
        return digitalArtRepository.findAll();
    }
}
