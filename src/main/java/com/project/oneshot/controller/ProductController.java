package com.project.oneshot.controller;

import com.project.oneshot.command.CategoryVO;
import com.project.oneshot.command.ProductVO;
import com.project.oneshot.command.SupplierVO;
import com.project.oneshot.inventory.product.ProductService;
import com.project.oneshot.util.Criteria;
import com.project.oneshot.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productList")
    public String product(Criteria cri, Model model) {
        List<ProductVO> list = productService.getProductList(cri);
        model.addAttribute("list", list);

        int totalProductCount = productService.getTotalProductCount(cri); //전체 게시글 수
        PageVO pageVO = new PageVO(cri, totalProductCount); //페이지네이션
        model.addAttribute("pageVO", pageVO);

        return "inventory/product";
    }

    @PostMapping("/putProduct")
    public String registerProduct(ProductVO vo, @RequestParam("file") MultipartFile file) {
        productService.registerProduct(vo, file);
        return "redirect:/inventory/productList";
    }
}
