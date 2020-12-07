package XMLhandler;

public interface XMLContent extends XMLElement {
    boolean isRecursive();

    boolean isTextValue();

    String getTextValue();
}
