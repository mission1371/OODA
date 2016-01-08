package domain;

/**
 * @author umut - pc
 *
 */
public enum EnumScreenType {

    SAVE(1), UPDATE(2), DELETE(0), VIEW(3);

    private int code;

    private EnumScreenType(int code) {
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
