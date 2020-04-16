import java.util.ArrayList;
import java.util.List;

public class Chart {
    String titlu_chart;
    long id;
    List<Album> albume = new ArrayList<>();

    public List<Album> getAlbume() {
        return albume;
    }

    public void setAlbume(List<Album> albume) {
        this.albume = albume;
    }


    public String getTitlu_chart() {
        return titlu_chart;
    }

    public void setTitlu_chart(String titlu_chart) {
        this.titlu_chart = titlu_chart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Chart(String titlu_chart, long id) {
        this.titlu_chart = titlu_chart;
        this.id = id;
    }
}
