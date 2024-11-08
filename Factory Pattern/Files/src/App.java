interface File{
    void open(String fileLocation);
    void delete();
}

class PDFFile implements File{
    @Override
    public void open(String fileLocation) {
        System.out.println("Opening PDF file from location: " + fileLocation);
    }

    @Override
    public void delete() {
        System.out.println("Deleting PDF file");
    }
}

class WordFile implements File{
    @Override
    public void open(String fileLocation) {
        System.out.println("Opening Word file from location: " + fileLocation);
    }

    @Override
    public void delete() {
        System.out.println("Deleting Word file");
    }
}

class FileFactory implements File{
    private File file = null;

    public void createFile(String fileType){
        if(fileType.equals("PDF")){
            file = new PDFFile();
        }else if(fileType.equals("Word")){
            file = new WordFile();
        }
    }

    @Override
    public void open(String fileLocation) {
        file.open(fileLocation);
    }

    @Override
    public void delete() {
        file.delete();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        FileFactory fileFactory = new FileFactory();
        fileFactory.createFile("PDF");
        fileFactory.open("C:/Users/Downloads/abc.pdf");
        fileFactory.delete();

        fileFactory.createFile("Word");
        fileFactory.open("C:/Users/Downloads/abc.docx");
        fileFactory.delete();
    }
}
