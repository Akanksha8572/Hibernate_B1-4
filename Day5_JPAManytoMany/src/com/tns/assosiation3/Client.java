package com.tns.assosiation3;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();



		Product mobile1 = new Product();
		mobile1.setId(1);
		mobile1.setName("Samsung");
		mobile1.setPrice(55000);

		Product mobile2 = new Product();
		mobile2.setId(2);
		mobile2.setName("Iphone 13");
		mobile2.setPrice(180000);

		Product mobile3 = new Product();
		mobile3.setId(3);
		mobile3.setName("Mi note 11");
		mobile3.setPrice(15000);

		Product mobile4 = new Product();
		mobile4.setId(4);
		mobile4.setName("Vivo v15");
		mobile4.setPrice(25000);


		Order firstOrder = new Order();
		firstOrder.setId(1000);
		firstOrder.setPurchaseDate(new Date());

		firstOrder.addProduct(mobile3);
		firstOrder.addProduct(mobile1);
		firstOrder.addProduct(mobile2);

		Order secondOrder = new Order();
		secondOrder.setId(1001);
		secondOrder.setPurchaseDate(new Date());

		secondOrder.addProduct(mobile3);		
		secondOrder.addProduct(mobile1);
		secondOrder.addProduct(mobile4);


		em.persist(firstOrder);
		em.persist(secondOrder);
		
		System.out.println("Added orders to db");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}