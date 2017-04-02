import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.Symbology;
import com.aspose.barcode.barcoderecognition.BarCodeReadType;
import com.aspose.barcode.barcoderecognition.BarCodeReader;
import models.Utils;

import java.util.Scanner;


public class BarcodeClass {
        // Set the Base Folder for loading and storing images
    private static String strbasefolder = "/home/joebuntu/Aspose/Resourses";

    public static void main (String[] args){
// The path to the resource directory.
        String dataDir = Utils.getDataDir(BarcodeClass.class) + "BarcodeReader/loading_images/";

        // Initialize bar code reader
        BarCodeReader reader = new BarCodeReader(dataDir + "CodeText.jpg");
//r

        // Initialize bar code reader
        BarCodeReader barcodeReader = new BarCodeReader(dataDir + "CodeText.jpg", BarCodeReadType.Code39Extended);
        //Import the Image File
        String imagefile = "barcode.jpeg";
        Scanner sc = new Scanner(System.in);
         System.out.print("W n m :");
        String yy = sc.nextLine();
        ;
        System.out.println("hdhh" + yy);
        String codeText = "test-code39";
        BarCodeBuilder builder = new BarCodeBuilder(codeText, Symbology.Code39Standard);

        //Save the Image to disk
              builder.save(strbasefolder + imagefile);
        System.out.println("Barcode save successfully ");

    }
}
