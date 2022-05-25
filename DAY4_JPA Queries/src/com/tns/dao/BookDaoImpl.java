package com.tns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tns.entitie.Book;

public class BookDaoImpl implements BookDao
{
	private EntityManager entityManager;

	public BookDaoImpl() {
		
		entityManager=JPAUtil.getEntityManager();
		
	}

	@Override
	public Book getBookById(int id) {
		Book book=entityManager.find(Book.class,id);
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		String qStr = "SELECT book FROM Book book WHERE book.title=:ptitle";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("ptitle", "%"+title+"%");
		return query.getResultList();
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		String qStr = "SELECT book FROM Book book WHERE book.author=:pAuthor";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("pAuthor",author);
		List<Book>booklist=query.getResultList();
		
		return booklist;
	}

	@Override
	public List<Book> getBookInPriceRange(double low, double high) {
		String qStr = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
		query.setParameter("low",low);
		query.setParameter("high",high);

		List<Book>booklist=query.getResultList();
		
		return booklist;
	}

	@Override
	public List<Book> getAllBooks() {
		Query query=entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<Book>booklist=query.getResultList();
		
		return booklist;
	}

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.id) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count=query.getSingleResult();
		return count;
	}

}