import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class MongoDBJDBC {
   public static void main(String[] args) {	
		try {
			    //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
	            //ServerAddress()两个参数分别为 服务器地址 和 端口  
			   ServerAddress serverAddress=new ServerAddress("localhost",27017);
			   List<ServerAddress> addrs=new ArrayList<ServerAddress>();
			   addrs.add(serverAddress);
			   
			   //Mongo 需要验证用户名及密码
//			   MongoCredential credential=MongoCredential.createScramSha1Credential("username","test","password".toCharArray());	   
//			   List<MongoCredential> credentials=new ArrayList<MongoCredential>();
//			   credentials.add(credential);
			   
			   //通过连接认证获取MongoDB连接
//			   MongoClient mongoClient=new MongoClient(addrs,credentials);
			   
			   //Mongo 数据库无需用户名密码验证
			   MongoClient mongoClient=new MongoClient(addrs);
			   
			   //连接到数据库
			   MongoDatabase mongoDatabase=mongoClient.getDatabase("test");
			   System.out.println("connect to mongoDataBase successfully");
			   
			   //创建集合
//			   mongoDatabase.createCollection("mycollection");			   
//			   System.out.println("create collection successfully");
			   
			   //获取集合
			   MongoCollection<Document> collection=mongoDatabase.getCollection("col");
			   System.out.println("集合 col 选择成功");
			   
			   //插入文档
	           /** 
	           * 1. 创建文档 org.bson.Document 参数为key-value的格式 
	           * 2. 创建文档集合List<Document> 
	           * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
	           * */
//			   Document document=new Document("title","mongoDb");
//			   document.append("brief", "not only sql");
//			   document.append("version", "3.2.2");
//			   document.append("curTime","2016-6-14");
//			   
//			   List<Document> documents=new ArrayList<Document>();
//			   documents.add(document);
//			   collection.insertMany(documents);
//			   System.out.println("文档 插入成功");
			   
			   //检索某集合的所有文档
			   FindIterable<Document> findIterable=collection.find();
			   MongoCursor<Document> mongoCursor=findIterable.iterator();
			   while(mongoCursor.hasNext()){
				   System.out.println(mongoCursor.next());
				   System.out.println("检索成功");
			   }
			   
			   //删除文档
			   //删除符合条件的第一个文档
//			   collection.deleteOne(Filters.eq("version", "3.2.3"));
			   //删符合条件的所有文档
//			   collection.deleteMany(Filters.eq("version", "3.2.3"));
			   
			   //更新文档
//			   collection.updateMany(Filters.eq("version", "3.2.2"), new Document("$set", new Document("version", "3.2.3")));
//			   while(mongoCursor.hasNext()){
//				   System.out.println(mongoCursor.next());
//				   System.out.println("检索成功");
//			   }
			   
			   
			   
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
   }
}
