package com.masai.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeNotFoundException;
import com.masai.Exception.TasksNotFoundException;
import com.masai.dao.EmployeeDao;
import com.masai.dao.TasksDao;
import com.masai.mdel.Employee;
import com.masai.mdel.Tasks;


@Service
public class TasksServicesImpl implements TasksServices{
	@Autowired
	private TasksDao tasksDao;
	@Autowired
	private EmployeeDao employeeDao;
	EmployeeServices employeeServices = new EmplyeeServicesImpl();
	@Override
	public Tasks createTasks(Tasks tasks) throws TasksNotFoundException {
		Optional<Tasks> opt = tasksDao.findById(tasks.getId());
		if(opt.isPresent()) {
			throw new TasksNotFoundException("Task already Excites");
		}else {
			tasksDao.save(tasks);
		}
		return tasks;
	}

	@Override
	public List<Tasks> getTasksByDeadLine(Date start, Date end) throws TasksNotFoundException {
		List<Tasks> list = tasksDao.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			throw new TasksNotFoundException("Task Not Found");
		}
		
	}

	@Override
	public List<Tasks> getTaskByOrder(String order) throws TasksNotFoundException {
		List<Tasks> list = tasksDao.findAll();
		if(order.equals("asc")) {
			
			list.sort((Tasks e2, Tasks e)->{
				return e2.getId()- e.getId();
			});
		}else {
			
			list.sort((Tasks e2, Tasks e)->{
				return e.getId()- e2.getId();
			});
		}
		return list;
	}

	@Override
	public Employee getEmployeeByIdTask(Integer id) throws TasksNotFoundException {
//		Optional<Tasks> opt = tasksDao.getAssignedEmployeeId(id);
//		
//		if(opt.isPresent()) {
//			return employeeServices.getEmployeeById(id);
//			
//		}else {
//			throw new TasksNotFoundException("Task Not Found");
//		}
		return null;
		
	}

	@Override
	public Tasks updateTaskDetails(Tasks task) throws TasksNotFoundException {
		Optional<Tasks> opt = tasksDao.findById(task.getId());		
		if(opt.isPresent()) {
			tasksDao.save(task);
			return opt.get();
			
		}else {
			throw new TasksNotFoundException("Task Not Found");
		}
	}

	@Override
	public String deletTasksById(Integer id) throws TasksNotFoundException {
		Optional<Tasks> opt = tasksDao.findById(id);
		
		if(opt.isPresent()) {
			tasksDao.delete(opt.get());
			 employeeServices.getEmployeeById(opt.get().getAssignedEmployeeId());
			 return "Deleted";
			
		}else {
			throw new TasksNotFoundException("Task Not Found");
		}
		
	}

}
