package one_to_many;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreQue_Ans {

public static void main(String[] args) {
		
		StandardServiceRegistry ssr=
				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		
		Session session =factory.openSession();
		Transaction t =session.beginTransaction();
		
	Answer a=new Answer();
	a.setAns_name("java is a programming language.");
	a.setPostedBy("Vidula");
	
	Answer a1=new Answer();
	a1.setAns_name("java is a oop language.");
	a1.setPostedBy("ram");
		
		ArrayList<Answer>  list=new ArrayList<Answer>();
		list.add(a);
		list.add(a1);
		
		Question q=new Question();
		
		q.setQue_name("What is Java?");
		q.setAnswer(list);
		session.persist(q);
		t.commit();
		session.close();
		System.out.println("Save successfully");
}
}
