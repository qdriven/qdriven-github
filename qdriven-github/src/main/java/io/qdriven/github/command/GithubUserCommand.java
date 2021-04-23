package io.qdriven.github.command;

import io.qdriven.github.GithubBaseCommand;
import io.qdriven.github.GithubSettings;
import io.qdriven.github.exception.GithubConnectException;
import lombok.extern.log4j.Log4j2;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Patrick
 **/
@Log4j2
public class GithubUserCommand extends GithubBaseCommand {

    public GithubUserCommand() {
        super();
    }

    /**
     * Create Repository
     *
     * @param repoName
     */
    public void createRepo(String repoName) {
        getGithub().createRepository(repoName);
    }

    /**
     * Delete Repository
     *
     * @param repo
     */
    public void deleteRepo(String repo) {
        try {
            getGithub().getRepository(repo).delete();
        } catch (IOException e) {
            throw new GithubConnectException("delete repo failed,err={}", e);
        }
    }

    public void deleteRepos(String repoName) {

        Map<String, GHRepository> result = null;
        try {
            result = getGithubUser().getRepositories();
            for (Map.Entry<String, GHRepository> entry : result.entrySet()) {
                if (entry.getKey().toLowerCase().contains(repoName.toLowerCase())) {
                    System.out.println(entry.getValue());
                    entry.getValue().delete();
                }

            }
        } catch (IOException e) {
            throw new GithubConnectException("delete repos failed,err={}", e);
        }
    }

    public List<GHRepository> searchRepo(String repo) {
        List<GHRepository> repos = new ArrayList<>();
        try {
            Map<String, GHRepository> result = getGithub().getUser(GithubSettings.getUser())
                    .getRepositories();
            for (Map.Entry<String, GHRepository> entry : result.entrySet()) {
                if (entry.getKey().toLowerCase().contains(repo.toLowerCase())) {
                    repos.add(entry.getValue());
                }
            }
            return repos;
        } catch (IOException e) {
            throw new GithubConnectException("find repo failed,err={}", e);
        }
    }

    //other status for github status
}
