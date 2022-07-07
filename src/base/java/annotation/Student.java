package base.java.annotation;

/**
 * @author ktx
 * @data 2022-07-07 22:23
 */
public class Student {
    private Long id;
    private String name;

    @Length(min = 11,max = 11,errorMsg = "fjajfgg")
    private String mobile;
}
