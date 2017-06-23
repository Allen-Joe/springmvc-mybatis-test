

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plateno.pojo.MemberInfo;
import com.plateno.service.MemberInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class Test {

	@Autowired
	private MemberInfoService memberInfoService=null;
	
	@org.junit.Test
	public void testGetMemberById(){
		MemberInfo member=memberInfoService.getMemberById(1);
		System.out.println("姓名："+member.getName());
		System.out.println("性别："+("1".equals(member.getSex())?"男":"女"));
		System.out.println("年龄："+member.getAge());
	}
	
	@org.junit.Test
	public void testAddMember(){
		MemberInfo member=new MemberInfo();
		member.setName("卡特琳娜");
		member.setSex("2");
		member.setAge(25);
		memberInfoService.addMember(member);
	}

	@org.junit.Test
	public void testUpdateMember(){
		MemberInfo member=memberInfoService.getMemberById(1);
		member.setName("墨菲特");
		member.setAge(30);
		member.setSex("2");
		
		memberInfoService.updateMember(member);
	}
	
	@org.junit.Test
	public void testDeleteMember(){
//		MemberInfo member=new MemberInfo();
//		member.setName("测试");
//		member.setSex("2");
//		member.setAge(25);
//		memberInfoService.addMember(member);
		
		memberInfoService.deleteMemberById(5);
	}
}
