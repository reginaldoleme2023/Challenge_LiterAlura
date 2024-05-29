package br.com.alura.ChallengeLiteralura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook (String title,
                        List<DataAuthors> authors,
                        List<String> languages,
                        Integer download_count
) {
}
