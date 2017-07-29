package scratch.webjar.acceptance.step;

/**
 * @author Karl Bennett
 */
public class GenericHolder<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
