//package com.plateno.dao.mongo.dao;
//
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.dao.BasicDAO;
//import org.mongodb.morphia.query.Query;
//import org.mongodb.morphia.query.UpdateOperations;
//import org.mongodb.morphia.query.UpdateResults;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//public abstract class BaseMongoDao<T> {
//
//	@Resource
//	@Qualifier("kfDataStore")
//	private Datastore datastore;
//	
//	protected BasicDAO<T, String> basicDao;
//	
//	@PostConstruct
//	public void init(){
//		this.basicDao=new BasicDAO<T, String>(this.getEntityClass(), this.datastore);
//		this.basicDao.ensureIndexes();
//	}
//	
//	public void save(T entity){
//		this.basicDao.getDatastore().save(entity);
//	}
//	
//	public void saveList(List<T> entities){
//		this.basicDao.getDatastore().save(entities);
//	}
//	
//	public void removeAll(){
//		this.basicDao.getDatastore().delete(this.datastore.createQuery(this.getEntityClass()));
//	}
//	
//	public void removeByField(String field,Object value){
//		this.basicDao.getDatastore().delete(this.datastore.find(this.getEntityClass(), field+"=", value));
//	}
//	
//	public List<T> listByField(String field,Object value){
//		return this.datastore.find(this.getEntityClass(), field+"=", value).asList();
//	}
//	
//	public T get(String objectId){
//		return this.datastore.get(this.getEntityClass(),objectId);
//	}
//	
//	public List<T> ListAll(){
//		return this.datastore.find(this.getEntityClass()).asList();
//	}
//	
//	public UpdateResults update(Query<T> query,UpdateOperations<T> operations){
//		return this.datastore.update(query, operations);
//	}
//	
//	public void updateFieldAll(String field,Object value){
//		this.datastore.update(this.datastore.find(this.getEntityClass()), this.datastore.createUpdateOperations(getEntityClass()).set(field, value));
//	}
//	
//	public abstract Class<T> getEntityClass();
//	
//	protected Datastore getDatastore(){
//		return this.basicDao.getDatastore();
//	}
//}
