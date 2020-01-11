package pl.szewczyk.aop.sendmail;

public class Video {

    private long id;
    private String title;
    private  String producer;

    public Video() {
    }

    public Video(long id, String title, String producer) {
        this.id = id;
        this.title = title;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
