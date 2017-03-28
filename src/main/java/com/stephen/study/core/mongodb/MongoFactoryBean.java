package com.stephen.study.core.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

public class MongoFactoryBean extends AbstractFactoryBean<MongoClient> {

	/**
	 * 表示服务器列表
	 */
	private String[] serverStrings;

	/**
	 * mongo配置对象，使用默认配置
	 */
	private MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();

	/**
	 * 是否主从分离，默认为false
	 */
	private boolean readSecondary = false;

	public String[] getServerStrings() {
		return serverStrings;
	}

	public void setServerStrings(String[] serverStrings) {
		this.serverStrings = serverStrings;
	}

	public MongoClientOptions getMongoClientOptions() {
		return mongoClientOptions;
	}

	public void setMongoClientOptions(MongoClientOptions mongoClientOptions) {
		this.mongoClientOptions = mongoClientOptions;
	}

	public boolean isReadSecondary() {
		return readSecondary;
	}

	public void setReadSecondary(boolean readSecondary) {
		this.readSecondary = readSecondary;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoClient.class;
	}

	@Override
	protected MongoClient createInstance() throws Exception {
		MongoClient mongoClient = null;
		// MongoCredential credential = MongoCredential.createCredential("user", "mydb", "password".toCharArray());
		/*
		 * if (null != mongoClientOptions) { 
		 * mongoClient = new MongoClient(getServerList(), Arrays.asList(credential), mongoClientOptions); 
		 * } else { 
		 * mongoClient = new MongoClient(getServerList(), Arrays.asList(credential)); 
		   *   }
		 */

		if (null != mongoClientOptions) {
			mongoClient = new MongoClient(getServerList(), mongoClientOptions);
		} else {
			mongoClient = new MongoClient(getServerList());
		}

		// 设定主从分离
		if (readSecondary) {
			mongoClient.setReadPreference(ReadPreference.secondaryPreferred());
		}
		return mongoClient;
	}

	/**
	 * 根据服务器字符串列表，解析出服务器对象列表
	 */
	private List<ServerAddress> getServerList() throws Exception {
		List<ServerAddress> serverList = new ArrayList<>();
		try {
			for (String serverString : serverStrings) {
				String[] temp = serverString.split(":");
				String host = temp[0];
				if (temp.length > 2) {
					throw new IllegalArgumentException("Invalid server address string:" + serverString);
				}
				if (temp.length == 2) {
					serverList.add(new ServerAddress(host, Integer.parseInt(temp[1])));
				} else {
					serverList.add(new ServerAddress(host));
				}
			}
			return serverList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while converting serverString to ServerAddressList", e);
		}
	}
}
