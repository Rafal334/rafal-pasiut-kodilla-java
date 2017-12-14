package com.kodilla.patterns.builder.checkers;

public class FigureFactory {

    public static final String PAWN="PAWN";
    public static final String QUEEN="QUEEN";

    public static Figure makeFigure(String figureType, String color) {
        switch (figureType) {
            case PAWN:
                return new Pawn(color);
            case QUEEN:
                return new Queen(color);
            default:
                throw new IllegalStateException("Type of figure should be pawn or queen");
        }
    }
}
