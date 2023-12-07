package filess;

import org.junit.jupiter.api.*;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class Minitester {}

class Part1Test {

    // ==================== MY DOUBLY LINKED LIST TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("MyDLL add() test1")
    public void shouldAdd() {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();

        list.add(2);
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(0);  // {0, 9, 5, 2}

        assertEquals(4, list.getSize());
        assertEquals(0, list.peekFirst());
        assertEquals(2, list.peekLast());

        list = new MyDoublyLinkedList<>();
        list.add(2);
        list.add(5);
        list.addLast(9);
        list.addFirst(0);  // {0, 2, 5, 9}

        assertEquals(4, list.getSize());
        assertEquals(0, list.peekFirst());
        assertEquals(9, list.peekLast());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL remove() test1")
    public void shouldRemove() {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Number removedItem = list.removeFirst();  // {2, 3}

        assertEquals(1, removedItem);
        assertEquals(2, list.peekFirst());
        assertEquals(2, list.getSize());

        list = new MyDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(4);
        list.addFirst(5);  // {5, 4, 1, 2, 3}

        removedItem = list.removeLast();

        assertEquals(3, removedItem);
        assertEquals(2, list.peekLast());
        assertEquals(4, list.getSize());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL exception handling test1")
    public void shouldThrowExceptionOnEmptyList() {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> list.peekLast());
        assertThrows(NoSuchElementException.class, () -> list.peekFirst());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL peek() test1")
    public void shouldPeek() {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();

        list.addLast(1);
        list.add(2);
        list.addFirst(3);

        assertEquals(3, list.peekFirst());
        assertEquals(2, list.peekLast());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL clear() test1")
    public void shouldClear() {
        MyDoublyLinkedList<Number> list = new MyDoublyLinkedList<>();

        list.addLast(1);
        list.add(2);
        list.addFirst(3);

        list.clear();

        assertEquals(0, list.getSize());
        assertFalse(list.iterator().hasNext());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL equals() test1")
    public void shouldCheckEquals() {
        MyDoublyLinkedList<Number> list1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Number> list2 = new MyDoublyLinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        assertTrue(list1.equals(list2));
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyDLL equals() test2")
    public void shouldCheckNotEquals() {
        MyDoublyLinkedList<Number> list1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Number> list2 = new MyDoublyLinkedList<>();

        list1.add(1);
        list1.add(2);

        list2.add(2);
        list2.add(1);

        assertFalse(list1.equals(list2));
    }


    // ==================== MYQUEUE TEST =================== //

    @Test
    @Tag("score:2")
    @DisplayName("MyQueue enqueue(), dequeue() and clear() test")
    public void shouldEnqueueAndDequeue() {
        MyQueue<Number> queue = new MyQueue<Number>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertFalse(queue.isEmpty());

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.dequeue(), 3);

        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.clear();

        assertTrue(queue.isEmpty());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyQueue equals() test")
    public void shouldCheckEqual() {
        MyQueue<Number> queue1 = new MyQueue<Number>();
        MyQueue<Number> queue2 = new MyQueue<Number>();

        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);

        assertTrue(queue1.equals(queue2));
    }

    // ==================== MYSTACK TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("MyStack push() and pop() test1")
    public void shouldPush() {
        MyStack<Number> stack = new MyStack<Number>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(stack.getSize(), 3);
        assertEquals(stack.peek(), 3);

        Number popped = stack.pop();

        assertEquals(3, popped);
        assertEquals(2, stack.getSize());
        assertEquals(2, stack.peek());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyStack isEmpty() test1")
    public void shouldReturnIsEmpty() {
        MyStack<Number> stack = new MyStack<Number>();
        assertTrue(stack.isEmpty());
    }

    @Test
    @Tag("score:1")
    @DisplayName("MyStack clear() test1")
    public void shouldReturnClear() {
        MyStack<Number> stack = new MyStack<Number>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }
}


class Part2Test {

    // ==================== POSITION CLASS TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("Position move() test1")
    void positionMoveDir1() {
        Position pos = new Position(7, 5);
        pos.moveWest();
        pos.moveNorth();

        assertEquals(6, pos.getX());
        assertEquals(4, pos.getY());

        pos = new Position(7, 5);
        pos.moveEast();
        pos.moveSouth();

        assertEquals(8, pos.getX());
        assertEquals(6, pos.getY());
    }

    @Test
    @Tag("score:1")
    @DisplayName("Position reset() test1")
    void positionReset1() {
        Position pos = new Position(7, 5);

        pos.reset(6, 9);

        assertEquals(6, pos.getX());
        assertEquals(9, pos.getY());

        Position pos2 = new Position(9, 6);

        pos.reset(pos2);
        assertEquals(9, pos.getX());
        assertEquals(6, pos.getY());
    }


    @Test
    @Tag("score:1")
    @DisplayName("Position equals() test1")
    void positionEqual1() {
        Position pos = new Position(7, 5);
        Position pos2 = new Position(9, 6);

        assertFalse(pos.equals(pos2));

        pos2.reset(pos);

        assertTrue(pos.equals(pos2));
    }

    // Testing Basic movement functionality
    @Test
    void posMove_1(){
        Position p = new Position(0,0);
        p.moveNorth();
        assertEquals(new Position(0, -1), p);
        p.moveEast();
        assertEquals(new Position(1, -1), p);
        p.moveSouth();
        assertEquals(new Position(1, 0), p);
        p.moveWest();
        assertEquals(new Position(0, 0), p);
    }


    // ==================== TARGETQUEUE CLASS TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("TargetQueue addTargets() test1")
    void  tqAddTargets1() {
        TargetQueue test = new TargetQueue();
        assertTrue(test.isEmpty());

        test.addTargets("(7,5)");
        assertFalse(test.isEmpty());

        Position pos = new Position(7, 5);
        assertEquals(pos, test.dequeue());
    }

    @Test
    @Tag("score:2")
    @DisplayName("TargetQueue addTargets() test2")
    void  tqAddTargets2() {
        TargetQueue test = new TargetQueue();

        test.addTargets("(7,5).(0,5).(2,3)");

        Position pos = new Position(7, 5);
        Position pos2 = new Position(0, 5);
        Position pos3 = new Position(2, 3);

        assertFalse(test.isEmpty());

        assertEquals(pos, test.dequeue());
        assertEquals(pos2, test.dequeue());
        assertEquals(pos3, test.dequeue());

    }

    @Test
    @Tag("score:1")
    @DisplayName("TargetQueue addTargets() test3")
    void  tqAddTargets3() {
        TargetQueue test = new TargetQueue();

        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(7,5)(0,5)"));
    }

    @Test
    @Tag("score:1")
    @DisplayName("TargetQueue addTargets() test4")
    void  tqAddTargets4() {
        TargetQueue test = new TargetQueue();

        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(7,1).(0,)"));
    }

    @Test
    @Tag("score:5")
    @DisplayName("TargetQueue addTargets() GitHub Test 1 - Killua")
    void  tqAddTargets5() {
        TargetQueue test = new TargetQueue();

        test.addTargets("(1,2).(3,4).(5,6).");

        Position pos = new Position(1, 2);
        Position pos2 = new Position(3, 4);
        Position pos3 = new Position(5, 6);

        assertFalse(test.isEmpty());

        assertEquals(pos, test.dequeue());
        assertEquals(pos2, test.dequeue());
        assertEquals(pos3, test.dequeue());

        // Should not have any error even with "." at the end
        // https://edstem.org/us/courses/32649/discussion/2716504

    }

    @Test
    @Tag("score:5")
    @DisplayName("TargetQueue addTargets() GitHub Test 2 - Killua")
    void  tqAddTargets6() {
        TargetQueue test = new TargetQueue();

        test.addTargets(".");

        assertTrue(test.isEmpty());

        // Should not have any error even with just "." as the queue should just be empty
        // https://edstem.org/us/courses/32649/discussion/2716504
    }

    @Test
    @Tag("score:5")
    @DisplayName("TargetQueue addTargets() GitHub Test 3 - Killua")
    void  tqAddTargets7() {
        TargetQueue test = new TargetQueue();

        test.addTargets(".(1,2).(3,4)");

        assertFalse(test.isEmpty());

        Position pos = new Position(1, 2);
        Position pos2 = new Position(3, 4);

        assertEquals(pos, test.dequeue());
        assertEquals(pos2, test.dequeue());

        // Should not have any error even with "." in front
        // https://edstem.org/us/courses/32649/discussion/2716504
    }

    @Test
    @Tag("score:5")
    @DisplayName("TargetQueue addTargets() GitHub Test 4 - Killua")
    void  tqAddTargets8() {
        TargetQueue test = new TargetQueue();

        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1,2)..(3,4)"));

        // Should throw error since there is more than one period between each position
        // https://edstem.org/us/courses/32649/discussion/2716504
    }

    @Test
    @Tag("score:5")
    @DisplayName("TargetQueue addTargets() GitHub Test 5 - Killua")
    void  tqAddTargets9() {
        TargetQueue test = new TargetQueue();

        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1, 2).(3,4)"));

        // Should throw error when there is a space between characters
        // https://edstem.org/us/courses/32649/discussion/2754324
    }

    @Test
    @Tag("score:1")
    @DisplayName("TargetQueue clear() test")
    void  tqClear() {
        TargetQueue test = new TargetQueue();

        test.addTargets("(7,5)");
        assertFalse(test.isEmpty());

        test.clear();
        assertTrue(test.isEmpty());
    }

    @Test
    void tqAddTargets_1(){
        TargetQueue test = new TargetQueue();
        test.addTargets(".");
        assertTrue(test.isEmpty());
    }

    // front and back period
    @Test
    void tqAddTargets_2(){
        TargetQueue test = new TargetQueue();
        test.addTargets(".(0,0).");
        assertEquals(test.dequeue(), new Position(0,0));
        assertTrue(test.isEmpty());
    }

    @Test
    void tqAddTargets_3(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("..(0,0)."));
    }

    // Nothing as input
    @Test
    void tqAddTargets_4(){
        TargetQueue test = new TargetQueue();
        test.addTargets("");
        assertTrue(test.isEmpty());
    }

    // Just a space as input
    @Test
    void tqAddTargets_5(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets(" "));
    }

    // Null input
    @Test
    void tqAddTargets_6(){
        TargetQueue test = new TargetQueue();
        assertThrows(NullPointerException.class,
                () -> test.addTargets(null));
    }

    // Letter in coordinate
    @Test
    void tqAddTargets_7(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(0,0).(1,1).(0,a)"));
    }

    // Multi Digit Position Input
    @Test
    void tqAddTargets_8(){
        TargetQueue test = new TargetQueue();
        test.addTargets("(0,0).(100,9000)");
        assertEquals(test.dequeue(), new Position(0,0));
        assertEquals(test.dequeue(), new Position(100,9000));
        assertTrue(test.isEmpty());
    }

    // Mad periods
    @Test
    void tqAddTargets_9(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("....."));
    }

