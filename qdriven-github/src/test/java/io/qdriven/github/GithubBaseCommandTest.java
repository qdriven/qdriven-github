package io.qdriven.github;

import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;


import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Patrick
 **/
class GithubBaseCommandTest {

    @Test
    public void testGithubCommand() throws IOException {
        GithubBaseCommand command = new GithubBaseCommand();
        GitHub gitHub =command.getGithub();
        assertNotNull(gitHub.getApiUrl());
        GHUser user =gitHub.getUser("qdriven");
        System.out.println(user);
        Map<String,GHRepository> result =user.getRepositories();
        System.out.println(result);
        for (Map.Entry<String, GHRepository> entry : result.entrySet()) {
            if(entry.getValue().isFork()){
                if(entry.getKey().contains("WeIdentity")){
                    System.out.println(entry.getValue());
                    entry.getValue().delete();
                }
            }
        }
    }
}