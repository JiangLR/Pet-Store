package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.GoodsOrderEntity;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.util.BaseException;


/**
 * @Author JiangLR
 * @Time 2018-09-02 18:52
 */
public interface IGoodsOrderManager {
    public GoodsOrderEntity regGoodsOrder(MasterEntity master) throws BaseException;
    public void deleteGoodsOrder(int GoodsOrderId) throws BaseException;
}
