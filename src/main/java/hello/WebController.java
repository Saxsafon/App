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



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView askProduct() {
        System.out.println("askProduct()");
        return new ModelAndView("Creation", "product", new Product());
    }


    @RequestMapping(value = "/",method=RequestMethod.POST)
    public ModelAndView show(Product product) {
        Product p = new Product();
        System.out.println("p:  " + p);
        System.out.println(repository.getList());

        System.out.println("save(" + product + ")");
        repository.save(product);
        return new ModelAndView("Showing","products",repository.getList());
    }


    @RequestMapping(value = "/listProduct", method = RequestMethod.GET)
    public ModelAndView listProduct() {
        return new ModelAndView("Showing", "products", repository.getList());
    }




}












//
//public class WebController {
//    // с помощью этой аннотации значение из application.properties будет подставлено в поле message
//
//    private String message = "Hello World";
//
//    @RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("message", this.message);
//        return "Example";
//    }
//
//}

//@Controller
//public class WebController {
//    private String message = "Hello World!";
//// ,"message",this.message
//    // <span th:text="$(message)"></span>
//
//    @RequestMapping("/")
//    public ModelAndView home(){
//        return new ModelAndView("Example");
//    }
//}
