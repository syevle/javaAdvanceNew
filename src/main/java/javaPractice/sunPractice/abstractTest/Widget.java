package javaPractice.sunPractice.abstractTest;

public abstract class Widget {
    private final int cachedWidth;
    private final int cachedHeight;

    public Widget() {
        this.cachedWidth = width();
        this.cachedHeight = height();
    }

    protected abstract int width();
    protected abstract int height();
}
