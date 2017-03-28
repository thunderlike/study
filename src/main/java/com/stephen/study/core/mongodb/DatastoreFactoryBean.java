package com.stephen.study.core.mongodb;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.MongoClient;

public class DatastoreFactoryBean extends AbstractFactoryBean<Datastore> {

	/**
	 * morphia实例，最好是单例
	 */
	private Morphia morphia;

	/**
	 * mongoClient实例，最好是单例
	 */
	private MongoClient mongoClient;

	/**
	 * 数据库名
	 */
	private String dbName;

	/**
	 * 用户名，可为空
	 */
	private String username;

	/**
	 * 密码，可为空
	 */
	private String password;

	public Morphia getMorphia() {
		return morphia;
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isToEnsureIndexes() {
		return toEnsureIndexes;
	}

	public void setToEnsureIndexes(boolean toEnsureIndexes) {
		this.toEnsureIndexes = toEnsureIndexes;
	}

	public boolean isToEnsureCaps() {
		return toEnsureCaps;
	}

	public void setToEnsureCaps(boolean toEnsureCaps) {
		this.toEnsureCaps = toEnsureCaps;
	}

	/**
	 * 是否确认索引存在，默认false
	 */
	private boolean toEnsureIndexes = false;

	/**
	 * 是否确认caps存在，默认为false
	 */
	private boolean toEnsureCaps = false;

	@Override
	public Class<?> getObjectType() {
		return Datastore.class;
	}

	@Override
	protected Datastore createInstance() throws Exception {
		// 这里的username和password可以为null，morphia对象会去处理
		Datastore ds = morphia.createDatastore(mongoClient, dbName);
		if (toEnsureIndexes) {
			ds.ensureIndexes();
		}
		if (toEnsureCaps) {
			ds.ensureCaps();
		}
		return ds;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		if (mongoClient == null) {
			throw new IllegalStateException("mongoClient is not set");
		}
		if (morphia == null) {
			throw new IllegalStateException("morphia is not set");
		}
	}
}
