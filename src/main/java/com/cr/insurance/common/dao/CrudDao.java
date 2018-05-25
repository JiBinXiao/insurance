package com.cr.insurance.common.dao;

import java.util.List;

public interface CrudDao<T>{
	
	//增加
	int insert(T entity);
	
	//修改
	int update(T entity);
	
	//通过id查询
	T get(int id);
	
	//得到所有
	List<T> findAll();
	
	//删除
	int delete(T entity);
}
