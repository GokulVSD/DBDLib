package dbdatabase;

public class FileCreator {

    private String fileName;
    String content;

    public FileCreator(String fileName){

        this.fileName = fileName;
    }

    void createFile(); //creates file with fileName and content. if content is null, creates emtpy file
}
