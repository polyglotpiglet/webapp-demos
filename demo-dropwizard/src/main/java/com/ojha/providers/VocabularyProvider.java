package com.ojha.providers;

import com.ojha.Verb;

import java.util.Set;

public interface VocabularyProvider {

    Set<Verb> getAllVerbs();

    void addVerb(Verb verb);
}
