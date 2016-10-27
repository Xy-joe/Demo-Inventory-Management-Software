import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.Symbology;

public class BarcodeClass {
        // Set the Base Folder for loading and storing images
    private static String strbasefolder = "/home/joebuntu/Aspose/Resourses";

    public static void main (String[] args){

        //Import the Image File
        String imagefile = "barcode.jpeg";

        String codeText = "test-code39";
        BarCodeBuilder builder = new BarCodeBuilder(codeText, Symbology.Code39Standard);

        //Save the Image to disk
              builder.save(strbasefolder + imagefile);
        System.out.println("Barcode save successfully ");

    }
}
