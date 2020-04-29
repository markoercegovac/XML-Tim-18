package rent.app.dto;

public class CommentDTO {

    private String content;
    private String author;
    private long advertId;

    public CommentDTO() {
        super();
    }

    public CommentDTO(String content, String author, long advertId) {
        this.content = content;
        this.author = author;
        this.advertId = advertId;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public long getAdvertId() {
        return advertId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAdvertId(long advertId) {
        this.advertId = advertId;
    }
}
