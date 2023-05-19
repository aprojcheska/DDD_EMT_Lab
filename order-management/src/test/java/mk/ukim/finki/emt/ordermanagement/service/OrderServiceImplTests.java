package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Customer;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.DigitalArt;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.DigitalArtId;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.ordermanagement.xport.client.ArtClient;
import mk.ukim.finki.emt.ordermanagement.xport.client.CustomerClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ArtClient artClient;

    @Autowired
    private CustomerClient customerClient;




    private static DigitalArt newProduct(String name, Money price) {
        DigitalArt p = new DigitalArt(DigitalArtId.randomId(DigitalArtId.class), name, price);
        return p;
    }



    @Test
    public void testPlaceOrder() {

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(newProduct("Pizza",Money.valueOf(Currency.MKD,1500)));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(newProduct("Hot Dog",Money.valueOf(Currency.MKD,500)));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1,oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
        Assertions.assertEquals(newOrder.total(),Money.valueOf(Currency.MKD,2500));

    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<DigitalArt> artList = artClient.findAll();
        DigitalArt p1 = artList.get(0);
        DigitalArt p2 = artList.get(1);
        DigitalArt p3 = artList.get(2);
        DigitalArt p4 = artList.get(3);

        List<Customer> customerList = customerClient.findAll();
        Customer c1 = customerList.get(0);
        Customer c2 = customerList.get(1);

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(p3);
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(p4);
        oi2.setQuantity(1);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setCustomerId(c2.getId());
        orderForm.setItems(Arrays.asList(oi1,oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);

        Money outMoney = p3.getPrice().multiply(oi1.getQuantity()).add(p4.getPrice().multiply(oi2.getQuantity()));
        Assertions.assertEquals(newOrder.total(),outMoney);
    }

}
