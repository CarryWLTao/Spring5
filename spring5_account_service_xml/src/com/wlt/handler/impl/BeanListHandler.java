package com.wlt.handler.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.wlt.handler.ResultSetHandler;

public class BeanListHandler<T> implements ResultSetHandler {
	private Class<T> domainClass;
    public BeanListHandler(Class<T> domainClass) {
		this.domainClass=domainClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> handler(ResultSet rs) {
		T obj=null;
		List<T> list=null;
		try {
            //1.创建一个实体类对象
            list=new ArrayList<T>();
            //2.判断是否有结果集
            while (rs.next())
            {
              obj = this.domainClass.newInstance();
              
              ResultSetMetaData rsmd = rs.getMetaData();
              
              int columnCount = rsmd.getColumnCount();
              for (int i = 1; i <= columnCount; i++)
              {
                String columnName = rsmd.getColumnName(i);
                
                PropertyDescriptor pd = new PropertyDescriptor(columnName, this.domainClass);
                
                Method method = pd.getWriteMethod();
                
                Object columnValue = rs.getObject(columnName);
                
                method.invoke(obj, new Object[] { columnValue });
                
              }
            list.add(obj);
            }
            return list;
          }
          catch (Exception e)
          {
            throw new RuntimeException(e);
          }
        }
}
