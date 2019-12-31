package com.jillandee.card;

public class Anime {

    private String Title;
    private String Genre;
    private String Href;
    private int Thumbnail;

    public Anime() {
    }

    public Anime(String title, String genre, String href, int thumbnail) {
        Title = title;
        Genre = genre;
        Href = href;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getHref() {
        return Href;
    }

    public void setHref(String href) {
        this.Href = href;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

}
