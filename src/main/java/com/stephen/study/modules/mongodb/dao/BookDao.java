package com.stephen.study.modules.mongodb.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stephen.study.modules.mongodb.entity.Book;

@Repository("bookDao")
public class BookDao extends BasicDAO<Book, ObjectId> {

	// 实例化该类的时候注入Datastore
	// 所有的增删改查都是基于datastore的方法
	@Autowired
	public BookDao(Datastore ds) {
		super(ds);
	}

	public long findByInfo(String bookName, String authorName) {
		Query<Book> query = getDatastore().createQuery(Book.class).field("bookName").equal(bookName).field("authorName")
				.equal(authorName);
		return count(query);
	}
}
