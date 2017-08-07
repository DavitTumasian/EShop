package com.example.eshop.controller;

import com.example.eshop.model.Role;
import com.example.eshop.model.UserEntity;
import com.example.eshop.service.HomeService;
import com.example.eshop.service.UserEntityService;
import com.example.eshop.service.currentUser.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
    @Autowired
    HomeService homeService;

    @Autowired
    UserEntityService userEntityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("categoryEntityList", homeService.getAllCategoryEntities());
        modelMap.addAttribute("brandEntityList", homeService.getAllBrandEntities());
        modelMap.addAttribute("productEntityList", homeService.getAllProductEntities());
        return "/index";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String categoryProducts(@PathVariable("id") long categoryEntityID, ModelMap modelMap) {
        modelMap.addAttribute("categoryEntityList", homeService.getAllCategoryEntities());
        modelMap.addAttribute("brandEntityList", homeService.getAllBrandEntities());
        modelMap.addAttribute("productEntityList", homeService.getProductEntityListByCategoryId(categoryEntityID));
        return "/index";
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    public String brandProducts(@PathVariable("id") long brandEntityID, ModelMap modelMap) {
        modelMap.addAttribute("categoryEntityList", homeService.getAllCategoryEntities());
        modelMap.addAttribute("brandEntityList", homeService.getAllBrandEntities());
        modelMap.addAttribute("productEntityList", homeService.getProductEntityListByBrandId(brandEntityID));
        return "/index";
    }


    @RequestMapping(value = "/login/admin", method = RequestMethod.POST)
    public String loginAdmin() {
        return "redirect:/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("registerForm") UserEntity newUser) {
        newUser.setRole(Role.USER);
        userEntityService.saveNewUser(newUser);
        return "/login";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFound() {
        return "/404";
    }

    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String contuctUs() {
        return "/contact-us";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blog() {
        return "/blog";
    }

    @RequestMapping(value = "/blog-single", method = RequestMethod.GET)
    public String blogSingle() {
        return "/blog-single";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart() {
        return "/cart";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout() {
        return "/checkout";
    }

    @RequestMapping(value = "/product-details", method = RequestMethod.GET)
    public String productDetails() {
        return "/product-details";
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shop() {
        return "/shop";
    }

    @RequestMapping(value = "/wishlist", method = RequestMethod.GET)
    public String wishlist() {
        return "/404";
    }

}
