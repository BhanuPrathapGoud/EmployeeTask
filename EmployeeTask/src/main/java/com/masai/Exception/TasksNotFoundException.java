package com.masai.Exception;

public class TasksNotFoundException extends RuntimeException {

	public TasksNotFoundException() {

	}

	public TasksNotFoundException(String message) {
		super(message);
	}

}
