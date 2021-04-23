package io.qdriven.github;

import cn.hutool.setting.Setting;
import lombok.extern.log4j.Log4j2;

/**
 * @author Patrick
 **/
@Log4j2
public class GithubSettings {

    private static final String GITHUB_SETTING_PATH="github.setting";
    private static GithubSetting githubSetting = new GithubSetting();
    static {
        Setting setting = new Setting(GITHUB_SETTING_PATH);
        log.info(setting.getGroups().get(0));
        setting.toBean(githubSetting);

    }
    private GithubSettings(){}

    public static String getUser(){
        return githubSetting.getUser();
    }

    public static String getApiKey(){
        return githubSetting.getApiKey();
    }

    public static String getPassword(){
        return githubSetting.getPassword();
    }
}
