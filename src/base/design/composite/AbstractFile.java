package base.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ktx
 * @data 2022-06-21 15:19
 */
public interface AbstractFile {

    void killVirus(); // 杀毒
}

class ImageFile implements AbstractFile{

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件"+name+",进行查杀");
    }
}

class TextFile implements AbstractFile{

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件"+name+",进行查杀");
    }
}

class VideoFile implements AbstractFile{

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---音频文件"+name+",进行查杀");
    }
}

class Folder implements AbstractFile{

    private String name;
    // 定义容器，用来存放本容器下的子节点
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        super();
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }

    public void remove(AbstractFile file){
        list.remove(file);
    }

    public AbstractFile add(int index){
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹:"+name+"进行查杀");
        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}

