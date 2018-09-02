import cn.edu.zucc.pet_service.control.MasterManager;
import cn.edu.zucc.pet_service.control.PetRaceManager;
import cn.edu.zucc.pet_service.control.StaffManager;
import cn.edu.zucc.pet_service.model.*;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    public void changePet() {
        PetEntity pet1 = (PetEntity) session.get(PetEntity.class, 7);
        MasterEntity master1 = (MasterEntity) session.get(MasterEntity.class, 3);
        pet1.setMaster(master1);
        master1.getPets().add(pet1);
        tx.commit();
    }

    @Test
    public void save_goods_order() {
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
        order1.setOrderStatus((byte) 0);

        GoodsOrderEntity order2 = new GoodsOrderEntity();
        order2.setOrderNum(2);
        sum = (float) (goods2.getGoodsPrice() * order2.getOrderNum());
        order2.setOrderPrice(sum);
        order2.setOrderStatus((byte) 0);

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

    @Test
    public void save_service_appointment() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("jianglr");
        master1.setMasterSex("male");
        master1.setMasterTel("13588899791");
        master1.setMasterMail("1024311844@qq.com");


        PetEntity pet1 = new PetEntity();
        pet1.setPetName("hashiqi");
        pet1.setPetNickname("yellow");
        pet1.setPetRace("dog");
        pet1.setPetSex("male");
        pet1.setMaster(master1);

        PetEntity pet2 = new PetEntity();
        pet2.setPetName("hashiqi");
        pet2.setPetNickname("black");
        pet2.setPetRace("dog");
        pet2.setPetSex("male");
        pet2.setMaster(master1);

        master1.getPets().add(pet1);
        master1.getPets().add(pet2);
        pet1.setMaster(master1);
        pet2.setMaster(master1);
        session.save(master1);

        //****************************************************************************
        AppointmentEntity appointment1 = new AppointmentEntity();
        appointment1.setPet(pet1);
        appointment1.setAppointmentStart(new Timestamp(new Date().getTime()));

        AppointmentEntity appointment2 = new AppointmentEntity();
        appointment2.setPet(pet2);
        appointment2.setAppointmentStart(new Timestamp(new Date().getTime()));

        session.save(appointment1);
        session.save(appointment2);

        //****************************************************************************

        ServiceRaceEntity service1 = new ServiceRaceEntity();
        service1.setServiceName("shower");
        service1.setServicePrice(20.0);
        service1.setServiceDescribe("take a shower");

        ServiceRaceEntity service2 = new ServiceRaceEntity();
        service2.setServiceName("cut");
        service2.setServicePrice(30.0);
        service2.setServiceDescribe("cut hair");

        session.save(service1);
        session.save(service2);

        //****************************************************************************

        ServiceAppointmentREntity service_appointment1 = new ServiceAppointmentREntity();
        service_appointment1.setFinishStatus((byte) 0);
        service_appointment1.setAppointment(appointment1);
        service_appointment1.setService(service1);

        ServiceAppointmentREntity service_appointment2 = new ServiceAppointmentREntity();
        service_appointment2.setFinishStatus((byte) 0);
        service_appointment2.setAppointment(appointment1);
        service_appointment2.setService(service2);

        ServiceAppointmentREntity service_appointment3 = new ServiceAppointmentREntity();
        service_appointment3.setFinishStatus((byte) 0);
        service_appointment3.setAppointment(appointment2);
        service_appointment3.setService(service1);

        ServiceAppointmentREntity service_appointment4 = new ServiceAppointmentREntity();
        service_appointment4.setFinishStatus((byte) 0);
        service_appointment4.setAppointment(appointment2);
        service_appointment4.setService(service2);

        session.save(service_appointment1);
        session.save(service_appointment2);
        session.save(service_appointment3);
        session.save(service_appointment4);
        tx.commit();
    }

    @Test
    public void query_test() {
        String hql = "from ServiceRaceEntity where servicePrice < 30";
        Query query = session.createQuery(hql);
        List<ServiceRaceEntity> services = query.list();
        for (ServiceRaceEntity service : services) {
            System.out.println(service.toString());
        }
        ServiceRaceEntity service1 = (ServiceRaceEntity) query.uniqueResult();
        System.out.println(service1);

        tx.commit();
    }

    @Test
    public void query_test2() {
        StaffEntity staff1 = (StaffEntity) session.get(StaffEntity.class, 1);
        System.out.println(staff1.toString());
    }


    public static void main(String[] args) {
        PetRaceEntity pet_race = new PetRaceEntity();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String describe = scanner.nextLine();

        try {
            new PetRaceManager().reg_pet_race(name, describe);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
