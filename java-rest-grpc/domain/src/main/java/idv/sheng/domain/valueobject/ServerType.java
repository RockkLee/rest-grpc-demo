package idv.sheng.domain.valueobject;

import lombok.Getter;

@Getter
public enum ServerType {
    GOLANG(1),
    PYTHON(2),
    JAVA(3);

    private final String name;
    private final int code;

    ServerType(int code) {
        this.code = code;
        //define name by code
        this.name = switch (code) {
            case 1 -> "Golang";
            case 2 -> "Python";
            case 3 -> "Java";
            default -> throw new IllegalArgumentException("Invalid serverType: " + code);
        };
    }

    public static ServerType of(int code) {
        return switch (code) {
            case 1 -> GOLANG;
            case 2 -> PYTHON;
            case 3 -> JAVA;
            default -> throw new IllegalArgumentException("Invalid serverType: " + code);
        };
    }
}
