package io.qdriven.github.command;

import org.junit.jupiter.api.Test;

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
        command.deleteRepos("qaops-assets");
        command.deleteRepos("WeBASE-Oracle");
        command.deleteRepos("qdriven-github");
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