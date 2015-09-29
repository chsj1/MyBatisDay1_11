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
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			/**
			 * ִ����Ӧ��insert���
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.insert("studentNamespace.add1");
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	public void add2(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.insert( Student.class.getName() + ".add2",student);
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	/**
	 * ���²���
	 * @param student
	 */
	public void update1(Student student){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			int i = sqlSession.update( Student.class.getName() + ".update1",student);
			//�ύ����
			sqlSession.commit();
			System.out.println("------>i: " + i);
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
	}
	
	
	/**
	 * ��ѯ����������id����ѯ
	 * @param student
	 */
	public Student findById(int id){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			/**
			 * ִ����Ӧ��insert���
			 * ��һ������:�ҵ���һ��SQL���,������namespace.sql����ID
			 * studentNamespace.add1:
			 * ȥ�ҵ�studentNamespace�е���Ϊadd1��sql���
			 * 
			 */
			Student student = sqlSession.selectOne( Student.class.getName() + ".findById",id);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return student;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * ��ѯ����������id����ѯ
	 * @param student
	 */
	public List<Student> findAll(){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAll");
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	public List<Student> findAllByPage(int startIndex,int pageSize){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("start", startIndex);
			map.put("size", pageSize);
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".findAllByPage",map);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * ��̬��ѯ
	 * @return
	 */
	public List<Student> dynamicFind(Integer id,String name,double sal){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("name", name);
			map.put("sal", sal);
			
			List<Student> students = sqlSession.selectList( Student.class.getName() + ".dynamicfind",map);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
//			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
			return students;
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
		return null;
	}
	
	
	/**
	 * ��̬����
	 * @return
	 */
	public void dynamicUpdate(Integer id,String name,Double sal){
		SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("pid", id);
			map.put("pname", name);
			map.put("psal", sal);
			
			sqlSession.update( Student.class.getName() + ".dynamicupdate",map);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
			MyBatisUtils.closeSession();
		}
		
	}
	
	public void dynamicDelete(int... ids){
SqlSession sqlSession = null;
		
		
		try{
			//�õ�SqlSession
			sqlSession = MyBatisUtils.getSession();
			
			
			sqlSession.delete( Student.class.getName() + ".dynamicdelete",ids);
			//�ύ����(�����ݿ�����ݵ�ʱ�򲢲���Ҫ�ύ����)
			sqlSession.commit();
//			System.out.println("------>i: " + i);
			
		}catch(Exception e){
			//��������쳣,���лع�
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			//�ر�SqlSession
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
		//�����Ǵ�0��ʼ
//		System.out.println(dao.findAllByPage(5,5));
		
//		System.out.println(dao.dynamicFind(4, null, 70000.0));
//		System.out.println(dao.findAll());
		
//		dao.dynamicUpdate(13, null, 75000.0);
//		dao.dynamicUpdate(12, "hjd112", null);
//		dao.dynamicUpdate(11, "hjd111", 77777.0);
		
		dao.dynamicDelete(1,3,5,7);
	}
}
