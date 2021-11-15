/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author dam
 */
public class ControlPanel extends JPanel {

    Container pane;
    JPanel panel;
    GridBagConstraints c = new GridBagConstraints();

    public ControlPanel(Container pane) {
        this.panel = new JPanel();
        this.pane = pane;
    }

    public ControlPanel getPanel() {
        return this;
    }

    public GridBagConstraints getC() {
        return c;
    }

    public void createPanel() {
        JButton button;

        pane.setLayout(new GridBagLayout());
        pane.setBackground(Color.BLACK);
        pane.setPreferredSize(new Dimension(50, 100));
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        button = new JButton("Button 1");

        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;

        pane.add(button, c);

    }
}
