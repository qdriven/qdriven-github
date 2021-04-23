package io.qdriven.github.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Patrick
 **/
class GithubUserCommandTest {

    @Test
    void createRepo() {
    }

    @Test
    void deleteRepo() {
    }

    @Test
    void deleteRepos() {
        GithubUserCommand command = new GithubUserCommand();
        command.deleteRepos("qaops-assets");
        command.deleteRepos("WeBASE-Oracle");
        command.deleteRepos("qdriven-github");
    }

    @Test
    void searchRepo() {
    }
}