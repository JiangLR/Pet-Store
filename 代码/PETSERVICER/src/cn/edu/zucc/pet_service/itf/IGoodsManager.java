package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.BrandsEntity;
import cn.edu.zucc.pet_service.model.GoodsEntity;
import cn.edu.zucc.pet_service.model.GoodsRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.sql.Blob;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:50
 */
public interface IGoodsManager {
    public GoodsEntity reg_goods(String name, Float price, Float on_sale, Blob barcode, int goods_amount, GoodsRaceEntity goods_race, BrandsEntity brand) throws BaseException;
}
