package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final Roll roll;
    private final Integer burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    private Bigmac(final Roll roll, final Integer burgers, final Sauce sauce, final List<Ingredients> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class BigmacBuilder {

        private Roll roll = Roll.STANDARD;
        private Integer burgers = 1;
        private Sauce sauce = Sauce.STANDARD;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder roll(Roll roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(Integer burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (burgers > 0 && roll != null && sauce != null) {
                return new Bigmac(roll, burgers, sauce, ingredients);
            } else {
                String exceptionMessage = "";
                if (burgers == 0) {
                    exceptionMessage += "Burgers number must be greater than 0\n";
                }
                if (roll == null) {
                    exceptionMessage += "Roll must be choosed\n";
                }
                if (sauce == null) {
                    exceptionMessage += "Sauce must be choosed\n";
                }
                throw new IllegalStateException(exceptionMessage);
            }
        }
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll=" + roll +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }

    public Roll getRoll() {
        return roll;
    }

    public Integer getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }
}
