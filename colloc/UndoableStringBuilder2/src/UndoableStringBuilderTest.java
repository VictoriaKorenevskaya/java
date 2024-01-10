import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UndoableStringBuilderTest {

    @Test
    public void testAppendAndUndo() {
        UndoableStringBuilder builder = new UndoableStringBuilder();
        builder.append("Hello, ");
        builder.append("world!");

        assertEquals("Hello, world!", builder.toString());

        builder.undo();
        assertEquals("Hello, ", builder.toString());

        builder.undo();
        assertEquals("", builder.toString());

        builder.undo(); 
        assertEquals("", builder.toString());
    }

    @Test
    public void testDeleteAndUndo() {
        UndoableStringBuilder builder = new UndoableStringBuilder();
        builder.append("This is a test string.");

        builder.delete(10, 14);
        assertEquals("This is test string.", builder.toString());

        builder.undo();
        assertEquals("This is a test string.", builder.toString());

        builder.undo(); 
        assertEquals("This is a test string.", builder.toString());
    }
}