package com.wy.shop.service.impl;

import com.wy.shop.entity.*;
import com.wy.shop.mapper.GoodsMapper;
import com.wy.shop.service.*;
import com.wy.shop.vo.DetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private ProductService productService;
    @Autowired
    GoodsSpecificationService goodsSpecificationService;
    @Autowired
    SpecificationService specificationService;

    @Override
    public Integer getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public List<Goods> getGoodsByCategoryId(Integer category_id) {
        return goodsMapper.getGoodsByCategoryId(category_id);
    }

    @Override
    @Transactional
    public DetailVo getDetailInfo(Integer goods_id) {
        DetailVo detailVo = new DetailVo();

        //根据商品的id得到产品的集合（product是goods的具体的一个产品）
        List<Product> productList = productService.getProductListByGid(goods_id);

        //根据goods的id获得goodsSpecification对象集合(goodsSpecification是产品的一些规格信息)
        List<GoodsSpecification> goodsSpecifications = goodsSpecificationService.getGoodsSpecificationByGid(goods_id);

        //通过goodsSpecification信息id来获取规格信息
        int specification_id = goodsSpecifications.get(0).getSpecification_id();
        Specification specification = specificationService.getSpecification(specification_id);
        SpecificationList specificationList = new SpecificationList();
        specificationList.setValueList(goodsSpecifications);
        specificationList.setName(specification.getName());
        specificationList.setSpecification_id(specification.getId());

        //为vo赋值
        detailVo.setInfo(goodsMapper.getSpecificationGoods(goods_id));
        detailVo.setGallery(galleryService.getSpecificationGallery(goods_id));
        detailVo.setProductList(productList);
        detailVo.setSpecificationList(specificationList);
        return detailVo;

    }

    @Override
    public Goods getGoodsById(Integer goods_id) {
        return goodsMapper.getSpecificationGoods(goods_id);
    }

    @Override
    public List<Goods> getGoodsListByKeyword(String keyword) {
        return goodsMapper.getGoodsListByKeyword(keyword);
    }


}
