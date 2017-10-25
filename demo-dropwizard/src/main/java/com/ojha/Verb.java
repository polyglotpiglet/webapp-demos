package com.ojha;

public class Verb {

    private String infinitive;

    public Verb() {
        // Jackson deserialization
    }

    public Verb(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getInfinitive() {
        return infinitive;
    }

    @Override
    public String toString() {
        return "Verb{" +
                "infinitive='" + infinitive + '\'' +
                '}';
    }
}
