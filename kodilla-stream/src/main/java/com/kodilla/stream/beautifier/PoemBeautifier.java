package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String text, PoemDecorator decorator) {
        String result = decorator.decorate(text);
        System.out.println(result);
        return result;
    }

    public static String addStars(String text) {
        StringBuilder builder = new StringBuilder();
        builder.append("*");
        for (int i = 0; i < text.length(); i++) {
            builder.append(text.substring(i, i + 1));
            builder.append("*");
        }
        return builder.toString();
    }
}
