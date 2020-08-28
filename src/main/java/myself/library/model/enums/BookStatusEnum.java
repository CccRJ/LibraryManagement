package myself.library.model.enums;

/**
 * @program: library
 * @description: 状态枚举
 * @author: ChaiRJ
 * @create: 2020-08-27 16:09
 **/
public enum BookStatusEnum {
    NORMAL(0),      //正常
    DELETE(1),      //删除
    RECOMMENDED(2), //推荐
    ;

    public int getValue() {
        return value;
    }

    private int value;

    BookStatusEnum(int value) {
        this.value = value;
    }
}
