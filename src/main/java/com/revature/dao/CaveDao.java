package com.revature.dao;

import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CaveDao
{
    public List<Cave> getAllCaves(){
        List<Cave> caves = new ArrayList<>();
        Session s = HibernateUtil.getSession();
        caves = s.createQuery("from Cave").list();
        return caves;
    }

    public int saveCave(Cave c){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        int result = (int) s.save(c);
        s.getTransaction().commit();
        return result;
    }
}
