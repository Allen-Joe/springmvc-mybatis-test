package com.plateno.common.observer;

import java.util.Vector;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @描述：观察者模式--被观察者抽象类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月16日上午9:55:36
 * @version v1.0
 */
public abstract class Subject {
	
	//定义一个变长的集合用于存放观察者
	private Vector<Observer> observers=new Vector<Observer>();
	
	//添加观察者
	public void addObserver(Observer o){
		this.observers.add(o);
	}
	
	//删除观察者
	public void delObserver(Observer o){
		this.observers.remove(o);
	}
	
	//通知观察者
	public void noitifyObserver(String message){
		if(CollectionUtils.isNotEmpty(observers)){
			for (Observer observer : observers) {
				observer.update(message);
			}
		}
	}

}
