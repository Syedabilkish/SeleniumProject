package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcel2Read;
import com.training.readexcel.ApachePOIExcelRead;

public class SignUpDataProvider_077 {
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getFirstName(); 
			obj[3] = temp.getEmail_id();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName = "C:/Users/IBM_ADMIN/Desktop/SELENIUM/ELTC_077.xlsx";

		List<List<Object>> retVal = ApachePOIExcel2Read.getExcelContent(fileName);
		System.out.println("size " + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[7]; 
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));
			System.out.println(temp.get(2));
			System.out.println(temp.get(3));
			System.out.println(temp.get(4));
			System.out.println(temp.get(5));

			obj[0] = temp.get(0); 
			obj[1] = temp.get(1);
			obj[2] = temp.get(2); 
			obj[3] = temp.get(3);
			obj[4] = temp.get(4); 
			obj[5] = temp.get(5);
			obj[6] = temp.get(6);
			
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
	
	
}

