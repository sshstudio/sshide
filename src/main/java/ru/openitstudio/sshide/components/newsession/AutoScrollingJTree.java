package ru.openitstudio.sshide.components.newsession;

import ru.openitstudio.sshide.App;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.dnd.Autoscroll;

//http://www.java2s.com/Code/Java/Swing-JFC/DnDdraganddropJTreecode.htm
public class AutoScrollingJTree extends JTree implements Autoscroll {
    private int margin = 12;

    public AutoScrollingJTree() {
        super();
        setIcons();
    }

    public AutoScrollingJTree(TreeModel model) {
        super(model);
        setIcons();
    }

    public void setIcons() {
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) this.getCellRenderer();
        Icon closedIcon = new ImageIcon(App.class.getResource("/icons/server-group.png"));
        Icon openIcon = new ImageIcon(App.class.getResource("/icons/server-group.png"));
        Icon leafIcon = new ImageIcon(App.class.getResource("/icons/server.png"));
        renderer.setClosedIcon(closedIcon);
        renderer.setOpenIcon(openIcon);
        renderer.setLeafIcon(leafIcon);
    }

    public void autoscroll(Point p) {
        int realrow = getRowForLocation(p.x, p.y);
        Rectangle outer = getBounds();
        realrow = (p.y + outer.y <= margin ? realrow < 1 ? 0 : realrow - 1
                : realrow < getRowCount() - 1 ? realrow + 1 : realrow);
        scrollRowToVisible(realrow);
    }

    public Insets getAutoscrollInsets() {
        Rectangle outer = getBounds();
        Rectangle inner = getParent().getBounds();
        return new Insets(inner.y - outer.y + margin, inner.x - outer.x + margin,
                outer.height - inner.height - inner.y + outer.y + margin,
                outer.width - inner.width - inner.x + outer.x + margin);
    }

    // Use this method if you want to see the boundaries of the
    // autoscroll active region

//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Rectangle outer = getBounds();
//		Rectangle inner = getParent().getBounds();
//		g.setColor(Color.red);
//		g.drawRect(-outer.x + 12, -outer.y + 12, inner.width - 24, inner.height - 24);
//	}

}
