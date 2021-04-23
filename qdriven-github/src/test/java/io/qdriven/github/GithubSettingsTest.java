package io.qdriven.github;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Patrick
 **/
class GithubSettingsTest {

    @org.junit.jupiter.api.Test
    void testGetUser() {
        String user = GithubSettings.getUser();
        assertEquals(user,"qdriven");
    }

    @org.junit.jupiter.api.Test
    void testGetApiKey() {
        String user = GithubSettings.getApiKey();

    }

    @org.junit.jupiter.api.Test
    void getPassword() {
    }
}