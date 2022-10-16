package com.masai.services;

import java.sql.Date;
import java.util.List;


import com.masai.Exception.TasksNotFoundException;
import com.masai.mdel.Employee;
import com.masai.mdel.Tasks;



public interface TasksServices {
	public Tasks createTasks(Tasks tasks)throws TasksNotFoundException;
	public List<Tasks>  getTasksByDeadLine(Date start,Date end)throws TasksNotFoundException;
	public List<Tasks> getTaskByOrder(String order)throws TasksNotFoundException;
	public Employee getEmployeeByIdTask(Integer id)throws TasksNotFoundException;
	public Tasks updateTaskDetails(Tasks task) throws TasksNotFoundException;
	public String deletTasksById(Integer id)throws TasksNotFoundException;

}
