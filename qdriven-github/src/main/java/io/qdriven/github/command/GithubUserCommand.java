package io.qdriven.github.command;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import io.qdriven.github.GithubBaseCommand;
import io.qdriven.github.GithubSettings;
import io.qdriven.github.domain.FollowEntity;
import io.qdriven.github.domain.GithubRepoEntity;
import io.qdriven.github.exception.GithubConnectException;
import lombok.extern.log4j.Log4j2;
import org.kohsuke.github.GHPersonSet;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.PagedIterable;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public void deleteReposBy(Predicate<Map.Entry<String, GHRepository>> predicate) {
        Map<String, GHRepository> result = null;
        try {
            result = getGithubUser().getRepositories();
            result.entrySet().forEach(
                    entry -> {
                        if (predicate.test(entry)) {
                            try {
                                entry.getValue().delete();
                            } catch (IOException e) {
                                throw new GithubConnectException("delete repos failed,err={}", e);
                            }
                        }
                    }
            );
        } catch (IOException e) {
            throw new GithubConnectException("delete repos failed,err={}", e);
        }
    }

    /**
     * Delete Repo Name, like Repo name
     *
     * @param repoName
     */
    public void deleteRepos(String repoName) {
        deleteReposBy( entry -> entry.getKey().toLowerCase().contains(repoName.toLowerCase()));
    }

    /**
     * Search Repo
     * @param repo
     * @return
     */
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
    public GHPersonSet<GHUser> getFollows() {
        try {
            return getGithubUser().getFollows();
        } catch (IOException e) {
            log.error("get follows failed,e={}", e);
            throw new GithubConnectException("get follows failed");
        }
    }

    public void saveFollowsToFile(String filePath) {

        GHPersonSet<GHUser> follows = getFollows();
        List<FollowEntity> followEntities = new ArrayList<>();
        for (GHUser follow : follows) {
            FollowEntity entity = new FollowEntity();
            entity.setApiUrl(follow.getUrl().toString());
            entity.setHtmlUrl(follow.getHtmlUrl().toString());
            entity.setLogin(follow.getLogin());
            followEntities.add(entity);
        }
        FileUtil.writeString(
                JSONUtil.toJsonStr(followEntities),
                new File(filePath), Charset.defaultCharset());
    }

    public PagedIterable<GHRepository> getStarredRepositories() {
        return getGithubUser().listStarredRepositories();
    }

    public void saveStarredRepositories(String filePath) {
        PagedIterable<GHRepository> repos = getGithubUser().listStarredRepositories();
        List<GithubRepoEntity> repoEntities = new ArrayList<>();
        for (GHRepository repo : repos) {
            GithubRepoEntity entity = new GithubRepoEntity();
            entity.setName(repo.getName());
            entity.setRepoUrl(repo.getHttpTransportUrl());
            repoEntities.add(entity);
        }
        FileUtil.writeString(
                JSONUtil.toJsonStr(repoEntities),
                new File(filePath), Charset.defaultCharset());
    }
}
