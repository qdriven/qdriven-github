package io.qdriven.github.command;


import io.qdriven.github.GithubBaseCommand;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHTag;
import org.kohsuke.github.GitHub;

import java.io.IOException;

/**
 * @author Patrick
 **/
public class GithubRepoCommand extends GithubBaseCommand {

    public GHRepository getRepoByUrl(String url){
//        https://github.com/qdriven/tester-radar.git
//        git@github.com:qdriven/tester-radar.git
        String repoName = url.replaceAll("https://github.com/","")
                .replaceAll(".git","")
                .replaceAll("git@github.com:","");
        try {
           GHRepository repo =  getGithub().getRepository(repoName);
           return repo;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
