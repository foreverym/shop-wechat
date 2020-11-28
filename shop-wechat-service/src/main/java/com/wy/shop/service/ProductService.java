package com.wy.shop.service;


import com.wy.shop.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProductListByGid(Integer goods_id);

    public Product getProductById(Integer id);

}
