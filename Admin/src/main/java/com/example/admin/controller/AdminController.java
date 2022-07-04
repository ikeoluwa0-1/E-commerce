package com.example.admin.controller;

import com.example.admin.model.Admin;
import com.example.admin.model.Product;
import com.example.admin.service.AdminService;
import com.example.admin.service.DeleteProductService;
import com.example.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;
    @Autowired
    DeleteProductService deleteProductService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("admin", new Admin());
        return "index";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("product", new Product());
        return "dashboard";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("admin") Admin admin, Model model){
        Admin authAdmin = adminService.login(admin.getEmail(), admin.getPassword());
        if(!(authAdmin == null)){

            return "redirect:/dashboard";
        }
        else{
            model.addAttribute("message","Invalid Username Or Password");
            return "redirect:/index";
        }
    }

    // Adding new products
    @PostMapping("/addNewProduct")
    public String addNewProduct(@ModelAttribute("product")Product product, Model model){
        model.addAttribute("product", product);
         product = productService.addNewProduct(product);
        if(product != null){
            model.addAttribute("message", "Product successfully Added");
            return "dashboard";
        }
        else{
            model.addAttribute("message", "Product successfully Added");
            return "dashboard";
        }

    }

    @GetMapping("/viewProduct")
    public String viewProduct(Model model){
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "viewProduct";
    }
    // Delete Product
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model) {
        deleteProductService.deleteProduct(Long.parseLong(id));
        model.addAttribute("message", "successfully deleted");
        return "redirect:/viewProduct";
    }


//    // Get view Product Page
//    @GetMapping("/viewProduct")
//    public String viewProduct(Model model){
//        model.addAttribute("viewProduct");
//        return "viewProduct";
//    }





}
