package base.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName MmapTest
 * @Description TODO
 * @Author ktx
 * @Date 2022-09-09 22:02
 * @Version 1.0
 */
public class MmapTest {
    public static void main(String[] args) throws IOException {
        FileChannel readChannel = FileChannel.open(Paths.get("./jay.txt"), StandardOpenOption.READ);
        readChannel.map(FileChannel.MapMode.READ_ONLY,0,1024*1024*40);



    }
}
