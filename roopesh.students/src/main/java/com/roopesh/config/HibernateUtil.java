package com.roopesh.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration configuration = new Configuration().configure();
        StandardServiceRegistry serviceRegistryBuilder = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistryBuilder).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        return sessionFactory;
	}

}
