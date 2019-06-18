package com.ceiba.induccion.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.induccion.domain.ParkedImpl;
import com.ceiba.induccion.domain.RulesParking;
import com.ceiba.induccion.domain.RulesParkingCarImpl;
import com.ceiba.induccion.domain.RulesParkingImpl;
import com.ceiba.induccion.domain.VigilantActivitiesImpl;
import com.ceiba.induccion.domain.VigilantImpl;
import com.ceiba.induccion.domain.ports.GetPortRegistration;
import com.ceiba.induccion.domain.ports.PaymentPort;

@Configuration
public class BeanConfiguration {

	@Bean
	public VigilantActivitiesImpl vigilantActivities(RulesParkingImpl reglasParking, PaymentPort paymentPort,
			GetPortRegistration getPortRegistration) {
		return new VigilantActivitiesImpl(reglasParking, paymentPort, getPortRegistration);
	}

	@Bean
	public ParkedImpl parked(GetPortRegistration getPortRegistration) {
		return new ParkedImpl(getPortRegistration);
	}

	@Bean
	public RulesParkingCarImpl rulesParkingC(VigilantImpl vigilantImpl) {
		return new RulesParkingCarImpl(vigilantImpl);
	}

	@Bean
	public RulesParkingImpl rulesParkingImpl(RulesParking moto, RulesParking carro, VigilantImpl vigilantImpl,
			GetPortRegistration getPortRegistration) {
		return new RulesParkingImpl(moto, carro, vigilantImpl, getPortRegistration);
	}

}