package form;

public class Case {
    private long id;
    private Area area;
    private String content;

    public Case() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setArea(String area) {
        this.area = Area.valueOf(area.toUpperCase());
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", area=" + area +
                ", content='" + content + '\'' +
                '}';
    }
}
