package com.example.eshop.controller;

import com.example.eshop.model.BrandEntity;
import com.example.eshop.model.CategoryEntity;
import com.example.eshop.model.ProductEntity;
import com.example.eshop.service.AdminService;
import com.example.eshop.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    HomeService homeService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap modelMap) {
        modelMap.addAttribute("productList", adminService.getAllProducts());
        modelMap.addAttribute("categoryList", adminService.getAllCategories());
        modelMap.addAttribute("brandList", adminService.getAllBrands());
        return "/admin";
    }

    @RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("categoryName") CategoryEntity categoryEntity) {
        adminService.addCategory(categoryEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteCategory", method = RequestMethod.POST)
    public String deleteCategory(@ModelAttribute("categoryId") CategoryEntity categoryEntity) {
        adminService.deleteCategory(categoryEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/addBrand", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute("brandName") BrandEntity brandEntity) {
        adminService.addBrand(brandEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteBrand", method = RequestMethod.POST)
    public String deleteBrand(@ModelAttribute("brandId") BrandEntity brandEntity) {
        adminService.deleteBrand(brandEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("newProduct") ProductEntity productEntity, @RequestParam("prPic") MultipartFile image) throws IOException {
        File dir = new File("D:\\eShop\\upload\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // Create the file on server
        String prodPic = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + "\\" + prodPic);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(image.getBytes());
        stream.close();
        productEntity.setProductPic(prodPic);
        adminService.addProduct(productEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/deleteProduct", method = RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("productId") ProductEntity productEntity) {
        adminService.deleteProduct(productEntity);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/updateProduct/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("productEntity", adminService.getProductEntityById(id));
        modelMap.addAttribute("categoryEntityList", adminService.getAllCategories());
        modelMap.addAttribute("brandEntityList", adminService.getAllBrands());
        return "/updateProduct";
    }

    @RequestMapping(value = "/admin/updateProduct", method = RequestMethod.POST)
    public String updateProd(@ModelAttribute("productId") ProductEntity productEntity, ModelMap modelMap) {
        modelMap.addAttribute("productEntity", productEntity);
        modelMap.addAttribute("categoryEntityList", adminService.getAllCategories());
        modelMap.addAttribute("brandEntityList", adminService.getAllBrands());
        return "/updateProduct";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProductParam(@ModelAttribute("updateProd") ProductEntity productEntity, @RequestParam("prPic") MultipartFile image) throws IOException {
                    File dir = new File("D:\\eShop\\upload\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // Create the file on server
        String prodPic = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + "\\" + prodPic);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(image.getBytes());
        stream.close();
        productEntity.setProductPic(prodPic);
        adminService.updateProduct(productEntity.getId(), productEntity.getName(), productEntity.getProductPic(), productEntity.getPrice(),
                productEntity.getQuantity(), productEntity.getAvailability(), productEntity.getCondition(),
                productEntity.getCategoryId(), productEntity.getBrandId());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public byte[] getImageAsByteArray(@RequestParam("filename") String filename) throws Exception {
        InputStream in = new FileInputStream("D:\\eShop\\upload\\" + filename);
        return org.apache.commons.io.IOUtils.toByteArray(in);
    }

}
