package com.arikko.midterm_problem_solution;

import java.time.LocalDate;

public class Article {
    private String title, author, articleType, citationStatus;
    private int numberOfAuthors;
    private LocalDate publicationDate;

    public Article() {
    }

    public Article(String title, String author, String articleType, String citationStatus, int numberOfAuthors, LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.articleType = articleType;
        this.citationStatus = citationStatus;
        this.numberOfAuthors = numberOfAuthors;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getCitationStatus() {
        return citationStatus;
    }

    public void setCitationStatus(String citationStatus) {
        this.citationStatus = citationStatus;
    }

    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    public void setNumberOfAuthors(int numberOfAuthors) {
        this.numberOfAuthors = numberOfAuthors;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", articleType='" + articleType + '\'' +
                ", citationStatus='" + citationStatus + '\'' +
                ", numberOfAuthors=" + numberOfAuthors +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
