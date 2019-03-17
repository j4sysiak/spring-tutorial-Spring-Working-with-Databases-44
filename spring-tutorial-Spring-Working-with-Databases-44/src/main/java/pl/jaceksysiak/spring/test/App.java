package pl.jaceksysiak.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("pl/jaceksysiak/spring/test/beans/beans.xml");
 
		OffersDAO offersDao  = (OffersDAO)context.getBean("offersDao");
		
		try{
		List<Offer> offers = offersDao.getOffers();
		
		for(Offer offer : offers){
			
			//System.out.println(offer);
		} 
		
		Offer offer = offersDao.getOffer(1);
		System.out.println(offer);
		
			} catch(CannotGetJdbcConnectionException ex){
				System.out.println("Cannot get database connection."); 
			}
			  catch(DataAccessException ex){
				System.out.println(ex.getMessage());
				System.out.println(ex.getClass());
			}
	 
		((ClassPathXmlApplicationContext)context).close();

	}

}




























































