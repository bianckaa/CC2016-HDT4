public abstract class ListAbstract<T> implements IList<T> {
    protected int size;

    public ListAbstract(){
        this.size= 0;
    }
    
    @Override
    public int size(){
        return size;
    }
}
