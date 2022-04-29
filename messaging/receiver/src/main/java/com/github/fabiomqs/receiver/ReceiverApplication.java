package com.github.fabiomqs.receiver;

import com.github.fabiomqs.receiver.listener.Receiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiverApplication {

	private final Receiver receiver;

	public ReceiverApplication(Receiver receiver) throws Exception {
		this.receiver = receiver;
		this.receiver.listen();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReceiverApplication.class, args);
	}

}
