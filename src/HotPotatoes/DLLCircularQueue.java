/**
 * CSC-223 Queue Tester
 * DUE DATE: Thursday, October 25th, 2018
 * DATE SUBMITTED: Thursday, October 25th, 2018
 * PROGRAMMED BY: Quang Bui
 * CLASS DESCRIPTION: DLLCircularQueue class will implementation
 * from the QueueADT interface. DLLCircularQueue will define all the
 * method in the QueueADT interface. This class will connect all
 * node (DLLNode) to form the Queue. It have function: enqueue,
 * dequeue, output the information of Player + include the Player
 * who will start the game, remove whoWasOred,
 * check the queue is Empty, and the number of Player in the queue
 */
 
package HotPotatoes;


/**
 * @author A. Wright
 * CLASS DESCRIPTION: DLLCircularQueue class will implementation
 * from the QueueADT interface. DLLCircularQueue will define all the
 * method in the QueueADT interface. This class will connect all
 * node (DLLNode) to form the Queue. It have function: enqueue,
 * dequeue, output the information of Player + include the Player
 * who will start the game, remove whoWasOred,
 * check the queue is Empty, and the number of Player in the queue
 */
public class DLLCircularQueue<Type> implements QueueADT<Type> {
   private int count;
   private DLLNode<Type> head, tail;
   
   /**
    * C O N S T R U C T O R
    */
   public DLLCircularQueue() {
      count = 0;
      head = tail = null;
   }
   
    /**
     * Mutator: enqueue() Add an element to the end of the queue (tail)
     *
     */
    public void enqueue(Type elem) {
        DLLNode<Type> node = new DLLNode<Type>(elem);
        if(this.isEmpty()){
            node.setPrevious(null);
            node.setNext(null);
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            tail.setNext(head);
            head.setPrevious(tail);
        }
        count++;
    }
   /**
    * Mutator: dequeue() Removes the first item from the head
    * of the queue
    */
   public Type dequeue() throws RuntimeException {
      if (isEmpty()) {
         throw new RuntimeException("Empty queue -- cannot dequeue");
      }
      Type result = head.getElement();
      head = head.getNext();
      count--;

      if (count == 0) // empty queue
      {
         tail = null;
      }

      return result;
   }

   /**
    * Accessor first() -- returns a copy of the item at the front of 
    * the queue; no remove
    * @return copy of the element
    */
   public Type first() throws RuntimeException {
      if (isEmpty()) {
         throw new RuntimeException("Empty queue -- no front element");
      }

      Type result = head.getElement();
      return result;
   }

   /**
    * Accessor: isEmpty() indicates whether or not the queue 
    * has no elements
    */
   public boolean isEmpty() {
      if (head == null) {
         return true;
      } else {
         return false;
      }
   }

   /**
    * Accessor size() reports the number of elements in the queue
    * @return count of items in the queue
    */
   public int size() {
      return count;
   }
   
   /**
    * Mutator: printFormat()
    * Pre-condition: nothing
    * Post-condition: print the line at the appropriate position
    */
   public void printFormat(){
        System.out.println();
        
        for(int i = 1; i <= 98; i++){
            if (i == 1 || i == 14 || i == 62 || i == 80 || i == 98){ 
                System.out.print("+"); 
            }else{ 
                System.out.print("-"); 
            }
        }
    }
    
   /**
    * Mutator: printTile()
    * Pre-condition: printFormat()
    * Post-condition: just print the Title of each column
    */
    public void printTile(){
        printFormat();
        System.out.printf("\n| %-10s | %-45s | %-15s | %-15s |",
                "Order", "Name", "Number Potatoes", 
                "Status");
        printFormat();
    }
    
