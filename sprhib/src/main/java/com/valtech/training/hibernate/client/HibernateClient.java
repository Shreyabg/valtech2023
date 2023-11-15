package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.OrderSummary;
import com.valtech.training.hibernate.OrderSummaryId;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws HibernateException, ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();

		cfg.addAnnotatedClass(Employee.class);

		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class);

		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);

		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);
		
		cfg.addAnnotatedClass(OrderSummary.class);
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		ses.persist(new OrderSummary(1,2,3));
		OrderSummary os=(OrderSummary)ses.load(OrderSummary.class, new OrderSummaryId(1,2));
		System.out.println("Qty= " +os.getQuantity());
		
		ses.persist(new BankAccount(new BankAccountId("SB",1),30000));
		
		BankAccountId id=new BankAccountId("SB",1);
		BankAccount ba=(BankAccount)ses.load(BankAccount.class,id);
		
		

//		Customer cus = new Customer("Abc", 23);
//		ses.save(cus);
//		Address add = new Address("JP Nagar", "Blr", 560078);
//		add.setCustomer(cus);
//		cus.setAddress(add);
//		ses.save(add);
////
//		Account acc = new Account(1000, "SB");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 123123, 34435);
//		Tx tx3 = new TellerTx(3000, 123, 345);
//		Tx tx4 = new AtmTx(5000, 789);
//
//		Account acc1 = new Account(20000, "CA");
//		Tx tx5 = new ChequeTx(2000, 456233, 345124);
//
//		Customer cus1 = new Customer("Def", 25);
//		Customer cus2 = new Customer("Pqr", 27);
//		Address add1 = new Address("jayanagar", "Blr", 5600070);
//		Address add2 = new Address("Gandhinagar", "hyd", 560055);
////
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
////
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//
//		acc1.addTx(tx5);
//		acc1.addCustomer(cus2);
//		acc1.addCustomer(cus);
//		acc.addCustomer(cus1);
//		acc.addCustomer(cus2);
//		acc.addCustomer(cus);
//
//		ses.save(new Tx(1000));//1 insertion
//		ses.save(new ChequeTx(2000,123123,34435));//2 insertion
//		ses.save(new TellerTx(3000,123,345));//2 insertion
//		ses.save(new AtmTx(5000,789));// 2 insertionS
//  
		
//		Query query =ses.createQuery("Select Distinct c from Customer c join c.accounts a join a.txs t where t.amount>? ");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));
		
		
		
		//Query query=ses.createQuery("Select t from Tx t join t.account.customers c where c.address.city= ? and t.amount > ?");
		
		Query query=ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
		query.setString(0, "Blr");
		query.setFloat(1, 3000);
		query.list().forEach(t -> System.out.println(t));
		
		
		
		//ses.createQuery("Select distinct tx from Tx tx").list().forEach(t -> System.out.println(t));
		//ses.createQuery("Select distinct tx.account from Tx tx").list().forEach(t -> System.out.println(t));
		//ses.createQuery("Select tx.account from Tx tx").list().forEach(t -> System.out.println(t));
		//ses.createQuery("from Tx tx").list().forEach(t -> System.out.println(t));// it calls tostring method

		// ses.persist(new Employee("Abc",LocalDate.of(1947, 8, 15),20000,'M',false));
//		int id=(Integer)ses.save(new Employee("Abc",df.parse("15-08-1947"),20000,'M',false));
//		System.out.println(id);

//		Employee e=(Employee)ses.load(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Abc2");
//		//e.setName("Abc");
//		//ses.merge(e);
//		e.setName("Abc1");

		System.out.println("loading..");
		tx.commit();
		ses.close();
		sesFac.close();

	}

}
