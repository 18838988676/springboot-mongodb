package cn.com.wmc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryOperators;
import com.mongodb.client.result.DeleteResult;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import cn.com.wmc.entity.PrescriptionVO;
import cn.com.wmc.entity.User;
import cn.com.wmc.entity.UserRepository;
import cn.com.wmc.service.impl.PrescriptionServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 @Autowired
	    private PrescriptionServiceImpl prescriptionServiceImpl;

	 
	 @Autowired
	    private MongoTemplate mongoTemplate;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //add
	 @Test
	    public void test() throws Exception {
	
	        // 创建10个User，并验证User总数
		 mongoTemplate.save(new User(1L, "didi", 30));
		 mongoTemplate.save(new User(2L, "mama", 40));
		 mongoTemplate.save(new User(3L, "kaka", 50));
		 mongoTemplate.save(new User(4L, "didi2", 30));
		 mongoTemplate.save(new User(5L, "mama", 40));
		 mongoTemplate.save(new User(6L, "kaka2", 50));
		 mongoTemplate.save(new User(7L, "kaka", 50));
		 mongoTemplate.save(new User(8L, "kao", 50));
		 mongoTemplate.save(new User(9L, "ekakae", 50));
		 mongoTemplate.save(new User(10L, "kaka5", 50));
		 mongoTemplate.save(new User(11L, "", 50));
		 mongoTemplate.save(new User(12L, null, 50));
	    }
	 
	 //delete
	 @Test
	public void testDelete() throws Exception {
		 Query query;
		
		 
		 //delete  1
		 query = Query.query(Criteria.where("username").is("kaka5"));
		 DeleteResult res= mongoTemplate.remove(query, User.class);
		 System.out.println(res);//  AcknowledgedDeleteResult{deletedCount=1}
		
		 
		 //delete 2     
//		 query = Query.query(Criteria.where("username").is("kaka2"));
		 //User 是仓库，@Document(collection="User")
//		 mongoTemplate.remove(query, "User"); 
		
		 
		 
		 //delete  3
//		 mongoTemplate.dropCollection(User.class);
//		 mongoTemplate.dropCollection("User");
		 
		//删除全部数据库 4
		// mongoTemplate.getDb().drop();
		 
		 
		 //delete 5
		//查询出符合条件的第一个结果，并将符合条件的数据删除,只会删除第一条
//		 query = Query.query(Criteria.where("username").is("kaka2"));
//		 User User = mongoTemplate.findAndRemove(query, User.class);

		 
		 //delete 6
		//查询出符合条件的所有结果，并将符合条件的所有数据删除
		// query = Query.query(Criteria.where("username").is("kaka2"));
		// List<User> articles = mongoTemplate.findAllAndRemove(query, User.class);

	}
	 
	 //find
	 @Test
	public void testFind() throws Exception {
		//find 1
//		 User qp = mongoTemplate.findOne(new Query(where("username").is("kaka2")), User.class);  
//		 System.out.println(qp);
		 
		 
		 
		 
		 //find2
		 DBObject cond = new BasicDBObject();
		//等于条件
		cond.put("sex","male");
		//非等于条件
		cond.put("age", new BasicDBObject(QueryOperators.GTE,20)
		            .append(QueryOperators.LTE,30));
		//添加or条件（和上面的条件还是and关系）
		BasicDBList orList = new BasicDBList();
		DBObject orCond1 = new BasicDBObject();
		orCond1.put("name", "lisi");
		DBObject orCond2 = new BasicDBObject();
		orCond2.put("name", "zhaoliu");
		orList.add(orCond1);
		orList.add(orCond2);
		cond.put(QueryOperators.OR, orList);
		//限制查询返回的字段
		DBObject feild = new BasicDBObject();
		feild.put("name", 1);//查询name
		feild.put("_id", 0);//_id不查询
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
	 
//	　insert，insertAll, save（当object不存在时，执行insert）。
	 
	 //update
	 @Test
	public void testUpdate() throws Exception {
		 //1   修改符合条件时如果不存在则添加
		// mongoTemplate.upsert(new Query(Criteria.where("username").is("kaka2000")), new Update().set("age", "44444"), "User");
		 
		 //修改符合条件第一条记录
		 mongoTemplate. updateFirst (new Query(Criteria.where("username").is("kaka2000")), new Update().set("age", "2015-08-08"), "User");  
		 
		 
		 //修改符合条件的所有
		 mongoTemplate. updateMulti (new Query(Criteria.where("username").is("kaka2000")), new Update().set("age", "2015-08-08"), "User");  
		 
		 
		 //BasicUpdate操作
//		 BasicUpdate  JSON格式，需要我们自己实现update SQL，BasicUpdate需要手动实现$set等操作符SQL语句，也可以使用Update的一些操作修改文档的操作方法，因为继承了Update类
		 
	}
	 
	 
	 
	 
	 //find
	 @Test
	public void testfind() throws Exception {
		 //findById
		/* Optional<User> u = userRepository.findById(1L);
		 this.logger.info(u.toString());*/
		 // delteByEntity
		/* User   u = mongoTemplate.findById(1l, User.class);
	        this.logger.info(u.toString());*/
//	        mongoTemplate.remove(object)
	        
	        
	      /* // userRepository.delete(u);
	        this.logger.info(String.valueOf(userRepository.findAll().size()));
	      
	        //deleteById
	        userRepository.deleteById(3l);
	        this.logger.info(String.valueOf(userRepository.findAll().size()));*/
	}
	 
	 
	 
	 //===================================================================================================
	 //select
	@Test
	public void testselectId() {
		PrescriptionVO prescription = prescriptionServiceImpl.selectById(40);
		System.out.println(prescription);
	}
	
	
	//select all
	@Test
	public void testSelectAll() throws Exception {
		 List<PrescriptionVO> prescriptions = prescriptionServiceImpl.list(null);
		 for (PrescriptionVO prescriptionVO : prescriptions) {
			System.out.println(prescriptionVO);
		}
	}
	
	// delete 
	@Test
	public void testdelet() throws Exception {
		int a= prescriptionServiceImpl.deleteById(7);
		System.out.println(a);
	}
	
	// delete 
		@Test
		public void testdelets() throws Exception {
			List<Integer> ids=new ArrayList<>();
			ids.add(30);
			ids.add(31);
			ids.add(32);
			int a= prescriptionServiceImpl.deleteByIds(ids);
			System.out.println(a);
		}
	
	//add
	@Test
	public void testadd() throws Exception {
		PrescriptionVO prescription=new PrescriptionVO();
		prescription.setClassifyid(1);
		prescription.setDiagnosis("处方诊断");
		prescription.setDoctorid(1);
		prescription.setIsvalid(1);
		prescription.setNatureid(1);
		prescription.setNote("this is note");
		prescription.setPrescriptioncode("prescriptioncode");
		prescription.setRegisterid(1);
		prescription.setPrescriptionname("setPrescriptionname");
		prescription.setPrescriptiontypeid(1);
		prescription.setPrescriptiontime(new Date());
		prescriptionServiceImpl.insert(prescription);
	}
	
	
	@Test
	public void testadds() throws Exception {
		PrescriptionVO prescription=new PrescriptionVO();
		for (int i = 0; i < 50; i++) {
			prescription.setClassifyid(1);
			prescription.setDiagnosis(i+"  处方诊断");
			prescription.setDoctorid(1);
			prescription.setIsvalid(1);
			prescription.setNatureid(1);
			prescription.setNote(i+"  this is note");
			prescription.setPrescriptioncode(i+"  prescriptioncode");
			prescription.setRegisterid(1);
			prescription.setPrescriptionname(i+"  setPrescriptionname");
			prescription.setPrescriptiontypeid(1);
			prescription.setPrescriptiontime(new Date());
			prescriptionServiceImpl.insert(prescription);
		}
	}
	
	
	
	//update
		@Test
		public void testupdate() throws Exception {
			PrescriptionVO prescriptionVO=new PrescriptionVO();
			prescriptionVO.setId(13);
			prescriptionVO.setRegisterid(0000);
			prescriptionServiceImpl.updateById(prescriptionVO);
		}
	
	
	
	
	
	
	
	
	
	

}