    /**
    * Mutator: outputInformation()
    * Pre-condition: printFormat(), printTile()
    * Post-condition: output all the information of the Player in the
    * table form if there is at least one Player in the queue;
    * otherwise: just output the Empty queue
    */
    public void outputInformation(){
        try{
            printTile();
            
            DLLNode<Player> current = new DLLNode<Player>();
            current = (DLLNode<Player>)head;
            if(current == null){
                System.out.println("Empty queue\n");
            }else{
                int count = 0;
                do{
                    count++;
                    System.out.printf("\n| %-10d |", count); 
                    current.getElement().displayPlayerInformation();
                    current = current.getNext();
                    printFormat();
                }while(current != head);
            }
            System.out.println("");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    

    /**
     * Accessor: toString() displays the contents of the queue: </br>
     * one element after the other from front to rear
     */
    public String toString() {
        String out = "";
        DLLNode<Type> current = new DLLNode<Type>();
        current = createCircle();
        
        if(current == null){
            out += "Empty queue\n";
        }else{
            do{
                out += current.getElement() + "\n";
                current = current.getNext();
            }while(current != head);
        }
        
        return out;
    }
   
    /**
     * Accessor: createCircle()
     * Pre-conditions: none
     * postconditions: just assign the head's previous pointer to the
     * tail's next pointer and assign the tail's next pointer to the 
     * head's previous pointer
     * @return the head element
     */
    private DLLNode<Type> createCircle(){
        head.setPrevious(tail);
        tail.setNext(head);
        return head;
    }
    
    /**
     * Mutator: displayRanDomPlayer(int postion)
     * @param postion position will be random by HotPotato class
     * Pre-condition: outputInformation(DLLNode<Player> element)
     * Post-condition: using for loop to find the position (randomly by
     * HotPotato class) and output this Player's information
     */
    public void displayRanDomPlayer(int postion){
        DLLNode<Player> elementPosition = new DLLNode<Player>();
        elementPosition = (DLLNode<Player>) head;
        for(int i = 2; i <= postion; i++){
            elementPosition = elementPosition.getNext();
        }
        elementPosition.getElement().setNumPotatoes(2);
        this.outputInformation(elementPosition);
    }
    
    /**
    * Mutator: outputInformation(DLLNode<Player> element)
    * @param element the information of one Player
    * Pre-condition: printFormat(), printTile()
    * Post-condition: output the information of the one Player 
    * (the Player will announce to start the game)
    */
    public void outputInformation(DLLNode<Player> element){
        try{
            printTile();
            System.out.printf("\n| %-10s |", "1"); 
            element.getElement().displayPlayerInformation();
            printFormat();
            System.out.println("");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    /**
     * Mutator: outputPlayerWasORed(int postion, int count)
     * @param postion the position will be deleted (ORed)
     * @param count count = 1 (this is an order)
     * Pre-conditions: setNumPotatoes(int), displayPlayerInformation(),
     * and removeORed(int) method are defined
     * Postconditions: using the for loop to find the position will be
     * deleted and output the information of Player is deleted
     */
    public void outputPlayerWasORed(int postion, int count){
        try{
            DLLNode<Player> elementPosition = new DLLNode<Player>();
            elementPosition = (DLLNode<Player>) head;
            for(int i = 2; i <= postion; i++){
                elementPosition = elementPosition.getNext();
            }
            elementPosition.getElement().setNumPotatoes(0);
            System.out.printf("\n| %-10d |", count); 
            elementPosition.getElement().displayPlayerInformation();
            this.removeORed(postion);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    /**
     * Accessor: getTotalPotatoes()
     * @return the total of number potatoes
     * Pre-conditions: getNumPotatoes() method are defined
     * Postconditions: using for loop to scan all the Player
     * in the Queue and add the number potatoes of each Player
     * to totalPotatoes
     */
    public int getTotalPotatoes(){
        int totalPotatoes = 0;
        DLLNode<Player> numPotatoe = new DLLNode<Player>();
        numPotatoe = (DLLNode<Player>)head;
        for(int scan = 0; scan < size(); scan++){
            totalPotatoes += numPotatoe.getElement().getNumPotatoes();
        }
        return totalPotatoes;
    }
    
    /**
     * Mutator: removeORed(int position)
     * @param position the position needs to find in the queue and delete 
     * Pre-conditions: size(), setPrevious(node), setNext(node)
     * method are defined
     * Postconditions: If the queue is empty, notify there are no
     * Player in the Queue
     * The position is removed is the head position and size() != 1 => move 
     * the head position to next position and remove head
     * The position is removed is the head position and size() == 1 => just
     * assigned head and tail is null
     * The position is removed is the tail position=> move the 
     * tail position in the tail's previous position and delete
     * the tail position
     * The position is removed is any position in the queue. Using the
     * for loop to find the position need to delete and delete it.
     */
    public void removeORed(int position){ // Type element
        DLLNode<Type> elementDelete = new DLLNode<Type>();
        int index = this.size();
        if(index == 0){
            System.out.println("There are no Players in HotPotato Game.");
        }else if(index != 0){
            if(position == 1 && index == 1){
                head = null;
                tail = null;
            }else if(position == 1 && index != 1){
                head = head.getNext();
                head.setPrevious(tail);
                tail.setNext(head);
                count--;
            }else if(position == size()){
                tail = tail.getPrevious();
                tail.setNext(head);
                head.setPrevious(tail);
                count--;
            }else if (position != 1 && position != size()){
                elementDelete = head;
                for(int i = 2; i <= position; i++){
                    elementDelete = elementDelete.getNext();
                }
                elementDelete.getPrevious().
                        setNext(elementDelete.getNext());
                elementDelete.getNext().
                        setPrevious(elementDelete.getPrevious());
                count--;
            }
        }
    }
}