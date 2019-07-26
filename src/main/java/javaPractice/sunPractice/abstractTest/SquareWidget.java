package javaPractice.sunPractice.abstractTest;
/*
This is a problem of initialization order. The subclass constructor will not have had a chance to run yet and there is no way to force it to run it before the parent class. Consider the following example class:

This seems like a good start for an abstract Widget: it allows subclasses to fill in width and height, and caches their initial values. However, look when you spec out a typical subclass implementation like so:

Now we’ve introduced a subtle bug: Widget.cachedWidth and Widget.cachedHeight will always be zero for SquareWidget instances! This is because the this.size = size assignment occurs after the Widget constructor runs.

Avoid calling abstract methods in your abstract classes’ constructors, as it restricts how those abstract methods can be implemented.
 */
public class SquareWidget extends Widget {
    private final int size;

    public SquareWidget(int size) {
        this.size = size;
    }

    @Override
    protected int width() {
        return size;
    }

    @Override
    protected int height() {
        return size;
    }
}