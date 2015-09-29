package com.hjd.mybatis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class StudentDao {
	public void add1(){
		SqlSession sqlSession = null;
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			/**
			 * 执行相应的insert语句
			 * studentNamespace.add1:
			 * 去找到studentNamespace中的名为add1的sql语句
			 * 
			 */
			int i = sqlSession.insert("studentNamespace.add1");
			//提交事务
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	public void add2(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * 执行相应的insert语句
			 * 第一个参数:找到这一个SQL语句,规则是namespace.sql语句的ID
			 * studentNamespace.add1:
			 * 去找到studentNamespace中的名为add1的sql语句
			 * 
			 */
			int i = sqlSession.insert( Student.class.getName() + ".add2",student);
			//提交事务
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	/**
	 * 更新操作
	 * @param student
	 */
	public void update1(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * 执行相应的insert语句
			 * 第一个参数:找到这一个SQL语句,规则是namespace.sql语句的ID
			 * studentNamespace.add1:
			 * 去找到studentNamespace中的名为add1的sql语句
			 * 
			 */
			int i = sqlSession.update( Student.class.getName() + ".update1",student);
			//提交事务
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	
	/**
	 * 查询操作：根据id来查询
	 * @param student
	 */
	public Student findById(int id){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * 执行相应的insert语句
			 * 第一个参数:找到这一个SQL语句,规则是namespace.sql语句的ID
			 * studentNamespace.add1:
			 * 去找到studentNamespace中的名为add1的sql语句
			 * 
			 */
			Student student = sqlSession.selectOne( Student.class.getName() + ".findById",id);
			//提交事务(从数据库读数据的时候并不需要提交事务)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return student;
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * 查询操作：根据id来查询
	 * @param student
	 */
	public List<Student> findAll(){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAll");
			//提交事务(从数据库读数据的时候并不需要提交事务)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	public List<Student> findAllByPage(int startIndex,int pageSize){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("start", startIndex);
			map.put("size", pageSize);
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAllByPage",map);
			//提交事务(从数据库读数据的时候并不需要提交事务)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * 动态查询
	 * @return
	 */
	public List<Student> dynamicFind(Integer id,String name,double sal){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("name", name);
			map.put("sal", sal);
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".dynamicfind",map);
			//提交事务(从数据库读数据的时候并不需要提交事务)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * 动态更新
	 * @return
	 */
	public void dynamicUpdate(Integer id,String name,Double sal){
		SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("pid", id);
			map.put("pname", name);
			map.put("psal", sal);
			
			sqlSession.update( Student.class.getName() + ".dynamicupdate",map);
			//提交事务(从数据库读数据的时候并不需要提交事务)
			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
	}
	
	public void dynamicDelete(int... ids){
SqlSession sqlSession = null;
		
		
		try{
			//拿到SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			sqlSession.delete( Student.class.getName() + ".dynamicdelete",ids);
			//提交事务(从数据库读数据的时候并不需要提交事务)
			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
		}catch(Exception e){
			//如果反生异常,进行回滚
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//关闭SqlSession
			MyBatisUtils.closeSession();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
//		Student student = new Student(3,"hjd33333",80000.0);
//		dao.add2(student);
//		dao.update1(student);
//		Student student1 = dao.findById(2);
//		System.out.println(student1);
		
		
//		int i;
//		for(i = 0 ; i < 10 ; ++i){
//			dao.add2(new Student(i+4,"hjd" + (i+4),70000.0));
//		}
		//索引是从0开始
//		System.out.println(dao.findAllByPage(5,5));
		
//		System.out.println(dao.dynamicFind(4, null, 70000.0));
//		System.out.println(dao.findAll());
		
//		dao.dynamicUpdate(13, null, 75000.0);
//		dao.dynamicUpdate(12, "hjd112", null);
//		dao.dynamicUpdate(11, "hjd111", 77777.0);
		
		dao.dynamicDelete(1,3,5,7);
	}
}
