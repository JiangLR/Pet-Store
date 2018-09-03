package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IGoodsOrderManager;
import cn.edu.zucc.pet_service.model.GoodsOrderEntity;
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
    public GoodsOrderEntity regGoodsOrder(MasterEntity master) throws BaseException {
        if (master == null)
            throw new BaseException("用户不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        GoodsOrderEntity goodsOrder = new GoodsOrderEntity();
        try {
            tx = session.beginTransaction();

            goodsOrder.setOrderPrice(0);
            goodsOrder.setOrderStatus(0);
            goodsOrder.setMaster(master);

            session.save(goodsOrder);
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
