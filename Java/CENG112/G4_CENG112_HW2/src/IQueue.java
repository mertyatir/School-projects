
public interface IQueue<T> 
{
	public boolean enqueue(T newentry);
	public T dequeue();
	public T getfront();
	public boolean isEmpty();
	public boolean isFull();
}
