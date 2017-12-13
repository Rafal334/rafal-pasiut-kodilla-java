package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING_TASK = "DrivingTask";
    public static final String PAINTING_TASK = "PaintingTask";
    public static final String SHOPPING_TASK = "ShoppingTask";

    public Task makeTask(String task) {

        switch (task) {
            case DRIVING_TASK:
                return new DrivingTask("Driving task", "Cracow", "car");
            case PAINTING_TASK:
                return new PaintingTask("Painting task", "Blue", "Wall");
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping task", "Eggs", 10);
            default:
                return null;
        }
    }
}
