
 class Queue {
	/* Java program to implement basic stack
	operations */
	
		static final int MAX = 1000;
		int rear, front;
		int a[] = new int[MAX]; // Maximum size of Stack

		boolean isEmpty()
		{
			return (front < 0 && rear < 0);
		}
		Queue()
		{
			rear = -1;
			
			front = 0;
		}

		boolean enqueue(int x)
		{
			if (rear >= (MAX-1))
			{
				System.out.println("Queue Overflow");
				return false;
			}
			else
			{
				a[++rear] = x;
				return true;
			}
		}

		int dequeue()
		{
			if (front < 0)
			{
				System.out.println("Queue Underflow");
				return 0;
			}
			else
			{
				int x = a[front++];
				return x;
			}
		}
		
		public int rear() {
			return a[rear];
		}
		public int front() {
			return a[front];
		}
		
		
		public static void main(String args[])
		{
			Queue s = new Queue();
			s.enqueue(10);
			s.enqueue(100);
			s.enqueue(10000);
			s.enqueue(100000);
			
			
			System.out.println(s.dequeue() + " Popped from que");
			System.out.println(s.dequeue() + " Popped from que");
			System.out.println(s.rear());
			System.out.println(s.front());
		}
	
	}

	// Driver code
	
	



