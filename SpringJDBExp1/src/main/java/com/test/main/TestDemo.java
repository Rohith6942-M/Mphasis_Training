package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.doa.MLATeamDao;
import com.test.doa.MLATeamDao1;
import com.test.model.MLATeam;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MLATeamDao dao = new MLATeamDao();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		MLATeamDao dao = ctx.getBean("tdao", MLATeamDao.class);
		MLATeamDao1 dao1 = ctx.getBean("tdao1", MLATeamDao1.class);
		MLATeam obj = new MLATeam();
		obj.setId(134);
		obj.setName("sachin");
		obj.setSkill("php developer");
		obj.setManager("sam");
		dao.saveMLATeam(obj);
		dao1.createMLATeam(obj);
		List<MLATeam> list = dao.getAllMembers();
		list.forEach(team -> System.out.println(team.getId()+" "
					+team.getName()+" "
					+team.getSkill()+" "
					+team.getManager()));
	}

}
