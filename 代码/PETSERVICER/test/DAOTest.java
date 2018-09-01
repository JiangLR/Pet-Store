import cn.edu.zucc.pet_service.model.GoodsEntity;
import cn.edu.zucc.pet_service.model.GoodsOrderEntity;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author JiangLR
 * @Time 2018-08-31 16:16
 */
public class DAOTest {
    Session session = null;
    Transaction tx = null;

    @Before
    public void init() {
        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
    }

    @After
    public void release() {
        session.clear();
    }

    @Test
    public void insert() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("huangwb");
        master1.setMasterSex("male");
        master1.setMasterTel("13736681153");
        master1.setMasterMail("1024311844@qq.com");
        session.save(master1);
        tx.commit();
    }

    @Test
    public void insertPet() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("jiangjy");
        master1.setMasterSex("male");
        master1.setMasterTel("13738578538");
        master1.setMasterMail("1024311844@qq.com");


        for (int i = 0; i < 5; i++) {
            PetEntity pet_i = new PetEntity();
            pet_i.setMaster(master1);
            pet_i.setPetName("maomi" + i);
            pet_i.setPetNickname("yellow" + i);
            pet_i.setPetRace("cat");
            pet_i.setPetSex("male");

            master1.getPets().add(pet_i);
            pet_i.setMaster(master1);
            session.save(master1);
        }
        tx.commit();
    }

    @Test
    public void deleteMaster() {
        MasterEntity master1 = (MasterEntity) session.get(MasterEntity.class, 1);
        session.delete(master1);
        tx.commit();
    }

    @Test
    public void changePet(){
        PetEntity pet1 = (PetEntity)session.get(PetEntity.class, 7);
        MasterEntity master1 = (MasterEntity)session.get(MasterEntity.class, 3);
        pet1.setMaster(master1);
        master1.getPets().add(pet1);
        tx.commit();
    }

    @Test
    public void save_goods_order(){
        GoodsEntity goods1 = new GoodsEntity();
        goods1.setGoodsName("maoliang1");
        goods1.setGoodsPrice(20.0);
        goods1.setOnSale(0);
        goods1.setGoodsBarcode("xxxxxxxx");

        GoodsEntity goods2 = new GoodsEntity();
        goods2.setGoodsName("gouliang1");
        goods2.setGoodsPrice(30.0);
        goods2.setOnSale(0);
        goods2.setGoodsBarcode("xxxxxxxx");

        GoodsOrderEntity order1 = new GoodsOrderEntity();
        order1.setOrderNum(3);
        float sum = (float) (goods1.getGoodsPrice() * order1.getOrderNum());
        order1.setOrderPrice(sum);
        order1.setOrderStatus((byte)0);

        GoodsOrderEntity order2 = new GoodsOrderEntity();
        order2.setOrderNum(2);
        sum = (float) (goods2.getGoodsPrice() * order2.getOrderNum());
        order2.setOrderPrice(sum);
        order2.setOrderStatus((byte)0);

        goods1.getOrders().add(order1);
        goods1.getOrders().add(order2);
        goods2.getOrders().add(order1);
        goods2.getOrders().add(order2);


        order1.getGoods().add(goods1);
        order1.getGoods().add(goods2);
        order2.getGoods().add(goods1);
        order2.getGoods().add(goods2);

        session.save(goods1);
        session.save(goods2);

        tx.commit();
    }
}
