package hello;

import enteties.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductsRepository {
    private final ConcurrentMap<Long, Product> products = new ConcurrentHashMap<Long, Product>();
    private static AtomicLong counter = new AtomicLong();


    public void save(Product product){
        System.out.println("save()");
        Long id = product.getId();
        System.out.println("ID: " + id);
        if (id == null) {
            id = counter.incrementAndGet();
            product.setId(id);
        }
        System.out.println("id: " + id);

        System.out.println(products.values());
        products.put(id, product);
        System.out.println(products.values());
    }

    public Collection<Product> getList(){
        return products.values();
    }

    public Product getById(Long id){
        return products.get(id);
    }


}
