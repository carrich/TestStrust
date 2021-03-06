package com.exam.model;

import com.exam.entity.Order;
import com.exam.entity.OrderDetail;
import com.exam.entity.Product;
import com.exam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductModel {

    private SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
    private List<Product> products;


    @SuppressWarnings({"rawtypes", "unchecked"})
//    public List<Product> findAll() {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            org.hibernate.query.Query query = session.createQuery("from Product");
//            products = query.list();
//            transaction.commit();
//        } catch (Exception e) {
//            products = null;
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return products;
//    }
    public void checkout(Order order) {
        Product product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            product = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }


//    public Product find(int id) {
//        Product product = null;
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            org.hibernate.query.Query query = session.createQuery("from Product where id = :id");
//            query.setParameter("id", id);
//            product = (Product) query.uniqueResult();
//            transaction.commit();
//        } catch (Exception e) {
//            product = null;
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return product;
//    }
}
