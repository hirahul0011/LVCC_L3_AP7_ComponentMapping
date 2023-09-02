package com.ecommerce;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
    private static SessionFactory sessionFactory = null;
	
	static {
		try {
			
			//This block from 18 to 21 is working fine
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			        .configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
			//This block from 24 to 29 is working fine but specific to annotated classes
//			Configuration configuration=new Configuration().configure();
//			configuration.addAnnotatedClass(EProduct.class);
//			configuration.addFile("Eproduct.hbm.xml");
//			StandardServiceRegistryBuilder builder=
//					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//			sessionFactory = configuration.buildSessionFactory(builder.build());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
	}



}
