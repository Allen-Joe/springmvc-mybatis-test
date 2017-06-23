package com.plateno.common.designpattern.command.ATMexample.observer;

import java.util.Vector;

import com.plateno.common.designpattern.command.ATMexample.vo.UserTradeRecord;

public class UserTradeRecordObserver implements Observer{
	
	private static final Vector<UserTradeRecord> records=new Vector<UserTradeRecord>();

	public void update(UserTradeRecord tradeRecord) {
		// TODO Auto-generated method stub
		records.add(tradeRecord);
	}
	
	public static Vector<UserTradeRecord> getRecords(){
		return records;
	}

}
