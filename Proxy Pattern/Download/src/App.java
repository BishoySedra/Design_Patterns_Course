interface Download{
    void download();
}

class RealDownload implements Download{
    private String targetFile;
    private String targetData;

    public RealDownload(String targetFile){
        this.targetFile = targetFile;
        downloadFromInternet();
    }

    private void downloadFromInternet(){
        System.out.println("Download from internet file: " + targetData);
    }

    public void download(){
        System.out.println("Downloaded file: " + targetFile);
    }
}

class ProxyDownload implements Download{
    private RealDownload realDownload;
    private String targetFile;

    public ProxyDownload(String targetFile){
        this.targetFile = targetFile;
    }

    public void download(){
        if(realDownload == null){
            realDownload = new RealDownload(targetFile);
            return;
        }
        realDownload.download();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        ProxyDownload proxyDownload = new ProxyDownload("Lecture_4.pdf");
        proxyDownload.download();
        proxyDownload.download();
    }
}