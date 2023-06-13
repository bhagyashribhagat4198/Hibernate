package one_to_one;

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

Employee e=new Employee();
e.setName("Vidula");
Address a=new Address();
a.setAddressLine("101 A");
a.setCity("pune");
a.setState("maharashtra");
a.setPincode(41000);
e.setAddress(a);
a.setEmployee(e);
session.persist(e);
t.commit();
session.close();
System.out.println("Successfully saved");
}
}