    // straight up no periods
    @Test
    void tqAddTargets_10(){
        TargetQueue test = new TargetQueue();
        test.addTargets("(0,0)");
        assertEquals(test.dequeue(), new Position(0,0));
        assertTrue(test.isEmpty());
    }

    // missing second half
    @Test
    void tqAddTargets_11(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1,"));
    }

    // missing second parenthesis
    @Test
    void tqAddTargets_12(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1,2"));
    }

    // just one number
    @Test
    void tqAddTargets_13(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12)"));
    }

    // wierd minus sign placement
    @Test
    void tqAddTargets_15(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,1-3)"));
    }

    // wierd minus sign placement pt2
    @Test
    void tqAddTargets_16(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,13-)"));
    }

    // float coordinates
    @Test
    void tqAddTargets_17(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,1.3)"));
    }

    // empty but properly formatted I suppose?
    @Test
    void tqAddTargets_18(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(,)"));
    }

    // properly formatted but spaces in between (in coordinate)
    @Test
    void tqAddTargets_19(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1, 3)"));
    }

    // properly formatted but spaces in between (between coordinates)
    @Test
    void tqAddTargets_20(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(1,3). (1,3)"));
    }

    // properly formatted with leading 0
    @Test
    void tqAddTargets_21(){
        TargetQueue test = new TargetQueue();
        test.addTargets("(03,05)");
        assertEquals(test.dequeue(), new Position(3,5));
        assertTrue(test.isEmpty());
    }

    // multiple .
    void tqAddTargets_22(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,2)..(2,212133)."));
    }

    // extra (
    void tqAddTargets_23(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("((12,2).(2,212133)"));
    }

    // extra )
    void tqAddTargets_24(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,2)).(2,212133)"));
    }

    // extra ()
    void tqAddTargets_25(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("((12,2)).(2,212133)"));
    }

    // extra ) at the end
    void tqAddTargets_26(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("(12,2).((2,212133))"));
    }

    //extra () wrapping string
    void tqAddTargets_27(){
        TargetQueue test = new TargetQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.addTargets("((12,2).(2,212133))"));
    }

    // Testing clear function
    @Test
    void tqClear_1(){
        TargetQueue test1 = new TargetQueue();
        TargetQueue test2 = new TargetQueue();
        test1.addTargets("(0,0).(1,1).(0,3)");
        test1.clear();
        assertTrue(test1.isEmpty());
        assertEquals(test1, test2);
    }

    // ==================== ACTIONQUEUE CLASS TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("ActionQueue loadFromEncodedString() test1")
    void  aqLoadFromEncodedString1() {
        ActionQueue test = new ActionQueue();

        test.loadFromEncodedString("3[E]"); // {East, East, East}
        for (int i = 0; i < 3; i++) {
            assertEquals(Direction.EAST, test.dequeue());
        }
    }

    @Test
    @Tag("score:1")
    @DisplayName("ActionQueue loadFromEncodedString() test2")
    void  aqLoadFromEncodedString2() {
        ActionQueue test = new ActionQueue();

        test.loadFromEncodedString("3[N]2[S]1[W]"); // { North, North, North, South, South, West }
        for (int i = 0; i < 6; i++) {
            if (i < 3){
                assertEquals(Direction.NORTH, test.dequeue());
            } else if (i < 5) {
                assertEquals(Direction.SOUTH, test.dequeue());
            } else {
                assertEquals(Direction.WEST, test.dequeue());
            }
        }
    }

    @Test
    @Tag("score:1")
    @DisplayName("ActionQueue loadFromEncodedString() test3")
    void  aqLoadFromEncodedString3() {
        ActionQueue test = new ActionQueue();

        test.loadFromEncodedString("3[SW]");
        // {South, West, South, West, South, West}

        for (int i = 0; i < 3; i++) {
            assertEquals(Direction.SOUTH, test.dequeue());
            assertEquals(Direction.WEST, test.dequeue());
        }
    }

    @Test
    @Tag("score:1")
    @DisplayName("ActionQueue loadFromEncodedString() test4")
    void  aqLoadFromEncodedString4() {
        ActionQueue test = new ActionQueue();

        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("2S[W]"));
    }

    @Test
    @Tag("score:1")
    @DisplayName("ActionQueue clear() test")
    void  aqClear() {
        ActionQueue test = new ActionQueue();

        test.loadFromEncodedString("3[E]");
        assertFalse(test.isEmpty());

        test.clear();
        assertTrue(test.isEmpty());
    }

    // Case #1 on A2 Doc
    @Test
    void aqLoadFromEncodedString_1(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("3[N]"); // NNN

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Case #2 on A2 Doc
    @Test
    void aqLoadFromEncodedString_2(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("3[NE]"); // NENENE

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Case #3 on A2 Doc
    @Test
    void aqLoadFromEncodedString_3(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("3[2[N]2[E]]1[S]"); // NNEENNEENNEES

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.SOUTH, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Case #4 on A2 Doc
    @Test
    void aqLoadFromEncodedString_4(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("2E[N]"));
    }

    // Case #5 on A2 Doc
    @Test
    void aqLoadFromEncodedString_5(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("EN]"));
    }

    // Case #6 on A2 Doc
    @Test
    void aqLoadFromEncodedString_6(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("E[EN]"));
    }

    // Case #7 on A2 Doc
    @Test
    void aqLoadFromEncodedString_7(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("A"));
    }

    // No Brackets
    @Test
    void aqLoadFromEncodedString_8(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("EN"); // NNN

        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Wierd Space
    @Test
    void aqLoadFromEncodedString_9(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("[ N]"));
    }

    // k = 0
    @Test
    void aqLoadFromEncodedString_10(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("0[ESSN]");

        assertTrue(test.isEmpty());
    }

    @Test
    void aqLoadFromEncodedString_20(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("2[NS2[W2[E]]]");
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.SOUTH, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.SOUTH, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
    }

    // Empty Brackets
    @Test
    void aqLoadFromEncodedString_11(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("3[]"));
    }

    // Ed post 'using first inductive clause'
    @Test
    void aqLoadFromEncodedString_12(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("NE5[N]"); // NENNNNN

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Ed post 'using first second clause'
    @Test
    void aqLoadFromEncodedString_13(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("2[NE5[N]]"); // NENNNNNNENNNNN

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Doubly nested
    @Test
    void aqLoadFromEncodedString_14(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("2[3[2[N]2[E]]2[W]]"); // NNEENNEENNEEWWNNEENNEENNEEWW

        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.NORTH, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.EAST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());
        assertEquals(Direction.WEST, test.dequeue());

        assertTrue(test.isEmpty());
    }

    // Double bracket
    @Test
    void aqLoadFromEncodedString_15(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("3[[N]]"));
    }

    // Check negative K with action Queue
    @Test
    void aqLoadFromEncodedString_16(){
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("-3[N]"));
    }

    @Test
    void aqLoadFromEncodedString_17() {
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("1[1[]]]["));
    }

    @Test
    void aqLoadFromEncodedString_18() {
        ActionQueue test = new ActionQueue();
        assertThrows(IllegalArgumentException.class,
                () -> test.loadFromEncodedString("3[A]2[3]"));
    }

    // Test clear
    @Test
    void aqClear_1(){
        ActionQueue test = new ActionQueue();
        test.loadFromEncodedString("EEEEENNNNNSSS");
        test.clear();
        assertTrue(test.isEmpty());
    }
}

