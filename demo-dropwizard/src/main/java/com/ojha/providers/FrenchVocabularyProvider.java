package com.ojha.providers;

import com.ojha.Verb;
import com.ojha.VocabularyResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

public class FrenchVocabularyProvider implements VocabularyProvider {

    private final NamedParameterJdbcTemplate template;

    public FrenchVocabularyProvider(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Set<Verb> getAllVerbs() {
        List<Map<String, Object>> results = template.queryForList("select * from french_verb", Collections.emptyMap());
        return results.stream()
                .map(result -> new Verb((String) result.get("infinitive")))
                .collect(Collectors.toSet());
    }

    @Override
    public void addVerb(Verb verb) {
        Map<String, String> source = new HashMap<>();
        source.put("infinitive", verb.getInfinitive());
        template.update("insert into french_verb (infinitive) values (:infinitive)", source);
    }
}
