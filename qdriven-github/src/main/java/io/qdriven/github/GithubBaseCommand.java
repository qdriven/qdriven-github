package io.qdriven.github;

import io.qdriven.github.exception.GithubConnectException;
import lombok.extern.log4j.Log4j2;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import java.io.IOException;

/**
 * @author Patrick
 **/
@Log4j2
public class GithubBaseCommand {

    private GitHub github;

    public GithubBaseCommand() {
        setup();
    }

    void setupWithUser(String apiKey, String user) {
        try {
            github = new GitHubBuilder().withOAuthToken(
                    apiKey,
                    user
            ).build();
        } catch (IOException e) {
            log.error("create github client failed,", e);
            throw new GithubConnectException("%s can't connect to github"
                    .formatted(GithubSettings.getUser()));
        }
    }

    public void setup() {
        setupWithUser(GithubSettings.getApiKey(),
                GithubSettings.getUser());
    }

    public GitHub getGithub() {
        return github;
    }

    public GHUser getGithubUser() {
        try {
            return getGithub().getUser(GithubSettings.getUser());
        } catch (IOException e) {
            throw new GithubConnectException("%s can't connect to github"
                    .formatted(GithubSettings.getUser()));
        }

    }
}
