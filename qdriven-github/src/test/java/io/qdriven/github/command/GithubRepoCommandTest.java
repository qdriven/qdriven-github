package io.qdriven.github.command;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlMapping;
import io.qdriven.github.domain.GithubRepoEntity;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHRepository;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Patrick
 **/
class GithubRepoCommandTest {
    GithubRepoCommand command = new GithubRepoCommand();

    @Test
    void testGetRepoByUrl() throws IOException {
        GHRepository repository = command.getRepoByUrl("https://github.com/qdriven/tester-radar.git");
        GithubRepoEntity entity = GithubRepoEntity.toRepoEntity(repository);
        System.out.println(entity);
        YamlMapping entityYamlMapping = Yaml.createYamlDump(
                entity
        ).dumpMapping();
        Yaml.createYamlPrinter(new FileWriter("repo.yaml")).print(entityYamlMapping);
    }
}