package controller;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Controller for text field highlight when get focus.
 *
 *
 */
public class TextFieldFocusController implements FocusListener {

    private JTextField text;

    /**
     * Constructor
     *
     * @param text TextField to get focus
     */
    public TextFieldFocusController(JTextField text) {
        this.text = text;
    }

    /**
     * Selects the field when get focus.
     *
     * Selects the field when get focus.
     *
     * @param e FocusEvent
     */
    @Override
    public void focusGained(FocusEvent e) {
        text.selectAll();
    }

    /**
     * Does nothing when lose focus.
     *
     * Does nothing when lose focus.
     *
     * @param e FocusEvent
     */
    @Override
    public void focusLost(FocusEvent e) {

    }
}
