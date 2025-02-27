public abstract class ListAbstract<T> implements IList<T> {
    protected int size;
    
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