class Part3Test {

    // ==================== REGION CLASS TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("Region contains() test1")
    void regionContainsTest1() {
        Region region = new Region(0, 0, 5, 5);
        Position goodPos = new Position(2, 4);
        assertTrue(region.contains(goodPos));
    }

    // Strictly Positive Region
    @Test
    void regionContains_1() {
        Region r = new Region(1, 1, 11, 11);

        // Contains in bounds of x and y
        assertTrue(r.contains(new Position(5, 7)));

        // Contains in bounds of x (y is over)
        assertFalse(r.contains(new Position(6, 16)));

        // Contains in bounds of y (x is over)
        assertFalse(r.contains(new Position(12, 7)));

        // Contains in bounds of x (y is under)
        assertFalse(r.contains(new Position(5, 0)));

        // Contains in bounds of y (x is under)
        assertFalse(r.contains(new Position(-14, 7)));

        // Contains x and y out of bounds (over)
        assertFalse(r.contains(new Position(14, 27)));

        // Contains x and y out of bounds (under)
        assertFalse(r.contains(new Position(-14, -7)));
    }

    // Inclusive Test
    @Test
    void regionContains_2() {
        Region r = new Region(1, 1, 11, 11);

        // on x (min)
        assertTrue(r.contains(new Position(1, 5)));
        // on y (min)
        assertTrue(r.contains(new Position(5, 1)));
        // on x and y (min)
        assertTrue(r.contains(new Position(1, 1)));

        // on x (max)
        assertTrue(r.contains(new Position(11, 7)));
        // on y (max)
        assertTrue(r.contains(new Position(5, 11)));
        // on x and y (max)
        assertTrue(r.contains(new Position(11, 11)));
    }

