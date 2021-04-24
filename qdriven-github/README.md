# README

I forked a lot of repositories, and one day I wanted to delete these repositories. I don't want to delete it one by one
, so I create this repo to delete these repository in batch.

Meanwhile, I had a chance to take a look at all the github apis to learn how to integrate with GITHUB Api.

## Rough think on github api

I came up with simple idea to make github integration a little easy.

- ```GithubSettings```, settings for Personal Github
- ```GithubBaseCommand```, base github command template class, only like setup user
- ```GithubCommands```, every command class is for a github domain, user, repository,etc. GithubCommands should be a
  lot, it depends on real business needs.

### TO DO List
- [X] Get Follows
- [X] Get Starred Repos

## Examples

### Delete Repo with keywords

```JAVA
 GithubUserCommand command=new GithubUserCommand();
        command.deleteRepos("qaops-assets");
        command.deleteRepos("WeBASE-Oracle");
        command.deleteRepos("WeCross");
```

### Get Stars and Followings throw command

```java
  @Test
    void testSaveFollows(){
            command.saveFollowsToFile("follows.json");
            }
@Test
    void testSaveStarredRepo(){
            command.saveStarredRepositories("stars.json");
            }
```


