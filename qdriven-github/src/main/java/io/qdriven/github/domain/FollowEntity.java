package io.qdriven.github.domain;

import lombok.Data;

/**
 * @author Patrick
 **/
@Data
public class FollowEntity {
    private String login;
    private String htmlUrl;
    private String apiUrl;
}
