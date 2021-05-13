package io.qdriven.github.domain;

import io.qdriven.github.exception.GithubConnectException;
import lombok.Data;
import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author Patrick
 **/
@Data
public class GithubRepoEntity {
    private String repoUrl;
    private String name;
    private int stars;
    private List<String> topics;
//    private List<String> tags;
    private Set<String> languages;

    public static GithubRepoEntity toRepoEntity(GHRepository repository){
        try {
            GithubRepoEntity entity = new GithubRepoEntity();
            entity.setRepoUrl(repository.getHttpTransportUrl());
            entity.setName(repository.getName());
            entity.setTopics(repository.listTopics());
            entity.setLanguages(repository.listLanguages().keySet());
            entity.setStars(repository.getStargazersCount());
            return entity;
        } catch (IOException e) {
            throw new GithubConnectException(e);
        }
    }
}
