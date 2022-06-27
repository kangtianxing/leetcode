package base.test.enum1;

public enum ScriptEnum {
    //稿件状态
    PENDING(1,"待送审"),
    UNIT_FIRST_PENDING_TRIAL(2,"分公司一审待审"),
    UNIT_SECOND_PENDING_TRIAL(3,"分公司二审待审"),
    UNIT_THIRD_PENDING_TRIAL(4,"分公司三审待审"),
    UNIT_FIRST_REJECT(5,"分公司一审驳回"),
    UNIT_SECOND_REJECT(6,"分公司二审驳回"),
    UNIT_THIRD_REJECT(7,"分公司三审驳回"),
    GROUP_FIRST_PENDING_TRIAL(8,"集团一审待审"),
    GROUP_SECOND_PENDING_TRIAL(9,"集团二审待审"),
    GROUP_THIRD_PENDING_TRIAL(10,"集团三审待审"),
    GROUP_FIRST_REJECT(11,"集团一审驳回"),
    GROUP_SECOND_REJECT(12,"集团二审驳回"),
    GROUP_THIRD_REJECT(13,"集团三审驳回"),
    UNIT_PASSED(14,"分公司通过"),
    GROUP_PASSED(15,"集团通过"),

    //稿件操作状态
    OPERATE_ADD(1,"新增"),
    OPERATE_SORT(2,"分类"),
    OPERATE_PENDING(3,"送审"),
    OPERATE_PASS(4,"通过"),
    OPERATE_REJECT(5,"驳回"),

    //审核记录中稿件的操作状态
    OPERATE_TYPE_ADD(1,"新增"),
    OPERATE_TYPE_SORT(2,"分类"),
    OPERATE_TYPE_PENDING(3,"送审"),
    OPERATE_TYPE_PASS(4,"审核通过"),
    OPERATE_TYPE_UNIT_PASS(5,"分公司通过"),
    OPERATE_TYPE_UNIT_REJECT(6,"分公司驳回"),
    OPERATE_TYPE_GROUP_PASS(7,"集团审核通过"),
    OPERATE_TYPE_GROUP_REJECT(8,"集团审核驳回")
    ;

    private Integer code;
    private String name;

    ScriptEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
