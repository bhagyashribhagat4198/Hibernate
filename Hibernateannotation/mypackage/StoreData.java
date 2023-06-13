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
		
		StandardServiceRegistry ssr=
				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		
		Session session =factory.openSession();
		Transaction t =session.beginTransaction();
		
		Teacher obj=new Teacher();
		obj.setId(101);
		obj.setName("Vidula");
		obj.setSubject("java");
		
		session.save(obj);
		t.commit();
		System.out.println("Record save successfully");
		
		factory.close();
		session.close();
	}
}
