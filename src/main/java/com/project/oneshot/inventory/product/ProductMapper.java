package com.project.oneshot.inventory.product;

import com.project.oneshot.command.CategoryVO;
import com.project.oneshot.command.ProductVO;
import com.project.oneshot.command.SupplierVO;
import com.project.oneshot.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> getProductList(Criteria cri);

    int getTotalProductCount(Criteria cri);

    List<SupplierVO> getSupplierList();

    SupplierVO getSupplierContent(int supplierNo);

    List<CategoryVO> getCategoryList();

    void registerProduct(ProductVO vo);
}
