package one_to_one;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ReadData {

public static void main(String[] args) {
		
		StandardServiceRegistry ssr=
				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		
		Session session =factory.openSession();

		Query query =session.createQuery("from Employee");

		List<Employee> list=query.getResultList();

		Iterator<Employee> itr= list.iterator();
		
		while(itr.hasNext()){
			Employee e=itr.next();
			System.out.println(e.getId()+" "+e.getName());
			
			Address a=e.getAddress();
			System.out.println(a.getAddressid()+" "+a.getAddressLine()+" "+a.getCity()
			+" "+a.getState()+" "+a.getPincode());
			
			session.close();
			System.out.println("successfully show");
		}

}
}