//package com.plateno.dao.mongo.service.Impl;
//
//import java.util.List;
//
//import org.mongodb.morphia.query.Query;
//import org.mongodb.morphia.query.UpdateOperations;
//import org.mongodb.morphia.query.UpdateResults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.plateno.dao.mongo.dao.HotelInfoDao;
//import com.plateno.dao.mongo.model.HotelInfo;
//import com.plateno.dao.mongo.service.HotelInService;
//
//@Service("hotelInfoService")
//public class HotelInfoServiceImpl implements HotelInService{
//	
//	@Autowired
//	private HotelInfoDao hotelInfoDao;
//
//	public void saveHotelInfo(HotelInfo hotelInfo) {
//		// TODO Auto-generated method stub
//		this.hotelInfoDao.save(hotelInfo);
//		
//	}
//
//	public void saveHotelInfos(List<HotelInfo> hotelInfos) {
//		// TODO Auto-generated method stub
//		this.hotelInfoDao.saveList(hotelInfos);
//		
//	}
//
//	public void deleteHotelInfoByField(String field, Object value) {
//		// TODO Auto-generated method stub
//		this.hotelInfoDao.removeByField(field, value);
//	}
//
//	public void deleteAllHotelInfos() {
//		// TODO Auto-generated method stub
//		this.hotelInfoDao.removeAll();
//		
//	}
//
//	public HotelInfo getHotelInfoByObjectId(String objectId) {
//		// TODO Auto-generated method stub
//		return this.hotelInfoDao.get(objectId);
//	}
//
//	public List<HotelInfo> getHotelInfosByField(String field, Object value) {
//		// TODO Auto-generated method stub
//		return this.getHotelInfosByField(field, value);
//	}
//
//	public void updateHotelInfoByField(Query<HotelInfo> query,
//			UpdateOperations<HotelInfo> operations) {
//		// TODO Auto-generated method stub
//		UpdateResults result=this.hotelInfoDao.update(query, operations);
//		System.out.println(result.getUpdatedExisting());
//		
//	}
//
//	
//
//}
