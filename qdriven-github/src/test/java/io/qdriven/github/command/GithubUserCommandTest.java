package io.qdriven.github.command;

import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;

import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Patrick
 **/
class GithubUserCommandTest {
    GithubUserCommand command = new GithubUserCommand();

    @Test
    void createRepo() {
    }

    @Test
    void deleteRepo() {
    }

    @Test
    void deleteRepos() {
//        command.deleteRepos("qaops-assets");
//        command.deleteRepos("WeBASE-Oracle");
//        command.deleteRepos("qdriven-github");
        command.deleteReposBy(entry -> entry.getValue().isFork());
    }

    @Test
    void searchRepo() {
    }
    @Test
    void testSaveFollows(){
        command.saveFollowsToFile("follows.json");
    }
    @Test
    void testSaveStarredRepo(){
        command.saveStarredRepositories("stars.json");
    }
}