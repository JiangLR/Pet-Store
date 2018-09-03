package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IGoodsOrderManager;
import cn.edu.zucc.pet_service.model.GoodsEntity;
import cn.edu.zucc.pet_service.model.GoodsOrderEntity;
import cn.edu.zucc.pet_service.model.GoodsOrderREntity;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @Author JiangLR
 * @Time 2018-09-03 18:59
 */
public class GoodsOrderManager implements IGoodsOrderManager {
    @Override
    public GoodsOrderEntity regGoodsOrder(MasterEntity master, GoodsEntity goods, int amount) throws BaseException {
        if (master == null)
            throw new BaseException("用户不能为空");
        if(goods == null)
            throw new BaseException("商品不能为空");
        if(amount > goods.getGoodsAmount())
            throw new BaseException("此商品库存不足");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        GoodsOrderEntity goodsOrder = new GoodsOrderEntity();
        GoodsOrderREntity goodsOrderR = new GoodsOrderREntity();
        try {
            tx = session.beginTransaction();

            goodsOrder.setOrderPrice(0);
            goodsOrder.setOrderStatus(0);
            goodsOrder.setMaster(master);

            goodsOrderR.setAmount(amount);
            goodsOrderR.setGoods(goods);
            goodsOrderR.setAmount(goods.getGoodsAmount());
            goods.setGoodsAmount(goods.getGoodsAmount() - amount);
            if(goods.getGoodsAmount() == 0)
                new GoodsManager().deleteGoods(goods);
            goods.getGoodsOrders().add(goodsOrderR);

            goodsOrderR.setGoodsOrder(goodsOrder);
            goodsOrder.getGoodsOrders().add(goodsOrderR);

            session.save(goodsOrderR);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                throw e;
        }
        return goodsOrder;
    }

    @Override
    public void deleteGoodsOrder(int GoodsOrderId) throws BaseException {

    }
}