    // ==================== CATERPILLAR CLASS TEST =================== //
    @Test
    @Tag("score:1")
    @DisplayName("Caterpillar constructor test1")
    void caterpillarConstructorTest1() {
        Caterpillar caterpillar = new Caterpillar();
        Position startPos = new Position(7, 7);
        assertEquals(caterpillar.peekFirst(), startPos);
        assertEquals(1, caterpillar.getSize());
        assertEquals(startPos, caterpillar.getHead());
    }

    @Test
    @Tag("score:1")
    @DisplayName("Caterpillar eat() test1")
    void caterpillarEatTest1() {
        Caterpillar caterpillar = new Caterpillar();
        Position adjPos = new Position(8, 7);

        caterpillar.eat(adjPos);

        assertEquals(adjPos, caterpillar.peekFirst());
        assertEquals(2, caterpillar.getSize());
    }

    @Test
    @Tag("score:1")
    @DisplayName("Caterpillar move() test1")
    void caterpillarMoveTest1() {
        Caterpillar caterpillar = new Caterpillar();
        Position adjPos = new Position(8, 7);

        caterpillar.move(adjPos);

        assertEquals(adjPos, caterpillar.peekFirst());
        assertEquals(1, caterpillar.getSize());
    }

    @Test
    @Tag("score:1")
    @DisplayName("Caterpillar selfCollision() test1")
    void caterpillarSelfCollision1() {
        Caterpillar caterpillar = new Caterpillar();
        assertFalse(caterpillar.selfCollision(new Position(7, 9)));
    }

