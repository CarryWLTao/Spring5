package com.wlt.handler.impl;

import com.wlt.handler.ResultSetHandler;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BeanHandler<T> implements ResultSetHandler {
	private Class<T> domainClass;

    public BeanHandler(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    /**
     * ��rs�����ݷ�װ��domainClass����ʾ������
     * @param rs
     * @return
     */
    @SuppressWarnings("unchecked")
	@Override
    public <T> T handler(ResultSet rs) {
        try {
            //1.����һ��ʵ�������
            Object bean = domainClass.newInstance();
            //2.�ж��Ƿ��н����
            if(rs.next()){
                //3.�õ������rs�����е�����
                //Ҫ��õ����������ȵõ��������Դ��Ϣ
                ResultSetMetaData rsmd = rs.getMetaData();
                //�õ�Դ��Ϣ֮�󣬻�Ҫ�õ��ж�����
                int columnCount = rsmd.getColumnCount();
                //��������
                for(int i=1;i<=columnCount;i++){
                    //�õ�ÿ�е�����
                    String columnName = rsmd.getColumnName(i);
                    //������ʵ����ʵ������������ƣ����ǾͿ���ʹ�������õ�ʵ���������Ե�������
                    PropertyDescriptor pd = new PropertyDescriptor(columnName,domainClass);//ʵ�����ж����˽�����Ա������get�Լ�set����
                    //��ȡ���Ե�д�뷽��(set����)
                    Method method = pd.getWriteMethod();
                    //��ȡ��ǰ��������Ӧ��ֵ
                    Object columnValue = rs.getObject(columnName);
                    //ͨ��ִ��д�����ѵõ���ֵ�����Ը���
                    method.invoke(bean,columnValue);
                }
            }
            //4.����
            return (T) bean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
	

}
