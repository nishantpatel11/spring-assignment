package com.nishu.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Common {

	
	
	
//	BigInteger ccId=emailOperationVo.getCcId();
//	
//	List<EmailFolderCountObjectVo> emailFolderCountObjectVoList = new ArrayList<EmailFolderCountObjectVo>();
//
//	List<Object[]> emailFolderCountObjectVoObjectList =  new ArrayList<Object[]>();
//
//	Map<String,Object> paramsKayAndValues=new HashMap<String,Object>();
//	paramsKayAndValues.put("connectionCordId", ccId);
//
//	emailFolderCountObjectVoObjectList = systemEmailHasCCDao.listCompositeSqlQuery(SystemEmailHasCCDao.findAllSeIdByCCId, paramsKayAndValues);
//
//	try {
//		List<Object> emailFolderCountObjectVoObject = systemEmailHasCCDao.convertToObjectList(emailFolderCountObjectVoObjectList, new EmailFolderCountObjectVo(), null, null);
//		emailFolderCountObjectVoList = mapper.readValue(gson.toJson(emailFolderCountObjectVoObject), new TypeReference<List<EmailFolderCountObjectVo>>() {
//		});
//
//	}
//	catch (Exception e) {
//		e.printStackTrace();
//	}
	
	
	public List<Object> convertToObjectList(List<Object[]> objArrayList, Object object, List<String> excludedFieldNames, List<String> includedFieldNames)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		List<Object> ObjectList = new ArrayList<>();

		for (Object[] obj : objArrayList) {
			Class<?> cls = object.getClass();
			object = cls.newInstance();
			Field[] fields = cls.getDeclaredFields();

			int i = 0;
			for (Field field : fields)
				if (includedFieldNames != null) {
					if (includedFieldNames.contains(field.getName())) {
						field.setAccessible(true);
						field.set(object, obj[i]);
						i++;
					}
				}
				else {
					if ("serialVersionUID".equalsIgnoreCase(field.getName()) || excludedFieldNames != null && excludedFieldNames.contains(field.getName()))
						continue;
					field.setAccessible(true);
					field.set(object, obj[i]);
					i++;
				}

			ObjectList.add(object);
		}

		return ObjectList;
	}

}
