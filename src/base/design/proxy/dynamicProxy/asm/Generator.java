package base.design.proxy.dynamicProxy.asm;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @ClassName Generator
 * @Description TODO
 * @Author ktx
 * @Date 2022-08-25 10:23
 * @Version 1.0
 */
public class Generator {
    public static void main(String[] args) throws Exception{


        //读取
//        ClassReader classReader = new ClassReader("meituan/bytecode/asm/Base");
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//        //处理
//        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
//        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
//        byte[] data = classWriter.toByteArray();
//        //输出
//        File f = new File("operation-server/target/classes/meituan/bytecode/asm/Base.class");
//        FileOutputStream fout = new FileOutputStream(f);
//        fout.write(data);
//        fout.close();
//        System.out.println("now generator cc success!!!!!");
    }
}
