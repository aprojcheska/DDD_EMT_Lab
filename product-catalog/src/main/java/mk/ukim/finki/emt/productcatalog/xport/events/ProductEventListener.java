package mk.ukim.finki.emt.productcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArt;
import mk.ukim.finki.emt.productcatalog.domain.models.DigitalArtId;
import mk.ukim.finki.emt.productcatalog.services.DigitalArtService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductEventListener {

    private final DigitalArtService digitalArtService;

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,OrderItemCreated.class);
            digitalArtService.orderItemCreated(DigitalArtId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
            digitalArtService.orderItemRemoved(DigitalArtId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e){

        }

    }
}
