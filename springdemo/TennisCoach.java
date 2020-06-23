package springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "tennisCoach")
//@Scope("prototype")
@Scope										//It is default scope i.e Singleton
public class TennisCoach implements Coach {

	//Field Injector
	@Autowired
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;

	//default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}


	//Constructor Injector
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/


	//Setter Injector
	// define a setter method
	/*@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	} */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	//Can inject dependency through any method
	//@Autowired
	public void doSomeCrazyThing(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyThing() method");
		this.fortuneService = theFortuneService;
	}

	@PostConstruct
	public void startupCode(){
		System.out.println("Can write startup business logic");
	}

	@PreDestroy
	public void cleanupCode(){
		System.out.println("Can write cleanup business logic");
	}

}
