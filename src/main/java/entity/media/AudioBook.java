package entity.media;

import java.sql.SQLException;


/**
 * Author: Minh
 * Subject: Example_1: Add AudioBook
 */
public class AudioBook extends Media{
    private String author;
    private String format;
    private String language;
    private String accent;
    private int lengthMinutes;

    public AudioBook() throws SQLException {

    }

    public AudioBook(int id, String title, String category, int price, int quantity, String type,
                     String author, String format, String language, String accent, int lengthMinutes) throws SQLException {
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.format = format;
        this.accent = accent;
        this.language = language;
        this.lengthMinutes = lengthMinutes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAccent() {
        return accent;
    }

    public void setAccent(String accent) {
        this.accent = accent;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}
