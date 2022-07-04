package com.davacom.thymeleafappjdbc.controller;


import com.davacom.thymeleafappjdbc.models.Cart;
import com.davacom.thymeleafappjdbc.models.Product;
import com.davacom.thymeleafappjdbc.models.User;
import com.davacom.thymeleafappjdbc.models.WishList;
import com.davacom.thymeleafappjdbc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    DeleteCartService deleteCartService;

    @Autowired
    CartService cartService;

    @Autowired
    WishListService wishListService;

    @Autowired
    DeleteWishListService deleteWishListService;

    @Autowired
    ProductService productService;

    //Get login form
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    //    Get home page

    //Get signup page
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    //Carry out the login logic
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {

        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }

    }


    //Carry out the login logic
    @PostMapping("/signup")
    public String createAccount(@ModelAttribute User user, Model model) {

        model.addAttribute("user", user);
        User toSaveUser = userService.create(user);

        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        if (Objects.nonNull(oauthUser)) {
            return "redirect:/login";
        } else {
            return "redirect:/signup";
        }

    }

// Delete Cart
    @GetMapping("/deleteCart/{id}")
    public String deleteCart(@PathVariable String id, Model model) {
        deleteCartService.deleteCart(Long.parseLong(id));
        model.addAttribute("message", "successfully deleted");
        return "redirect:/viewCart";
    }

// View customer cart
    @GetMapping("/viewCart")
    public String viewCart(Model model) {
        List<Cart> listOfCart = cartService.getAllCart();
        model.addAttribute("listOfCart", listOfCart);
        return "viewCart";
    }


    @GetMapping("/home")
    public String viewProduct(Model model){
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList", productList);
        return "home";
    }



//    Delete WishList
    @GetMapping("/deleteWishList/{id}")
    public String deleteWishList(@PathVariable String id, Model model) {
        deleteWishListService.DeleteWishListService(Long.parseLong(id));
        model.addAttribute("message", "successfully deleted");
        return "redirect:/viewWishList";
    }


//    view WishList
    @GetMapping("/viewWishList")
    public String viewWishList(Model model) {
        List<WishList> listOfWish = wishListService.getAllList();
        model.addAttribute("listOfWish", listOfWish);
        return "viewWishList";
    }


//      Add to cart
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable String id, Model model) {
        Cart cart = cartService.addToCart(Long.parseLong(id));
        if (!(cart == null)) {
            model.addAttribute("message", "SUCCESSFUL!");
            return "redirect:/viewCart";
        } else {
            model.addAttribute("message", "NOT SUCCESSFUL!");
            return "home";
        }
    }
       @GetMapping("/addToList/{id}")
        public String addToList(@PathVariable String id, Model model) {
            WishList wishList = wishListService.addToList(Long.parseLong(id));
            if (!(wishList == null)) {
                model.addAttribute("message", "SUCCESSFUL!");
                return "redirect:/viewWishList";
            } else {
                model.addAttribute("message", "NOT SUCCESSFUL!");
                return "home";
            }


    }
}
