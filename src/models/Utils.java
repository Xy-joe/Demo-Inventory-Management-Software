package models;

/**
 * Created by joebuntu on 3/25/17.
 */import java.io.File;
public class Utils {


        public static String getDataDir(Class c) {
            File dir = new File(System.getProperty("user.dir"));
            dir = new File(dir, "src");
            dir = new File(dir, "main");
            dir = new File(dir, "resources");

            return dir.toString() + File.separator;
        }
}
