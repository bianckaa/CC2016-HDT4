public abstract class ListAbstract<T> implements IList<T> {
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
}
