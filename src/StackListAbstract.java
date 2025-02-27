public abstract class StackListAbstract<T> extends StackAbstract<T> {
    protected int size;

    public StackListAbstract() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public abstract void push(T element);  
    public abstract T pop();  
    public abstract T peek();
}
