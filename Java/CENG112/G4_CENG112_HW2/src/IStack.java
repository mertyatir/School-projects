
public interface IStack<T> 
{
	public boolean push(T newEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();
	
}
