package mk.ukim.finki.emt.ordermanagement.domain.model;


import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.CustomerId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.DigitalArt;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

//    @Enumerated(EnumType.STRING)
//    private OrderState orderState;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

    @AttributeOverride(name = "id", column = @Column(name = "customer_id", nullable = false))
    private CustomerId customerId;

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency, CustomerId customerId) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
        this.customerId = customerId;
    }

    public Money total(){
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull DigitalArt product, int qty){
        Objects.requireNonNull(product, "product must not be null");
        var item = new OrderItem(product.getId(), product.getPrice(), qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId){
        Objects.requireNonNull(orderItemId, "Order Item must not be null");
        orderItemList.removeIf(v -> v.getId().equals(orderItemId));
    }
}
