package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public class Board extends Prototype{

    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Board [" + name + "]\n");
        for (TasksList list : lists) {
            s.append(list.toString()).append("\n");
        }
        return s.toString();
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board) this.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board)super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
