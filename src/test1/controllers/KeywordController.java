package test1.controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test1.HibernateUtil.HibernateUtil;
import test1.domain.Keyword;


@Controller
public class KeywordController {
	
	@RequestMapping(value="/OnOff.htm",method=RequestMethod.GET)
	public String showForm(){
		return "OnOff";
	}
	
	@RequestMapping(value="/OnOff.htm",method=RequestMethod.POST)
	public @ResponseBody String onOff(@ModelAttribute(value="keyword") Keyword keyword, BindingResult result) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if (keyword.getKeyword().equals("")) {
			String returnText = "Field is empty!";
			return returnText;
		} else {
			int x = 0;
			Session session = HibernateUtil.currentSession();
			Query q = session.createSQLQuery("select keyword from keywords");
			List<String> keywordlist = q.list();
			while (x < keywordlist.size()) {
				if (keyword.getKeyword().equals(keywordlist.get(x))) {
					Toggle toggle;
					Query qr = session
							.createSQLQuery("select binded_class from keywords where keyword = :name");
					qr.setParameter("name", keyword.getKeyword());
					List<Integer> bindlist = qr.list();
					Query qrr = session
							.createSQLQuery("select Classname from classes where id = :id");
					qrr.setParameter("id", bindlist.get(0));
					List<String> classlist = qrr.list();
					toggle = say("test1.controllers." + classlist.get(0));
					String returnText;
					classlist.clear();
					bindlist.clear();
					returnText = toggle.onOff();
					return returnText;
				}
				x++;
			}
			x = 0;
			String returnText = "Keyword does not exist!";
			return returnText;
		}
		
	}
	
	public static Toggle say(String whichClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName(whichClass);
		return (Toggle) clazz.newInstance();
	}
}
