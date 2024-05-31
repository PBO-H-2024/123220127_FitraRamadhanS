package Model;

public class Model {

    public final String name;
    public final String path;
    public final int writing;
    public final int coding;
    public final int interview;
    public final int score;
    public final String result;

    public static Model listRecruit[] = new Model[10];

    public Model(String name, String path, int writing, int coding, int interview, int score, String result){
        this.name = name;
        this.path = path;
        this.writing = writing;
        this.coding = coding;
        this.interview = interview;
        this.score = score;
        this.result = result;        
    }
}
