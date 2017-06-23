//package com.plateno.dao.mongo.service;
//
//import java.util.List;
//
//import org.mongodb.morphia.query.Query;
//import org.mongodb.morphia.query.UpdateOperations;
//
//import com.plateno.dao.mongo.model.HotelInfo;
//
//public interface HotelInService {
//
//	/**
//	 * 保存酒店信息到mongodb
//	 * @param hotelInfo
//	 */
//	public void saveHotelInfo(HotelInfo hotelInfo);
//	
//	/**
//	 * 保存酒店信息集合到mongodb
//	 * @param hotelInfos
//	 */
//	public void saveHotelInfos(List<HotelInfo> hotelInfos);
//	
//	/**
//	 * 根据酒店属性从mongodb中删除酒店信息
//	 * @param field
//	 * @param value
//	 */
//	public void deleteHotelInfoByField(String field,Object value);
//	
//	/**
//	 * 删除mongodb中的所有酒店信息
//	 */
//	public void deleteAllHotelInfos();
//	
//	/**
//	 * 根据objectId获取mongodb中的酒店信息
//	 * @param objectId
//	 * @return
//	 */
//	public HotelInfo getHotelInfoByObjectId(String objectId);
//	
//	/**
//	 * 根据酒店属性在mongodb中获取酒店信息集合
//	 * @param field
//	 * @param value
//	 * @return
//	 */
//	public List<HotelInfo> getHotelInfosByField(String field,Object value);
//	
//	/**
//	 * 根据酒店属性在mongodb中修改酒店信息
//	 * @param query
//	 * @param operations
//	 */
//	public void updateHotelInfoByField(Query<HotelInfo> query,UpdateOperations<HotelInfo> operations);
//
//}
