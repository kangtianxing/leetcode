package base.design.composite;

/**
 * 资源管理器
 * XML文件解析
 * Junit单元测试框架
 * @author ktx
 * @data 2022-06-21 15:28
 */
public class Client {
    public static void main(String[] args) {
        Folder f1 = new Folder("我的收藏");
        AbstractFile f2,f3,f4,f5,f6;
        f2 = new ImageFile("老高的头像.jpg");
        f3 = new TextFile("hello.txt");
        f1.add(f2);
        f1.add(f3);

        Folder f11 = new Folder("电影");
        f4 = new VideoFile("笑傲江湖.avi");
        f5 = new VideoFile("神雕侠侣.avi");
        f11.add(f4);
        f11.add(f5);
        f1.add(f11);
        f2.killVirus();
        f1.killVirus();
    }
}
