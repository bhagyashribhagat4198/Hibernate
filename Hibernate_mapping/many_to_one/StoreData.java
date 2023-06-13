package many_to_one;

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
		Employee e1=new Employee();
		e1.setName("Vidula");
		e1.setEmail("vidula@gmail.com");
		
		Employee e2=new Employee();
		e2.setName("Kritika");
		e2.setEmail("kritika@gmail.com");
		
		Address a1=new Address();
		a1.setCity("pune");
		
		e1.setAddress(a1);
		e2.setAddress(a1);
		session.persist(e1);
		session.persist(e2);
		t.commit();
		session.close();
		System.out.println("record save successfully");
}
}
