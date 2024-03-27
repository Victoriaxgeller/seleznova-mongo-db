package data;

import com.github.javafaker.Faker;
import org.example.dao.Article;
import org.example.dao.Post;

import java.util.*;

public class TestDataGeneration {
    Faker faker = new Faker();

    public Post generatePost() {
        Post post = Post.builder()
                .id(UUID.randomUUID().toString())
                .title(faker.job().title())
                .user(faker.name().name())
                .content(faker.book().publisher())
                .tags(List.of(faker.book().genre(), faker.book().title()))
                .enable(true)
                .build();
        System.out.println(post.toString());
        return post;
    }

    public Article generateArticle() {
        Article article = Article.builder()
                .id(faker.number().numberBetween(0,1000))
                .image(faker.internet().image())
                .species(faker.book().publisher())
                .name(faker.name().name())
                .episode(faker.rickAndMorty().character())
                .url(faker.internet().url())
                .build();
        System.out.println(article.toString());
        return article;
    }

    public List<Post> generateListOfPosts(int count) {
        List<Post> posts = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            posts.add(generatePost());
        }
        return posts;
    }

    public List<Article> generateListOfArticles(int count) {
        List<Article> articles = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            articles.add(generateArticle());
        }
        return articles;
    }
}
