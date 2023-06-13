package many_to_many;

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
		
		Answer a1=new Answer();
		a1.setAnsname("java is a simple language");
		a1.setPostedBy("Vidula");
		Answer a2=new Answer();
		a2.setAnsname("java is a plateform independent ");
		a2.setPostedBy("Vidula");
		
		ArrayList<Answer> alist=new ArrayList<Answer>();
		alist.add(a1);
		alist.add(a2);
		
		Question q1=new Question();
		q1.setQue_name("What is java?");
		q1.setAnswer(alist);
	///////////////////////////////////////////////////////////////////	
		Answer a3=new Answer();
		a3.setAnsname("Hibernate is framework");
		a3.setPostedBy("ram");
		Answer a4=new Answer();
		a4.setAnsname("Hibernate is a ORM ");
		a4.setPostedBy("Vidula");
		
		ArrayList<Answer> alist1=new ArrayList<Answer>();
		alist1.add(a3);
		alist1.add(a4);
		
		Question q2=new Question();
		q2.setQue_name("What is Hibernate ?");
		q2.setAnswer(alist1);
		
		session.persist(q1);
		session.persist(q2);
		t.commit();
		session.close();
		System.out.println("record save successfully ");
}
}
