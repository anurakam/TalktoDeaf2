package project.talktodeaf.Model;



public class Example
{
    public final String name_voc;
    public final String des_voc;
    public final String name_type;
    public final String exam;

    public Example(String des_voc, String name_voc,String name_type,String exam) {
        this.des_voc = des_voc;
        this.name_voc = name_voc;
        this.name_type = name_type;
        this.exam = name_voc;

    }

    public String getDes_voc() {
        return des_voc;
    }

    public String getName_voc() {
        return name_voc;
    }

    public String getName_type() {
        return name_type;
    }

    public String getExam() {
        return exam;
    }
}
