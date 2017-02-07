import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author hugomarques
 *         2/6/17.
 */
public class DequeTest {

    private Deque<String> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<String>();
    }

    @Test
    public void emptyDeque_isEmpty() throws Exception {
        assertEquals(0, deque.size());
    }

    @Test
    public void emptyDeque_size() throws Exception {
        assertEquals(0, deque.size());
    }

    @Test
    public void deque_addFirst_1element() throws Exception {
        deque.addFirst("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_addLast_1element() throws Exception {
        deque.addLast("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_removeFirst_1element() throws Exception {
        deque.addFirst("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Hugo", deque.removeFirst());
        assertEquals(0, deque.size());
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void deque_removeLast_1element() throws Exception {
        deque.addLast("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Hugo", deque.removeLast());
        assertEquals(0, deque.size());
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void deque_addFirst_2elements() throws Exception {
        deque.addFirst("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addFirst("Hugo2");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_addLast_2elements() throws Exception {
        deque.addLast("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addLast("Hugo2");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_removeFirst_2elements() throws Exception {
        deque.addFirst("Hugo");
        deque.addLast("Marques");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Hugo", deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Marques", deque.removeFirst());
        assertEquals(0, deque.size());
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void deque_removeLast_2elements() throws Exception {
        deque.addFirst("Hugo");
        deque.addLast("Marques");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Marques", deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        assertEquals("Hugo", deque.removeLast());
        assertEquals(0, deque.size());
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void deque_addFirst_3elements() throws Exception {
        deque.addFirst("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addFirst("Hugo2");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addFirst("Hugo3");
        assertEquals(3, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_addLast_3elements() throws Exception {
        deque.addLast("Hugo");
        assertEquals(1, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addLast("Hugo2");
        assertEquals(2, deque.size());
        assertEquals(false, deque.isEmpty());
        deque.addLast("Hugo3");
        assertEquals(3, deque.size());
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void deque_removeFirst_3elements() throws Exception {
        deque.addFirst("Hugo");
        deque.addFirst("Hugo2");
        deque.addFirst("Hugo3");
        assertEquals(3, deque.size());
        assertEquals("Hugo3", deque.removeFirst());
        assertEquals("Hugo2", deque.removeFirst());
        assertEquals("Hugo", deque.removeFirst());
    }

    @Test
    public void deque_removeLast_3elements() throws Exception {
        deque.addLast("Hugo");
        deque.addLast("Hugo2");
        deque.addLast("Hugo3");
        assertEquals(3, deque.size());
        assertEquals("Hugo3", deque.removeLast());
        assertEquals("Hugo2", deque.removeLast());
        assertEquals("Hugo", deque.removeLast());
    }

    @Test
    public void iterator() throws Exception {

    }

}