/**
 * Created by emmettna on 25/3/17.
 */
public class Idioms {

    private String english;
    private String korean;
    public Idioms(String english, String korean){
        this.english = english;
        this.korean = korean;
        }
    public String getEnglish(){
        return english;
    }
    public String getKorean(){
        return  korean;
    }
    public String toStrong(){
        return this.english.toString() + "   " + this.korean.toString();
    }
}
