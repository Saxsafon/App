package hello;

import enteties.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Controller
public class WebController {
    private ProductsRepository repository = new ProductsRepository();


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView firstAsk(){
        System.out.println("firstAsk()");
        Product product = new Product();
        return new ModelAndView("Creation", "product", product);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView askProduct(@PathVariable Long id) {
        System.out.println("askProduct()");

        Product productForEdit = repository.getById(id);
        System.out.println("productForEdit: " + productForEdit);
        System.out.println(repository);

        //if/else тернарные выраженияproduct
//        Product productForEdit = repository.getById(id) == null ? new Product() : repository.getById(id);

        return new ModelAndView("Creation", "product", productForEdit);
    }

    @RequestMapping(value = "/showList",method=RequestMethod.POST)
    public ModelAndView show(Product product) {
        System.out.println("show()");
        System.out.println("show() product: " + product);
        repository.save(product);
        return new ModelAndView("Showing","products",repository.getList());
    }
}

