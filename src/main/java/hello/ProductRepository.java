package hello;

import enteties.Product;

public interface ProductRepository {

    void save(Product product);

    Iterable<Product> getList();
}
