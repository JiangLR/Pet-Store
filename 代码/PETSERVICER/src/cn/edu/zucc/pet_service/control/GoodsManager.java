package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IGoodsManager;
import cn.edu.zucc.pet_service.model.BrandsEntity;
import cn.edu.zucc.pet_service.model.GoodsEntity;
import cn.edu.zucc.pet_service.model.GoodsRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import com.sun.prism.impl.shape.BasicEllipseRep;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Blob;

/**
 * @Author JiangLR
 * @Time 2018-09-03 8:37
 */
public class GoodsManager implements IGoodsManager {
    @Override
    public GoodsEntity reg_goods(String name, Float price, Float on_sale, Blob barcode, int goods_amount, GoodsRaceEntity goods_race, BrandsEntity brand) throws BaseException {
        if (name.equals(""))
            throw new BaseException("商品名称不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        GoodsEntity new_goods = new GoodsEntity();
        try {
            tx = session.beginTransaction();
            String hql = "from GoodsEntity where goodsName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            GoodsEntity goods = (GoodsEntity) query.uniqueResult();
            if(goods != null)
                throw new BaseException("此商品已存在");
            new_goods.setGoodsName(name);
            new_goods.setGoodsPrice(price);
            new_goods.setOnSale(on_sale);
            new_goods.setGoodsBarcode(barcode);
            new_goods.setGoodsRace(goods_race);
            new_goods.setGoodsAmount(goods_amount);
            new_goods.setBrand(brand);
            brand.getGoods().add(new_goods);
            goods_race.getGoods().add(new_goods);
            session.save(new_goods);
            tx.commit();
        } catch (Exception e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.clear();
        }
        return new_goods;
    }
}