    // ==================== WORLD CLASS TEST =================== //
    @Test // tests if all required private fields are not null when calling constructor
    @Tag("score:1")
    @DisplayName("World constructor test1")
    void worldConstructorTest1() throws IllegalAccessException {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String food = "(9,9)";
        targetQueue.addTargets(food);

        World world = new World(targetQueue, actionQueue);

        Field[] privateWorldFields = World.class.getDeclaredFields();
        for (Field privateField : privateWorldFields) {
            privateField.setAccessible(true);
            Object value = privateField.get(world);
            assertNotNull(value);
        }
    }


    @Test
    @Tag("score:1")
    @DisplayName("World step() test1")
    void worldStepTest1() {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String food = "(7,10)";
        String direction = "2[N]";

        targetQueue.addTargets(food);
        actionQueue.loadFromEncodedString(direction);

        World world = new World(targetQueue, actionQueue);

        world.step();  // move 1 step N from (7,7) to (7,8)

        assertEquals(GameState.MOVE, world.getState());
        assertEquals(1, world.getCaterpillar().getSize());
        assertEquals(new Position(7, 6), world.getCaterpillar().getHead());
    }

    @Test
    @Tag("score:1")
    @DisplayName("World step() test2")
    void worldStepTest2() {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String food = "(5,9)";
        String direction = "10[E]";

        actionQueue.loadFromEncodedString(direction);
        targetQueue.addTargets(food);
        World world = new World(targetQueue, actionQueue);

        //move 9 steps E, wall collision
        for (int i = 0; i < 9; i++) {  // move 9 steps E from (7,7) to (15,7)
            world.step();
        }

        assertEquals(GameState.WALL_COLLISION, world.getState());
        assertEquals(new Position(15, 7), world.getCaterpillar().getHead());
    }
    @Test
    @Tag("score:2")
    @DisplayName("World step() test3")
    void worldStepTest3() throws Exception {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String food = "(9,9).(14,7).(7,10)";
        String direction = "2[S]2[E]" ;

        targetQueue.addTargets(food);
        actionQueue.loadFromEncodedString(direction);

        World world = new World(targetQueue, actionQueue);

        for (int i = 0; i < 4; i++) {  // move 4 steps S from (7,7) to (7,3)
            world.step();
        }

        assertEquals(GameState.EAT, world.getState());
        assertEquals(2, world.getCaterpillar().getSize());
        assertEquals(new Position(9, 9), world.getCaterpillar().getHead());
        assertFalse(targetQueue.isEmpty());
        assertTrue(actionQueue.isEmpty());

    }

    @Test
    @Tag("score:1")
    @DisplayName("World getters test1")
    void worldGetStateTest1() {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String str_target_pos = "(9,9)";
        String str_encoded = "2[E]" ;

        actionQueue.loadFromEncodedString(str_encoded);
        targetQueue.addTargets(str_target_pos);

        World world = new World(targetQueue, actionQueue);

        GameState state = GameState.MOVE;
        assertEquals(world.getState(),state);

        Caterpillar caterpillar = new Caterpillar();
        assertEquals(world.getCaterpillar(), caterpillar);

        Position pos = new Position(9,9);
        assertEquals(world.getFood(), pos);
    }
    @Test
    @Tag("score:1")
    @DisplayName("World isRunning() test1")
    void worldIsRunningTest1() {
        TargetQueue targetQueue = new TargetQueue();
        ActionQueue actionQueue = new ActionQueue();

        String str_target_pos = "(9,9)";
        targetQueue.addTargets(str_target_pos);
        World world = new World(targetQueue, actionQueue);

        world.step();

        assertEquals(world.getState(), GameState.NO_MORE_ACTION);
        assertFalse(world.isRunning());

    }
}

