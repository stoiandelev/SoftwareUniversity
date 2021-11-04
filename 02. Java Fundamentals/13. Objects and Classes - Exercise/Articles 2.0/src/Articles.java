package Articles;

public class Articles {
    //field
    private String title;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    private String content;
    private String author;


    //constructor

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " - " + content + ": " + author;
    }
}
