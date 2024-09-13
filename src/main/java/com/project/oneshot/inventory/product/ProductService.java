package com.project.oneshot.inventory.product;


import com.project.oneshot.command.CategoryVO;
import com.project.oneshot.command.ProductVO;
import com.project.oneshot.command.SupplierVO;
import com.project.oneshot.util.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductVO> getProductList(Criteria cri);

    int getTotalProductCount(Criteria cri);

    List<SupplierVO> getSupplierList();

    SupplierVO getSupplierContent(int supplierNo);

    List<CategoryVO> getCategoryList();

    void registerProduct(ProductVO vo, MultipartFile file);
}
