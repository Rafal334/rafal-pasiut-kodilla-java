package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private Integer totalTasksToCheck;

    public Mentor(String name) {
        totalTasksToCheck = 0;
        this.name = name;
    }

    @Override
    public void update(TasksRepository tasksRepository) {
        totalTasksToCheck++;
        System.out.println(name + " there are " + tasksRepository.getTasks().size() + " tasks to check for student: " + tasksRepository.getStudent());
        System.out.println(name + " total tasks to check: " + totalTasksToCheck);
    }

    public Integer getTotalTasksToCheck() {
        return totalTasksToCheck;
    }
}
