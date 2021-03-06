package cn.lovehao.dto;


import cn.lovehao.entity.ArticlePhoto;
import cn.lovehao.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDto extends BaseEntity {

    private Integer id;

    private String title;

    private Integer articleClass;

    private String author;

    private Integer pageView;

    private String outline;

    private Integer theme;

    private String content;

    private String markdown;

    private ArticlePhoto articlePhoto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(Integer articleClass) {
        this.articleClass = articleClass;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public ArticlePhoto getArticlePhoto() {
        return articlePhoto;
    }

    public void setArticlePhoto(ArticlePhoto articlePhoto) {
        this.articlePhoto = articlePhoto;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }
}
