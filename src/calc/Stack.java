package calc;

public class Stack<E> extends ArrayList<E> {

	public void push(E item) {
		
		add(item);

	}

	public E pop() throws StackException{
		if(empty())
		{
			throw new StackException("stack is empty");
		}
		return remove(size()-1);
	}

	public E peek() {
		return get(size()-1);
	}

	public boolean empty() {
		boolean check;
		if(size()==0)
		{
			check=false;
		}else
		{
			check=true;
		}
		return check;
	}

}
