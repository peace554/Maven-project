import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WorkingWithBorderLayoutTest {
    WorkingWithBorderLayout app = new WorkingWithBorderLayout();

    @Test
    void borderLabel() {
        JLabel label = app.BorderLabel();
        assertNotNull(label);
        assertEquals("Application Tittle", label.getText());
        assertEquals(JLabel.CENTER, label.getHorizontalAlignment());
    }

    @Test
    void borderPanel() {
        JPanel panel = app.BorderPanel();
        assertNotNull(panel);

        assertTrue(panel.getLayout() instanceof  GridLayout);
        GridLayout layout = (GridLayout) panel.getLayout();
        assertEquals(3, layout.getRows());
        assertEquals(1, layout.getColumns());

        assertEquals(3, panel.getComponentCount());
        assertTrue(panel.getComponent(0) instanceof JButton);
        assertEquals("Option-1", ((JButton) panel.getComponent(0)).getText());
    }

    @Test
    void borderScroller() {
        JScrollPane scroller = (JScrollPane) app.BorderScroller();
        assertNotNull(scroller);

        assertEquals(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, scroller.getVerticalScrollBarPolicy());
        assertEquals(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, scroller.getHorizontalScrollBarPolicy());

        Component view = scroller.getViewport().getView();
        assertTrue(view instanceof JTextArea);
        JTextArea textArea = (JTextArea) view;
        assertEquals("Type here.....", textArea.getText());
        assertTrue(textArea.getLineWrap());
    }

    @Test
    void submitButton() {
        JButton button = app.SubmitButton();
        assertNotNull(button);
        assertEquals("Submit", button.getText());
    }
}