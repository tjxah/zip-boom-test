import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * .
 *
 * @author taojx@mochasoft.com.cn
 */
public class TestZipBoom {
    public static void main(String[] args) throws IOException {
        File f = new File("ZipBomb.zip");
        ZipFile zipFile = new ZipFile(f);
        Enumeration<? extends ZipEntry> entries = zipFile.entries(); // Sensitive

        while (entries.hasMoreElements()) {
            ZipEntry ze = entries.nextElement();
            File out = new File("./output_onlyfortesting.txt");
            Files.copy(zipFile.getInputStream(ze), out.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
