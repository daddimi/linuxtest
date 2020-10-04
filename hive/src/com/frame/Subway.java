package com.frame;

import org.springframework.stereotype.Service;

@Service
public interface Subway<P> {
	public void Passenger(P p);
}
