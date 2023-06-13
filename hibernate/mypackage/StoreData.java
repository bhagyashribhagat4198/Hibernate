package mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {
		
	StandardServiceRegistry	 ssr= 
			new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory factory =meta.getSessionFactoryBuilder().build();	
	Session session =factory.openSession();	
	Transaction t=session.beginTransaction();
	Employee e=new Employee();
	e.setId(102);
	e.setName("Kritika");
	e.setDesignation("Trainer");
	session.save(e);
	t.commit();
	System.out.println("Successfully record save");
	factory.close();
	session.close();
	}
}
